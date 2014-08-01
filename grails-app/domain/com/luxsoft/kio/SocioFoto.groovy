package com.luxsoft.kio

class SocioFoto {

	Socio socio
	byte[] imagen

	Date dateCreated
	Date lastUpdated

	static belongsTo = [socio: Socio]

    static constraints = {
    	imagen nullable:true,maxSize:(1024 * 1024)
    }

    String toString(){
    	"$id Modificado:$lastUpdated"
    }
}
