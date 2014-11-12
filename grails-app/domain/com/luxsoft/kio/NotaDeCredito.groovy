package com.luxsoft.kio

import com.luxsoft.cfdi.Cfdi
import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(excludes='id,version',includeNames=true,includePackage=false)
class NotaDeCredito  {

	@BindingFormat('dd/MM/yyyy')
	String fecha
	
	Cliente cliente
	
	BigDecimal importe

	BigDecimal impuestoTasa=0.16

	BigDecimal impuestos

	BigDecimal total
	
	BigDecimal aplicado
	
	BigDecimal disponible
	
	String comentario

	String tipo

	Cfdi cfdi

	Date dateCreated

	Date lastUpdated
    
	
	static mapping = {
		aplicaciones cascade: "all-delete-orphan"
	}

	static constraints = {
    	tipo inList:['DESCUENTO','BONIFICACION','DEVOLUCION']
    	comentario nullable:true, maxSize:300
    	cfdi nulllable:true
    }
	
	
}
