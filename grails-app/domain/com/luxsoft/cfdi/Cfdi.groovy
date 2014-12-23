package com.luxsoft.cfdi

import groovy.transform.ToString
import java.io.ByteArrayInputStream
import mx.gob.sat.cfd.x3.ComprobanteDocument
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante

@ToString(includeNames=true,includes="id,serie,folio,tipo,fecha,uuid")
class Cfdi {
	
	String serie
	String folio
	String uuid
	Date timbrado
	String tipo
	Date fecha
	String emisor
	String receptor
	String receptorRfc
	
	BigDecimal total
	
	String cadenaOriginal
	String origen
	String xmlName
	byte[] xml
	
	Date dateCreated
	Date lastUpdated
	
	ComprobanteDocument comprobanteDocument
	TimbreFiscal timbreFiscal

	static hasOne = [cancelacion: CancelacionDeCfdi]

    static constraints = {
		serie blannk:false,maxSize:15
		folio blank:false,maxSize:20
		uuid nullable:true,maxSize:300
		timbrado(nullable:true)
		tipo inList:['FACTURA','NOTA_CREDITO','NOTA_CARGO']
		fecha nullable:false
		emisor blank:false,maxSize:600
		receptor blank:false,maxSize:600
		receptorRfc blank:false,maxSize:13
		xmlName nullable:true,maxSize:200
		xml maxSize:(1024 * 512)  // 50kb para almacenar el xml
		cadenaOriginal maxSize:1024*64, nullable:true 
		origen blank:false,maxSize:255
		cancelacion nullable:true
    }
	
	static transients = ['comprobanteDocument','timbreFiscal']
	
	public Cfdi() {}
	
	public Cfdi(Comprobante c) {
		serie=c.serie
		folio=c.folio
		fecha=c.fecha.getTime()
		emisor=c.emisor.nombre
		receptor=c.receptor.nombre
		receptorRfc=c.receptor.rfc
		total=c.total
	}
	
	Comprobante getComprobante(){
		getComprobanteDocument().getComprobante()
	}
	
	public ComprobanteDocument getComprobanteDocument(){
		if(this.comprobanteDocument==null){
			loadComprobante()
		}
		return this.comprobanteDocument
	}
	
	void loadComprobante(){
		ByteArrayInputStream is=new ByteArrayInputStream(getXml())
		this.comprobanteDocument=ComprobanteDocument.Factory.parse(is)
	}
	
	String toString(){
		return "($emisor) Id:$id  Tipo:$tipo Serie:$serie Folio:$folio  UUID:$uuid xmlName:$xmlName"
	}
}
