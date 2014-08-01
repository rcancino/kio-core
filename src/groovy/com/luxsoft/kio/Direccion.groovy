package com.luxsoft.kio

import grails.validation.Validateable;


@Validateable(nullable=true)
class Direccion implements Serializable{
	
	String calle
	String numeroInterior
	String numeroExterior
	String colonia
	String municipio
	String codigoPostal
	String estado
	String pais='MEXICO'

	
    static constraints = {
		calle(nullable:true,size:1..200)
		numeroInterior(size:1..50,nullable:true)
		numeroExterior(size:1..50,nullable:true)
		colonia(nullable:true)
		municipio(nullable:true)
		codigoPostal(nullable:true)
		estado(nullable:true)
		pais(nullable:true,size:1..100)
    }
	
	String toString(){
		return "${calle} ${numeroInterior?:''} ${numeroExterior?:''} ${colonia}"
	}
}