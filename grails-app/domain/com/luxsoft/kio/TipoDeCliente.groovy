package com.luxsoft.kio

class TipoDeCliente {

	String clave
	String descripcion

    static constraints = {
    	clave nullable:false,unique:true,maxSize:20
    	descripcion nullable:false
    }

    String toString(){
    	return clave
    }
}
