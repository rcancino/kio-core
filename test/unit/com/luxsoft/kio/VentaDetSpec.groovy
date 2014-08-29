package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(VentaDet)
@Build([VentaDet,Producto])
class VentaDetSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Una VentaDet debe tener la propiead: #propiedad"() {
    	given:'Una partida de venta nueva'
    	def partida=VentaDet.buildWithoutSave()

    	when:'Asignamos el valor'
    	partida[propiedad]==valor

    	then:'La propiedad debe existir'
    	notThrown(MissingPropertyException)

    	where:
    	propiedad|valor
    	
    	'producto'|'item'
    	'cantidad'|0.0
    	'precio'|0.0
    	'importeBruto'|0.0
        'descuento'|0.0
        'descuentoTasa'|0.0
    	'importeNeto'|0.0
    	

    }
    
    @Unroll
    void "El Importe neto de #cantidad productos con precio:#precio con  #descuentoTasa% de descuento = #importeNeto"(){
    	given:'Una partida de venta'
    	def partida=VentaDet.buildWithoutSave(cantidad:cantidad,precio:precio,descuentoTasa:descuentoTasa)

    	expect:
    	partida.actualizarImportes()
        .importeNeto==importeNeto

    	where:
    	cantidad|precio|descuentoTasa||importeNeto
    	1.00|1300.00|10|1170.00
        7.00|650.00|10|4095.00
        3.00|1200.00|10|3240.00
    }

    void "El importe neto de una VentaDet cuando se asigna descuento directo"(){
        given: 'Una VentaDet nueva'
        def partida=VentaDet.buildWithoutSave(cantidad:10,precio:50,descuentoTasa:0.0)

        when:'Asignamos un descuento de 100'
        partida.descuento=100

        then:'Al actualisar los importes el importeNeto debe ser 400'
        partida.actualizarImportes().importeNeto==400.00
    }

    void "El importe neto sin iva de una VentaDet "(){
        given: 'Una VentaDet nueva'
        def partida=VentaDet.buildWithoutSave(cantidad:10,precio:116,descuentoTasa:0.0)

        when:'Actualizamos los importes'
        partida.actualizarImportes()

        then:'Impuesto debe ser del 16%'
        partida.importeNetoSinIva==1000.00
    }


}
