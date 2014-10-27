package com.luxsoft.kio

class SocioLog {

	Long socioId
	String nomeroDeSocio
	String nombre
	String numeroDeTarjeta
	Boolean activo
	Date replicado

	Date dateCreated
	Date lastUpdated

    static constraints = {
    	replicado nullable:true
    }
}
