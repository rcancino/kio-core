package com.luxsoft.kio

//import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

//@ToString(includes='nombre',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='nombre,rfc')
class Cliente {

	String nombre
	String rfc
	Direccion direccion

	TipoDeCliente tipo

	Date dateCreated
	Date lastUpdated

	static embedded = ['direccion']

	static hasMany = [socios: Socio]

    static constraints = {
    	direccion nullable:true
    }

    static mapping = {
		nombre unique:true
	}

	 String toString(){
    	return "$nombre"
    }

}
