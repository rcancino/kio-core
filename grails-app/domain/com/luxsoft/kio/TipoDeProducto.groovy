package com.luxsoft.kio

class TipoDeProducto {

	String clave
	String descripcion

    static constraints = {
    	clave unique:true
    }

    String toString(){
    	"$clave"
    }
}
