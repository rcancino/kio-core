package com.luxsoft.kio

class AccessLog {

	Long numero
	String nombre
	String tarjeta
	Boolean activo
	Date lectora1
	Date lectora2
	Date lectora3
	String info

	Date dateCreated
	Date lastUpdated

    static constraints = {
    	tarjeta nullable:true
    	lectora1 nullable:true
    	lectora2 nullable:true
    	lectora3 nullable:true
    	info nullable:true
    }

}
