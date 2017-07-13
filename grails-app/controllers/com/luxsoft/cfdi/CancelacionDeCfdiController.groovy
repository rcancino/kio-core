package com.luxsoft.cfdi

import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class CancelacionDeCfdiController {

    def index() { }


    def descargarAcuseXml(long id){
		def c=CancelacionDeCfdi.get(id)
		def cfdi = c.cfdi
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"Cancelacion_$cfdi.xmlName\"")
		response.outputStream << new ByteArrayInputStream(c.aka)
		
	}

	def mostrarAcuse(long id){
		
		def c=CancelacionDeCfdi.get(id)
		String aka=new String(c.getAka())
		//render view:'cfdiXml',model:[cfdiInstance:cfdi,xml:cfdi.getComprobanteDocument().xmlText()]
		render(text: aka, contentType: "text/xml", encoding: "UTF-8")
	}
}
