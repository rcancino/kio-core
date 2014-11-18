package com.luxsoft.kio


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.Validateable

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef
import org.apache.commons.lang.WordUtils

@Secured(['ROLE_ADMIN','ADMINISTRACION','MOSTRADOR'])
class ReportController {

	def jasperService

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

	private runReport(Map repParams){
		log.info 'Ejecutando reporte  '+repParams
		def nombre=WordUtils.capitalize(repParams.reportName)
		def reportDef=new JasperReportDef(
			name:nombre
			,fileFormat:JasperExportFormat.PDF_FORMAT
			,parameters:repParams
			)
		ByteArrayOutputStream  pdfStream=jasperService.generateReport(reportDef)
		return pdfStream
		
	}
	
	
}


@Validateable
class PorClienteCommand{

	Cliente cliente
	Date fechaInicial=new Date()-30
	Date fechaFinal=new Date()
	

	static constraints={
		fechaInicial nullable:true
		fechaFinal nullable:true
	}
}

