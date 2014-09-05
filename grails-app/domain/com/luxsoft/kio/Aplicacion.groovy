package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes='nombre,fecha,total,disponible',includeNames=true,includePackage=false)
class Aplicacion {

	Date fecha

	BigDecimal importe

	Venta venta

	static belongsTo = [abono: Abono]

    static constraints = {
    }

    
}
