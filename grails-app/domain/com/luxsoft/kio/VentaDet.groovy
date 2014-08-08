package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode
import com.luxsoft.kio.MonedaUtils

@EqualsAndHashCode(includes='producto')
class VentaDet {

	Producto producto

    Socio socio
	
	BigDecimal cantidad=0.0

	BigDecimal precio=0.0

	BigDecimal importe=0.0

    BigDecimal descuentoTasa=0.0

	BigDecimal descuento=0.0

	BigDecimal subTotal=0.0


    

	String comentario

	Date dateCreated

	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:2)
    	precio(scale:2)
    	importe(scale:2)
    	descuento(scale:2)
        descuentoTasa(scale:2,maxSize:90)
    	subTotal(scale:2)
    	comentario nullable:true
        socio nullable:true
    }

    static transients = []

    def actualizarImportes(){
        importe=precio*cantidad 
        descuento=(descuentoTasa/100)*importe
        subTotal=importe-descuento
        return this
    }

    String toString(){
    	"${producto}  ${cantidad}  ${precio}"
    }
   


}
