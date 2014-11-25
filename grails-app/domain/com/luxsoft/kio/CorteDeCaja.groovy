package com.luxsoft.kio

import groovy.transform.EqualsAndHashCode
import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='fechaHora,cajero,id')
class CorteDeCaja {

	@BindingFormat('dd/MM/yyyy HH:mm')
	Date fechaHora

	String cajero
	BigDecimal total

	Date dateCreated
	Date lastUpdated
	String creadoPor

	static hasMany = [partidas: CorteDeCajaDet]

    static constraints = {
    	cajero maxSize:50
    	creadoPor nullable:true

    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
		saldo formula: 'total - pagos'
	}
}
