package com.luxsoft.kio

class AccessLog {

	Long numero
	String nombre
	String tarjeta
	Boolean activo
	Date replicado
	Date lectora1
	Date lectora2
	Date lectora3

	Date dateCreated
	Date lastUpdated

    static constraints = {
    	replicado nullable:true
    	tarjeta nullable:true
    	lectora1 nullable:true
    	lectora2 nullable:true
    	lectora3 nullable:true
    }

}
