package com.luxsoft.kio


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.Validateable

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef
import org.apache.commons.lang.WordUtils
import org.grails.databinding.BindingFormat

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class ReportController {

	def jasperService

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
		repParams['FECHA_INICIAL']=command.fechaInicial
		repParams['FECHA_FINAL']=command.fechaFinal
		repParams['reportName']=command.reportName
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:repParams.reportName)
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
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:repParams.reportName)
	}

	def cobranza(FechaCommand command){
		def repParams=[:]
		repParams['FECHA']=command.fecha
		repParams['reportName']=command.reportName
		ByteArrayOutputStream  pdfStream=runReport(repParams)
		render(file: pdfStream.toByteArray(), contentType: 'application/pdf'
			,fileName:repParams.reportName)
	}

	private runReport(Map repParams){
		File logoFile = grailsApplication.mainContext.getResource("images/kyo_logo.png").file

		if(logoFile.exists()){
			repParams['EMPRESA_LOGO']=logoFile.newInputStream()
		}
		def nombre=WordUtils.capitalize(repParams.reportName)
		log.info "Ejectuando reporte $nombre params:"+repParams
		def reportDef=new JasperReportDef(
			name:nombre
			,fileFormat:JasperExportFormat.PDF_FORMAT
			,parameters:repParams
			)
		ByteArrayOutputStream  pdfStream=jasperService.generateReport(reportDef)
		return pdfStream
		
	}
	
	
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
	Date fechaInicial=new Date()
	@BindingFormat('dd/MM/yyyy')
	Date fechaFinal=new Date()

	static constraints={
		fechaInicial nullable:false
		fechaFinal nullable:false
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

