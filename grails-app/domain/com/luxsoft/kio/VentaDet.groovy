package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='clave,unidad')
class VentaDet {

	String clave
	String descripcion
	String unidad
	
	BigDecimal cantidad
	BigDecimal precioUnitario
	BigDecimal importeBruto
	BigDecimal descuento
	BigDecimal descuentoTasa
	BigDecimal importeNeto

	String comentario

	Date dateCreated
	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	clave()
    	descripcion()
    	unidad()
    	cantidad(scale:4)
    	precioUnitario(scale:4)
    	importeBruto(scale:4)
    	descuento(scale:4)
    	descuentoTasa(scale:6)
    	importeNeto(scale:4)
    	comentario nullable:true
    }

    String toString(){
    	"$clave ($descripcion)"
    }

    def actualizarImportes(){
    	importeBruto=cantidad*precioUnitario
    	importeNeto=importeBruto-(cantidad*precioUnitario*descuentoTasa)
    	return this
    }
}
