package com.luxsoft.kio

class AccessLog {

	Long numero
	String nombre
	String tarjeta
	Boolean activo
	Date replicado

	Date dateCreated
	Date lastUpdated

    static constraints = {
    	replicado nullable:true
    }

}
