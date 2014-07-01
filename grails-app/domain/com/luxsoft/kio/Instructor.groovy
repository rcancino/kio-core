package com.luxsoft.kio

class Instructor extends Persona{

	String nivel

    static constraints = {
    	nivel nullable:true
    	nivel inList:['A','B','C','D']
    }
}
