package com.luxsoft.cfdi

import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante
import org.springframework.security.access.annotation.Secured
import com.luxsoft.kio.Cliente

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class CfdiController {

    def index(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		[cfdiInstanceList:Cfdi.list(params), cfdiInstanceCount: Cfdi.count()]
	}
	
	def show(Cfdi cfdi){
		def cliente=Cliente.findByNombre(cfdi.receptor)
		def model=[cfdiInstance:cfdi]
		if(cliente){
			model.correoDeEnvio=cliente.emailCfdi
		}
		return model
		
	}
	
	def mostrarXml(long id){
		def cfdi=Cfdi.findById(id)
		//render view:'cfdiXml',model:[cfdiInstance:cfdi,xml:cfdi.getComprobanteDocument().xmlText()]
		render(text: cfdi.comprobanteDocument.xmlText(), contentType: "text/xml", encoding: "UTF-8")
	}
	
	def descargarXml(long id){
		Cfdi cfdi=Cfdi.findById(id)
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"$cfdi.xmlName\"")
		response.outputStream << cfdi.getComprobanteDocument().newInputStream()
		
	}
	
	def imprimir(Cfdi cfdi){
		
		
		Comprobante cfd=cfdi.getComprobante()
		def conceptos=cfd.getConceptos().getConceptoArray()
		
		def modelData=conceptos.collect { cc ->
			
			def res=[
			'cantidad':cc.getCantidad()
			 ,'NoIdentificacion':cc.getNoIdentificacion()
			 ,'descripcion':cc.getDescripcion()
			 ,'unidad':cc.getUnidad()
			 ,'ValorUnitario':cc.getValorUnitario()
			 ,'Importe':cc.getImporte()
			 ]
			return res
		}
		def repParams=CfdiPrintUtils.resolverParametros(cfdi)
		File logoFile = grailsApplication.mainContext.getResource("images/kyo_logo.png").file

		if(logoFile.exists()){
			repParams['EMPRESA_LOGO']=logoFile
		}

		params<<repParams
		params.FECHA=cfd.fecha.getTime().format("yyyy-MM-dd'T'HH:mm:ss")

		
		println 'Generando PDF de CFDI: '+repParams
		//println 'LOGO: '+ logoFile
		chain(controller:'jasper',action:'index',model:[data:modelData],params:params)

		
	}

	def mandarCorreo(CfdiMail command){
		command.validate()
		if(command.hasErrors()){
			flash.message="Errores en parametros para envio de correo ${command.errors}"
			redirect action:'show',params:[id:command?.cfdi?.id]
		}
		sendMail{
			multipart true
			to command.mail
			subject "CFDI: $command.cfdi.folio"
			from "noreplay@kyo.mx"
			body "PENDIENTE"
			attachBytes "${command.cfdi.xmlName}", "text/xml", command.cfdi.xml
		}
		flash.message="Correo enviado"
		redirect action:'show',params:[id:command.cfdi.id]

	}
}

class CfdiMail{
	Cfdi cfdi
	String mail

	static constraints={
		mail email:true
	}
}
