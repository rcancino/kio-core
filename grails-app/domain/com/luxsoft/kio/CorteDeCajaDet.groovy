package com.luxsoft.kio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='formaDePago,corte')
class CorteDeCajaDet {

	FormaDePago formaDePago
	
	BigDecimal cobrado

	BigDecimal acumulado=0.0

	BigDecimal importeCorte

    static constraints = {
    }

    static belongsTo = [corte: CorteDeCaja]
}
