package com.luxsoft.cfdi

import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class CancelacionDeCfdiController {

    def index() { }


    def descargarAcuseXml(long id){
		Cfdi cfdi=Cfdi.findById(id)
		CancelacionDeCfdi c=CancelacionDeCfdi.get(id)
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"$cfdi.xmlName\"")
		response.outputStream << cfdi.getComprobanteDocument().newInputStream()
		
	}
}
