package com.luxsoft.kio

//import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

//@ToString(includes='nombre',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='nombre,rfc')
class Cliente {

	String nombre
	String rfc
	Direccion direccion
	String emailCfdi

	TipoDeCliente tipo
	Long origen

	Date dateCreated
	Date lastUpdated

	static embedded = ['direccion']

	static hasMany = [socios: Socio]

    static constraints = {
    	direccion nullable:true
		nombre unique:true
		origen nullable:true
		emailCfdi nullable:true
    }

    static mapping = {
		
	}

	 String toString(){
    	return "$nombre"
    }

}
