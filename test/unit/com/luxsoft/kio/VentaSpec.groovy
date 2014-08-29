package com.luxsoft.kio

import grails.test.mixin.TestFor
import grails.test.mixin.Mock

import spock.lang.Specification
import spock.lang.Shared
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build
import java.math.RoundingMode

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
    	'importe'|0.0
    	'descuento'|0.0
        'subTotal'|0.0
    	'impuesto'|0.0
    	'impuestoTasa'|0.016
        'total'|0.0
    	

    }

    void "Actualizar importes de la venta"(){
    	given: 'Una venta'
    	def venta=Venta.buildWithoutSave(cliente:cliente,moneda:moneda)
    	
    	and:'agregamos n partidas'
        venta.addToPartidas(VentaDet.buildWithoutSave(importeBruto:100,importeNeto:90,descuento:10))
        venta.addToPartidas(VentaDet.buildWithoutSave(importeBruto:500,importeNeto:490,descuento:10))
        venta.addToPartidas(VentaDet.buildWithoutSave(importeBruto:100,importeNeto:90,descuento:10))


    	when:'Al actualizar importes'
    	venta.actualizarImportes()

    	
    	then:
    	venta.importe==700.00
    	venta.descuento==30.00
    	venta.total==670.00
        venta.subTotal==(670.00/1.16).setScale(2,RoundingMode.HALF_EVEN)

    }
}
