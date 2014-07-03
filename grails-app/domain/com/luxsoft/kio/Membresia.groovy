package com.luxsoft.kio

import org.grails.databinding.BindingFormat

class Membresia {

	
	Servicio servicio 
	
	/**
	* El tipo de esta membresia SEMANAL,MENSUAL,ANUAL etc
	**/
	String tipo

	String status

	/** 
	*	Fecha de inicio de la membresia
	*/
	@BindingFormat('dd/MM/yyyy')
	Date inscripcion

	/** 
	*	Fecha en la que se debe renovar la membresia
	*/
	@BindingFormat('dd/MM/yyyy')
	Date renovacion

	/**
	* Si la membresia se renueva en forma automatica al terminar (Trantandose de todos los tipos excepto la variable)
	**/
	Boolean renovacionAutomatico=true

	/**
	* Si la el cargo de la membresia se debe 
	**/
	Boolean cargoAutomatico=true
	
	/** 
	*	Fecha para el proximo pago
	*/
	@BindingFormat('dd/MM/yyyy')
	Date proximoCargo

	String formaDePago
	
	Boolean especial	//Pendiente de analisis
	BigDecimal precioBruto=0
	BigDecimal descuento=0
	BigDecimal precioNeto=0

	Date suspencion
	String motivoDeSuspencion
	
	Date dateCreated
	Date lastUpdated

	static belongsTo = [socio: Socio]


    static constraints = {
    	tipo inList:['SEMANAL','MENSUAL','TRIMESTRAL','SEMESTRAL','ANUAL','VARIABLE']
    	status inList:['ACTIVA','SUSPENDIDA','CANCELADA']
    	renovacion inList:['MANUAL','AUTOMATICA']
    	suspencion nullable:true
    	motivoDeSuspencion nullable:true
    }


    static mapping = {
    	inscripcion type:'date'
    	
    }

}

