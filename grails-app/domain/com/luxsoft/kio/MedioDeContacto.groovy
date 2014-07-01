package com.luxsoft.kio

class MedioDeContacto {

	String clave
	String descripcion


    static constraints = {
    	clave unique:true
    	descripcion nullable:true
    }

    String toString(){
    	return "$descripcion ($clave)"
    }
}
