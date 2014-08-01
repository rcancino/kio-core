package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import org.joda.time.LocalDate
import org.jadira.usertype.dateandtime.joda.*
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='servicio')
class ServicioPorSocio {

	
	Producto servicio 

	/** 
	*	Fecha de inicio de la membresia
	*/
	@BindingFormat('dd/MM/yyyy')
	Date inscripcion

	/** 
	*	Fecha para el proximo pago
	*/
	//@BindingFormat('dd/MM/yyyy')
	Date proximoCargo
	
	BigDecimal precioBruto=0
	
	BigDecimal descuento=0
	
	BigDecimal precioNeto=0

	Date suspension
	
	String motivoDeSuspension
	
	Date dateCreated

	Date lastUpdated

	//static belongsTo = [socio: Socio]


    static constraints = {
    	suspension nullable:true
    	motivoDeSuspension nullable:true
    	proximoCargo nullable:true
    }


    static mapping = {
    	
    	proxmoPago type:'date'
		//proximoCargo type:PersistentLocalDate
		proximoCargo type:'date'
    	
    }

    String toString(){
    	return "{$servicio} (${socio})"
    }

}

