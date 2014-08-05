package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='producto')
class VentaDet {

	Producto producto

    Socio socio
	
	BigDecimal cantidad=0.0
	BigDecimal precio=0.0
	BigDecimal importe=0.0
	BigDecimal descuento=0.0
	BigDecimal subTotal=0.0
    BigDecimal impuesto=0.0

	String comentario

	Date dateCreated

	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:4)
    	precio(scale:4)
    	importe(scale:4)
    	descuento(scale:4)
    	subTotal(scale:4)
    	comentario nullable:true
        socio nullable:true
    }

    VentaDet(){}

    VentaDet(Producto producto){
        producto=producto
        precio=producto.precioNeto
    }

    

    String toString(){
    	"${producto}  ${cantidad}  ${precio}"
    }

    def actualizarImportes(){
    	importe=cantidad*precio
    	subTotal=importe-descuento
    	return this
    }
}
