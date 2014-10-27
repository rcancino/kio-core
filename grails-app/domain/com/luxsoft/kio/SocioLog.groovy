package com.luxsoft.kio

class SocioLog {

	Long socio_id
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
