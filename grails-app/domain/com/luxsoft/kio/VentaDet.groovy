package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='producto')
class VentaDet {

	Producto producto

    ServicioPorSocio servicioPorSocio
	
	BigDecimal cantidad=0

	BigDecimal precioUnitario=0

	BigDecimal importeBruto=0

	BigDecimal descuento=0

	BigDecimal descuentoTasa=0

	BigDecimal importeNeto=0

	String comentario

	Date dateCreated

	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:4)
    	precioUnitario(scale:4)
    	importeBruto(scale:4)
    	descuento(scale:4)
    	descuentoTasa(scale:6)
    	importeNeto(scale:4)
    	comentario nullable:true
        servicioPorSocio nullable:true
    }

    String toString(){
    	"${producto}  ${cantidad}  ${precioUnitario}"
    }

    def actualizarImportes(){
    	importeBruto=cantidad*precioUnitario
    	importeNeto=importeBruto-(cantidad*precioUnitario*descuentoTasa)
    	return this
    }
}
