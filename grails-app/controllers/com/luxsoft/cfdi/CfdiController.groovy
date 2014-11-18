package com.luxsoft.cfdi

import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class CfdiController {

    def index(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		[cfdiInstanceList:Cfdi.list(params), cfdiInstanceCount: Cfdi.count()]
	}
	
	def show(Cfdi cfdi){
		[cfdiInstance:cfdi]
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
		params<<repParams
		params.FECHA=cfd.fecha.getTime().format("yyyy-MM-dd'T'HH:mm:ss")
		chain(controller:'jasper',action:'index',model:[data:modelData],params:params)

		
	}
}
