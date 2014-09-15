package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.ToString

@ToString(includes="cliente,formaDePago,importe",includeNames=true,includePackage=false)
class Cobro {

	Venta venta

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	FormaDePago formaDePago

	BigDecimal recibe

	BigDecimal cambio

	BigDecimal importe

	Date dateCreated

	Date lastUpdated
	

    static constraints = {

    }

    def afterInsert() {
    	
    	def abonos=Cobro.executeQuery("select sum(c.importe) from Cobro c where c.venta=?",[venta]).get(0)
    	venta.abonos=abonos
    }

    def afterDelete() {
    	def abonos=Cobro.executeQuery("select sum(c.importe) from Cobro c where c.venta=?",[venta]).get(0)
    	venta.abonos=abonos
    }
}
