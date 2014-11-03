package com.luxsoft.kio

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CobroController)
@Mock([Cobro,Cliente,Venta])
@Build([Cobro,Cliente,Venta])
class CobroControllerSpec extends Specification {

	def cliente

    def setup() {
    	cliente=Cliente.build()
    }

    def cleanup() {
    }

    void "Registra un cobro sin venta "(){
        given:'El Id de una venta inexistente'
        params.id=1111

        when:'registrar es invocado'
        controller.registrar()

        then:'un 404 es enviado'
        response.status==404
    }

    // void "Test registra view"(){
    //     when:
    //     def model=controller.registrar()
    //     then:
    //     model.view=='/cobro/create'
    // }
    void "model data para registrar un cobro"(){
        given:'Una venta valida'
        def venta=Venta.build(cliente:cliente,total:10000.00)
        and:'El id de la venta como parametro del request'
        params.id=venta.id  

        when:'registrar es invocado'
        def model=controller.registrar()

        then:
        model.ventaInstance
        model.cobroInstance
    }

    


    // void "Modelo para registrar un cobro"(){
    // 	when:'registrar es invocado'
    // 	def model=controller.registrar()

    // 	then:'El modelo contiene una instancia transitiva de un cobro'
    // 	model.cobroInstance
    // 	!model.cobroInstance.id
    // 	model.cobroInstance.fecha
    // }

    // void "Generar el modelo adecuado  para registrar el pago de una venta de contado"() {
    // 	given:'Una venta existente'
    // 	def venta=Venta.build(cliente:cliente,total:10000.00)

    // 	and:'El id de la venta como parametro del request'
    // 	params.id=venta.id	

    // 	when:'cobrar es invocado'
    // 	controller.cobrar()

    // 	then:'Una instancia transitiva de cobro es regresada en el modelo '
    // 	model.cobroInstance
    // 	!model.cobroInstance.id
    // 	model.cobroInstance.cliente
    // 	model.cobroInstance.partidas
    // }

    // void "Mandar error al intentar cobrar facturas ya cobradas "(){

    // }
}
