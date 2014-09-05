package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes='nombre,fecha,total,disponible',includeNames=true,includePackage=false)
class Abono {
	
	@BindingFormat('dd/MM/yyyy')
	String fecha
	
	Cliente cliente
	
	String nombre
	
	BigDecimal importe
	
	BigDecimal aplicado
	
	BigDecimal disponible
	
	String comentario
	
	List aplicaciones
	
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [aplicaciones:Aplicacion]

    static constraints = {
    }
	
	static mapping = {
		aplicaciones cascade: "all-delete-orphan"
	}
	
	def beforeUpdate(){
		
		nombre=cliente.nombre
	}
	
	def beforeInsert(){
		
		nombre=cliente.nombre
	}
}
