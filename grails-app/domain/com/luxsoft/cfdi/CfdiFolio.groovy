package com.luxsoft.cfdi

class CfdiFolio {
	
	String serie
	Long folio

    static constraints = {
		serie blank:false,maxSize:10
		folio nullable:false
    }
	
	Long next(){
		folio++
		return folio
	}
	
	String toString(){
		return "$serie - $folio"
	}
}
