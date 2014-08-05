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

    def beforeUpdate() {
    	capitalizarNombre()
    }

    def beforeInsert() {
    	capitalizar()
    }

    private capitalizar(){
    	clave=clave.toUpperCase()
    }
}
