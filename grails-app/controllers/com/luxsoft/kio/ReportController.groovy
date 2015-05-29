package com.luxsoft.kio


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.Validateable

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef
import org.apache.commons.lang.WordUtils
import org.grails.databinding.BindingFormat

import groovy.sql.Sql


// import pl.touk.excel.export.XlsxExporter
// import pl.touk.excel.export.getters.LongToDatePropertyGetter
// import pl.touk.excel.export.getters.MessageFromPropertyGetter

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class ReportController {

	def jasperService

	def dataSource

	static defaultAction = "index"

	def index(){}

    def comprobantesPorCliente(PorClienteCommand command){
		if(request.method=='GET'){
			return [reportCommand:new PorClienteCommand()]
		}
		command.validate()
		if(command.hasErrors()){
			log.info 'Errores de validacion al ejecurar reporte'
			render view:'comprobantesPorEmisor',model:[reportCommand:command]
			return
		}
		def repParams=[:]

		repParams['NOMBRE']=command.cliente.nombre
		repParams['FECHA_INICIAL']=command.fechaInicial
		repParams['FECHA_FINAL']=command.fechaFinal
		if(command.nombre=='%'){
			repParams['EMISOR_RFC']='%'
		}
		repParams['REFERENCIA']=command.referencia?:'%'
		
		repParams.reportName=params.reportName
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:repParams.reportName)
	}

	def ventasGenerales(PeriodoCommand command){
		if(request.method=='GET'){
			return [reportCommand:new PeriodoCommand()]
		}
		command.validate()
		if(command.hasErrors()){
			flash.message= 'Errores de validacion al ejecurar reporte'
			//render view:params.action,model:
			return [reportCommand:command]
		}

		def repParams=[:]
		repParams['FECHA_INI']=command.fechaInicial
		repParams['FECHA_FIN']=command.fechaFinal
		repParams['reportName']=command.reportName
		def ts=new Date().format('_dd_MM_yyyy_hhmm_')
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:"$repParams.reportName"+ts+".pdf")
	}

	def catalogoDeSocios(){
		if(request.method=='GET'){
			return [tipos:['ACTIVOS','SUSPENDIDOS','TODOS']]
		}
		def repParams=['TIPO':params.tipo]
		repParams['reportName']='CatalogoDeSocios'
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:repParams.reportName)
	}

	def arqueo(ArqueoReportCommand command){
		def repParams=[:]
		repParams['FECHA']=command.fecha
		repParams['CAJERO']=command.fecha
		repParams['reportName']='Arqueo'
		def ts=new Date().format('_dd_MM_yyyy_hhmm_')
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:"$repParams.reportName"+ts+".pdf")
	}

	def cobranza(FechaCommand command){
		def repParams=[:]
		repParams['FECHA']=command.fecha
		repParams['reportName']=command.reportName
		def ts=new Date().format('_dd_MM_yyyy_hhmm_')
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:"$repParams.reportName"+ts+".pdf")
	}

	def ventasPorProducto(PeriodoCommand command){
		if(request.method=='GET'){
			return [reportCommand:new PeriodoCommand()]
		}
		command.validate()
		if(command.hasErrors()){
			flash.message= 'Errores de validacion al ejecurar reporte'
			//render view:params.action,model:
			return [reportCommand:command]
		}

		def repParams=[:]
		repParams['FECHA_INI']=command.fechaInicial
		repParams['FECHA_FIN']=command.fechaFinal
		repParams['reportName']=command.reportName
		repParams['formato']=params.formato
		def ext='pdf'
		def type='application/pdf'
		def ts=new Date().format('_dd_MM_yyyy_hhmm')
		if(repParams.formato=='XLS'){
			// type="application/vnd.ms-excel"
			def sql=new Sql(dataSource)
			def writer=new StringWriter()
			def pwriter=new PrintWriter(writer)
			def rows=sql.rows(VENTAS_POR_PRODUCTO_SQL,[command.fechaInicial,command.fechaFinal])
			def cols
			rows.each{
				if(!cols){
					cols=it.keySet().join(';')
					pwriter.println(cols)
				}
				//pwriter<<it.values().join(',')
				pwriter.println(it.values().join(';'))
			}
			//ByteArrayOutputStream os=new ByteArrayOutputStream(writer.toString().getBytes())
			render(file: writer.toString().getBytes(), contentType: 'text/csv'
				,fileName:"$repParams.reportName"+ts+".csv")

		}else{
			ByteArrayOutputStream  pdfStream=runReport(repParams)
			render(file: pdfStream.toByteArray(), contentType: type
				,fileName:"$repParams.reportName"+ts+"."+ext)
		}
		
	}

	private runReport(Map repParams){
		File logoFile = grailsApplication.mainContext.getResource("images/kyo_logo.png").file

		if(logoFile.exists()){
			//repParams['EMPRESA_LOGO']=logoFile.newInputStream()
			repParams['EMPRESA_LOGO']=logoFile
		}
		def nombre=WordUtils.capitalize(repParams.reportName)
		log.info "Ejectuando reporte $nombre params:"+repParams
		def formato=JasperExportFormat.PDF_FORMAT
		if(repParams.formato=='XLS'){
			formato=JasperExportFormat.XLS_FORMAT
		}
		if(repParams.formato=='CSV'){
			formato=JasperExportFormat.CSV_FORMAT
		}
		def reportDef=new JasperReportDef(
			name:nombre
			,fileFormat:formato
			,parameters:repParams
			)
		ByteArrayOutputStream  pdfStream=jasperService.generateReport(reportDef)
		return pdfStream
	}


	static VENTAS_POR_PRODUCTO_SQL="""
		select v.id,date(v.fecha) as fecha ,c.folio as factura,v.status as status ,p.clave,p.descripcion,d.cantidad,d.precio,d.importe_bruto,d.descuento ,d.importe_neto from venta_det d 
		join venta v on d.venta_id=v.id
		left join cfdi c on v.cfdi_id=c.id
		join producto p on d.producto_id=p.id
		where v.status<>'PEDIDO' 
		and date(v.fecha) between ? and ?
		order by fecha desc
	"""
	
	
}

class ReportCommand{
	String reportName
	static constraints={
		reportName nullable:false
	}
}

@Validateable 
class FechaCommand extends ReportCommand{
	
	@BindingFormat('dd/MM/yyyy')
	Date fecha=new Date()

	static constraints={
		fecha nullable:false
	}
}

@Validateable 
class PeriodoCommand extends ReportCommand{
	@BindingFormat('dd/MM/yyyy')
	Date fechaInicial=new Date()-30
	@BindingFormat('dd/MM/yyyy')
	Date fechaFinal=new Date()

	static constraints={
		fechaInicial nullable:false
		fechaFinal nullable:false
	}

	Periodo toPeriodo(){
		retur new Periodo(fechaInicial,fechaFinal)
	}
}

@Validateable
class PorClienteCommand{

	Cliente cliente
	@BindingFormat('dd/MM/yyyy')
	Date fechaInicial=new Date()-30
	@BindingFormat('dd/MM/yyyy')
	Date fechaFinal=new Date()
	

	static constraints={
		fechaInicial nullable:true
		fechaFinal nullable:true
	}
}

@Validateable
class ArqueoReportCommand {
	String cajero
	Date fecha
}

