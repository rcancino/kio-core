package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString
//import groovy.transform.EqualsAndHashCode
import org.grails.databinding.BindingFormat

@ToString(includeNames=true,includePackage=false)
//@EqualsAndHashCode(includes='documento,importe')
class Aplicacion {

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	BigDecimal importe

	Long documento
	String documentoFecha
	String documentoTipo
	String comentario

	static belongsTo = [abono: Abono]

    static constraints = {
    	documentoTipo inList:['VENTA']
    	comentario nullable:true
    }

    static mapping = {
		fecha type:'date'
		
	}

    
}
