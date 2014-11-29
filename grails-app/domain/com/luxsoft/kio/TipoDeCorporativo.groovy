package com.luxsoft.kio

class TipoDeCorporativo {
	
    String clave
	String descripcion

    static constraints = {
    	clave nullable:false,unique:true,maxSize:20
    	descripcion nullable:false
    }

    String toString(){
    	return clave
    }

    def beforeUpdate() {
        capitalizar()
    }

    def beforeInsert() {
        capitalizar()
    }

    private capitalizar(){
        clave=clave.toUpperCase()
    }

    
	
}
