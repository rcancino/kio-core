package com.luxsoft.kio

class TipoDeSocio {

	String clave
	String descripcion

    static constraints = {
    	clave nullable:false,unique:true,maxSize:20
    	descripcion blank:false
    }

    String toString(){
    	return "$descripcion ($clave)"
    }
}
