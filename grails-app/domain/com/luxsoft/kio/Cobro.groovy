package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes="cliente,formaDePago,importe",includeNames=true,includePackage=false)
class Cobro {

	Cliente cliente

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	FormaDePago formaDePago

	BigDecimal recibe

	BigDecimal cambio

	BigDecimal importe

	Date dateCreated

	Date lastUpdated

	List partidas

	static hasMany = [partidas: CobroDet]

    static constraints = {

    }
}
