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

	BigDecimal importeBruto=0.0

    BigDecimal descuento=0.0

    BigDecimal descuentoTasa=0.0

    BigDecimal importeNeto=0.0   

    BigDecimal importeNetoSinIva=0.0

	String comentario

	Date dateCreated

	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:2)
    	precio(scale:2)
    	importeBruto(scale:2)
    	descuento(scale:4)
        descuentoTasa(scale:2,maxSize:90)
    	importeNeto(scale:2)
    	comentario nullable:true
        socio nullable:true
    }

    static transients = ['importeNetoSinIva']

    def actualizarImportes(){
        
        importeBruto=precio*cantidad 

        if(descuentoTasa>=0.0){
            descuento=(descuentoTasa/100)*importeBruto
        }
        
        importeNeto=importeBruto-descuento
        
        return this
    }

    String toString(){
    	"${producto}  ${cantidad}  ${precio}"
    }

    def getImporteNetoSinIva(){
        return MonedaUtils.calcularImporteDelTotal(importeNeto)
    }

    def getPrecioSinIva(){
        return MonedaUtils.calcularImporteDelTotal(precio)
    }
   


}
