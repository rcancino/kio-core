package com.luxsoft.kio

import grails.test.mixin.TestFor
import grails.test.mixin.Mock

import spock.lang.Specification
import spock.lang.Shared
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Venta)
@Mock([Cliente,VentaDet])
@Build([Venta,Cliente,VentaDet])
class VentaSpec extends Specification {

	@Shared
	def cliente

	@Shared
	def moneda

    def setup() {
    	cliente=Cliente.buildWithoutSave(nombre:'MOSTRADOR')
    	moneda=Currency.getInstance(new Locale("es","mx"))
    }

    def cleanup() {
    }

    @Unroll
    void "#propiedad debe ser una propiedad de la venta"() {
    	given: 'Una venta nueva'
    	def venta=Venta.buildWithoutSave()

    	when:'Asignamos el valor'
    	venta[propiedad]=valor

    	then:'La propiedad debe existir'
    	notThrown(MissingPropertyException)

    	//expect: 'Debe existir la propiedad'
    	//venta.cliente
    	where:
    	propiedad|valor
    	'cliente'|cliente
    	'fecha'|new Date()
    	'tipo'|null
    	'moneda'|moneda
    	'status'|'PEDIDO'
    	'importeBruto'|0.0
    	'descuento'|0.0
    	'importeNeto'|0.0
    	'impuesto'|0.0
    	'impuestoTasa'|0.016
    	'total'|0.0

    }

    void "Actualizar importes de la venta"(){
    	given: 'Una venta'
    	def venta=Venta.buildWithoutSave(cliente:cliente,moneda:moneda)
    	
    	and:'agregamos n partidas'
    	def cantidad=10.00
    	def precio=150.00
    	def descuentoTasa=0.05
    	def items=5

    	(0..items).each{
    		venta.addToPartidas(VentaDet.buildWithoutSave(cantidad:cantidad,precioUnitario:precio,descuentoTasa:descuentoTasa))
    	}
    	def totalBruto=items*(cantidad*precio)
    	def totalDescuento=items*(cantidad*precio*descuentoTasa)
    	def totalNeto=totalBruto-totalDescuento


    	when:'Actualizamos importes'
    	venta.actualizarImportes()

    	
    	then:
    	venta.importeBruto==totalBruto
    	venta.descuento==totalDescuento
    	venta.imporetNeto==totalNeto

    }
}
