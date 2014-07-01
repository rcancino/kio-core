package com.luxsoft.kio

import org.grails.databinding.BindingFormat

class Membresia {

	//Solia ser el producto
	String servicio 
	
	@BindingFormat('dd/MM/yyyy')
	Date inscripcion

	@BindingFormat('dd/MM/yyyy')
	Date proximoPago
	
	String tipo

	String renovacion

	Date suspencion

	String motivoDeSuspencion
	  
	String diaDePago
	
	Boolean especial	//Pendiente de analisis

	
	Date dateCreated
	Date lastUpdated

	static belongsTo = [socio: Socio]


    static constraints = {
    	tipo inList:['MENSUAL','TRIMESTRAL']
    	renovacion inList:['MANUAL','AUTIMATICA']
    	suspencion nullable:true
    	motivoDeSuspencion nullable:true
    }


    static mapping = {
    	inscripcion type:'date'
    	proximoPago type:'date'
    }

}

