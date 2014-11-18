package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes="cliente,formaDePago,importe",includeNames=true,includePackage=false)
class Cobro {

	Venta venta
	
	Cliente cliente

	Pago pago

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	FormaDePago formaDePago

	BigDecimal recibe

	BigDecimal cambio

	BigDecimal importe

	String referencia

	Date dateCreated

	Date lastUpdated
	

    static constraints = {
		referencia nullable:true,maxSize:50
		dateCreated nullable:true
		lastUpdated nullable:true
    }

    
}
