package com.luxsoft.kio

class Persona {

	String apellidoPaterno
	String apellidoMaterno
	String nombres

	String toString(){
    	return "$apellidoPaterno $apellidoMaterno $nombres"
    }

    static constraints = {
    }

    static mapping = {
    	tablePerHierarchy false
    }

    
}
