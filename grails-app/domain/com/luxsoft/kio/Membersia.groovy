package com.luxsoft.kio

class Membersia {
	
	String status='ACTIVO'

	Boolean corporativo=false

	static hasMany = [servicios: ServicioPorSocio]

    static constraints = {
    	status inList:['ACTIVO','SUSPENDIDO','CANCELADO']
    }
    
    static mapping = {
    	servicios cascade: "all-delete-orphan"
    }
}
