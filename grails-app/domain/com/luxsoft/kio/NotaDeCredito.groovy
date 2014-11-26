package com.luxsoft.kio

import com.luxsoft.cfdi.Cfdi
import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(excludes='id,version',includeNames=true,includePackage=false)
class NotaDeCredito  {

	transient springSecurityService

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

	String usuario
    
    static hasMany = [conceptos: NotaDeCredito,aplicaciones:AplicacionDeNota]

    
	
	static mapping = {
		conceptos cascade: "all-delete-orphan"
		aplicaciones cascade: "all-delete-orphan"
	}

	static constraints = {
    	tipo inList:['DESCUENTO','BONIFICACION','DEVOLUCION']
    	comentario nullable:true, maxSize:300
    	cfdi nullable:true
    }

    static transients = ['estatus','springSecurityService']

    def getEstatus(){
    	return cfdi?'TIMBRADA':'PENDIENTE'
    }

    def beforeInsert() {
		usuario=springSecurityService.getCurrentUser().username
	}
	
	
}
