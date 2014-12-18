package com.luxsoft.cfdi

class CancelacionDeCfdi {

	String comentario
	Cfdi cfdi
	byte[] aka
	byte[] message

	Date dateCreated

    static constraints = {
    	comentario nullable:true
    }
}
