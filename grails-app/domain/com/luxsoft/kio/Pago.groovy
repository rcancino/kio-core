package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='id,nombre,fecha,dateCreated')
@ToString(includes='nombre,fecha,total,disponible,formaDePago',includeNames=true,includePackage=false)
class Pago {

	@BindingFormat('dd/MM/yyyy')
	Date fecha
	
	Cliente cliente

	FormaDePago formaDePago
	
	String banco
	
	String referenciaBancaria
	
	BigDecimal importe=0.0
	
	BigDecimal aplicado=0.0
	
	BigDecimal disponible=0.0
	
	String comentario
	
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [aplicaciones: AplicacionDePago]

    static constraints = {
    	comentario nullable:true, maxSize:300
    	referenciaBancaria nullable:true,maxSize:20
    	banco nullable:true,maxSize:30
    }

    static mapping = {
		aplicaciones cascade: "all-delete-orphan"
	}

	static transients = ['disponible']

	BigDecimal getDisponible(){
		return  importe-aplicado
	}


    
}
