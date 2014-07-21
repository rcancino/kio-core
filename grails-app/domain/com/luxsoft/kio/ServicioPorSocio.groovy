package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import org.joda.time.LocalDate
import org.jadira.usertype.dateandtime.joda.*

class ServicioPorSocio {

	
	Servicio servicio 

	/** 
	*	Fecha de inicio de la membresia
	*/
	@BindingFormat('dd/MM/yyyy')
	Date inscripcion

	/** 
	*	Fecha para el proximo pago
	*/
	//@BindingFormat('dd/MM/yyyy')
	LocalDate proximoCargo
	
	BigDecimal precioBruto=0
	
	BigDecimal descuento=0
	
	BigDecimal precioNeto=0

	Date suspencion
	
	String motivoDeSuspencion
	
	Date dateCreated
	Date lastUpdated

	static belongsTo = [socio: Socio]


    static constraints = {
    	suspencion nullable:true
    	motivoDeSuspencion nullable:true
    	proximoCargo nullable:true
    }


    static mapping = {
    	inscripcion type:'date'
		proximoCargo type:PersistentLocalDate
    	
    }

}

