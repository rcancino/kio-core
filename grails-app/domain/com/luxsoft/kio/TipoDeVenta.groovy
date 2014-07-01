package com.luxsoft.kio

class TipoDeVenta {

	String clave
	String descripcion
	Map formulas

	static hasMany = [formulas: String]

    static constraints = {
    	clave unique:true
    	descripcion blank:false
    }

    String toString(){
    	return clave
    }
    
    def beforeInsert() {
    	clave=clave.toUpperCase()
    }

    def beforeUpdate() {
    	clave=clave.toUpperCase()
    }
    
}
