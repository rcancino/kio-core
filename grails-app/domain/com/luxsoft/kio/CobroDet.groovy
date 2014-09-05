package com.luxsoft.kio

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable

//@Sortable(includes="importe")
@ToString(includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='venta')
class CobroDet {

	Venta venta
	
	BigDecimal saldo

	BigDecimal importe

	static belongsTo = [cobro: Cobro]


    static constraints = {
    }

    // def beforeInsert() {
    // 	saldo=venta.getSaldo()
    // }

	
    // def beforeUpdate() {
    // 	saldo=venta.getSaldo()
    // }
}
