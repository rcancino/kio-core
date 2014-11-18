package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import org.grails.databinding.BindingFormat

@ToString(includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='documento,importe')
class AplicacionDePago {

	Venta venta 

    @BindingFormat('dd/MM/yyyy')
	Date fecha

	BigDecimal importe

	String comentario

	static belongsTo = [pago: Pago]

    static constraints = {
    	comentario nullable:true
    }

    static mapping = {
		fecha type:'date'
		
	}

}

