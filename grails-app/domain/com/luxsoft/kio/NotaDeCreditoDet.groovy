package com.luxsoft.kio
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='concepto')
class NotaDeCreditoDet {

	String concepto
	String descripcion
	String venta

	BigDecimal cantidad
	String unidad
	BigDecimal valorUnitario
	BigDecimal importe 

	static belongsTo = [nota: NotaDeCredito]

    static constraints = {
    	concepto inList:['DESCUENTO','CANCELACION','BONIFICACION','DEVOLUCION']
    	venta nullable:true,maxSize:20
    	unidad inList:['SERVICIO','PIEZA']

    }


}
