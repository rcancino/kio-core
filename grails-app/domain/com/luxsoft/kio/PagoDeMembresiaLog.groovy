package com.luxsoft.kio

class PagoDeMembresiaLog {

	AplicacionDePago aplicacion

	SocioMembresia membresia

	Producto servicio

	Integer diaDeCorte

	Date ultimoPago

	Date proximoPago

	Boolean activo
	
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
    	ultimoPago nullable:true
    	proximoPago nullable:true
    }
}
