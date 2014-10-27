package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes="cliente,formaDePago,importe",includeNames=true,includePackage=false)
class Cobro {

	Venta venta
	
	Cliente cliente

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	FormaDePago formaDePago

	BigDecimal recibe

	BigDecimal cambio

	BigDecimal importe

	Date dateCreated

	Date lastUpdated
	

    static constraints = {
		
    }

    
}
