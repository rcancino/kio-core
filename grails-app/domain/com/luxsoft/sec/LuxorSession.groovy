package com.luxsoft.sec

import groovy.transform.ToString

@ToString(includeNames=true,includePackage=false)
class LuxorSession {

	String usuario

	Date login
	Date logout
	Date timeout

	String tipo
	String ip
	String session='UNKNOWN'

	Date dateCreated
	Date lastUpdated


    static constraints = {
    	ip maxSize:20
    	tipo maxSize:20
    	logout nullable:true
    	timeout nullable:true

    }
}
