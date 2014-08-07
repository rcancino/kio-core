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
	BigDecimal descuento=0.0
	BigDecimal subTotal=0.0
    BigDecimal impuesto=0.0

	String comentario

	Date dateCreated

	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:2)
    	precio(scale:2)
    	importe(scale:2)
    	descuento(scale:2)
    	subTotal(scale:2)
    	comentario nullable:true
        socio nullable:true
    }

    static transients = ['precioConIva','importeConIva','descuentoConIva']

    VentaDet(){}

    VentaDet(Producto producto){
        producto=producto
        precio=producto.precioNeto
    }

    

    String toString(){
    	"${producto}  ${cantidad}  ${precio}"
    }

    

    def getPrecioConIva(){
        return MonedaUtils.calcularTotal(precio)
    }

    def getImporteConIva(){
        return MonedaUtils.calcularTotal(importe)
    }

    def getDescuentoConIva(){
        return MonedaUtils.calcularTotal(descuento)
    }

    def getSubTotalConIva(){
        return MonedaUtils.calcularTotal(subTotal)
    }


}
