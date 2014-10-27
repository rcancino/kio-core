package com.luxsoft.kio

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CajaController)
@Mock([Cobro,Venta])
@Build([Cobro,Venta])
class CajaControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Get el cobro de una venta"() {
    	given:'Una venta existente'
    	def venta=Venta.build(total:50000)

    	and:'Un parametro id'
    	params.id=venta.id

    	when:'se invoca cobrar'
    	def model=controller.cobrar()
        
        then:'la venta y el Cobro deben estar en el modelo '
        model.ventaInstance
        model.ventaInstance.id==venta.id
        model.cobroInstance
        model.cobroInstance.venta.id==venta.id
        model.cobroInstance.importe==venta.total
    }
}
