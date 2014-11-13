package com.luxsoft.kio

import com.luxsoft.cfdi.Cfdi
import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(excludes='id,version',includeNames=true,includePackage=false)
class NotaDeCredito  {

	@BindingFormat('dd/MM/yyyy')
	Date fecha
	
	Cliente cliente
	
	BigDecimal subTotal=0
	BigDecimal impuestoTasa=0.16
	BigDecimal impuesto=0
	BigDecimal total=0
	
	BigDecimal aplicado=0
	BigDecimal disponible=0
	
	String comentario

	String tipo

	Cfdi cfdi

	Date dateCreated

	Date lastUpdated
    
    static hasMany = [conceptos: NotaDeCredito]
	
	static mapping = {
		conceptos cascade: "all-delete-orphan"
	}

	static constraints = {
    	tipo inList:['DESCUENTO','BONIFICACION','DEVOLUCION']
    	comentario nullable:true, maxSize:300
    	cfdi nullable:true
    }

    static transients = ['estatus']

    def getEstatus(){
    	return cfdi?'TIMBRADA':'PENDIENTE'
    }
	
	
}
