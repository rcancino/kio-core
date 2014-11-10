package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.*


/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PagoController)
@Mock(Pago)
class PagoControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Text index action return model"() {
    	when:
    	def model=controller.index()
    	
    	then:'The model is correct'
    		!model.pagoInstanceList
    		model.pagoInstanceCount==0

    }

    void "Test create return the right model"(){
        when:'create action is executed'
        def model=controller.create()

        then:'The model is correctly created'
        model.pagoInstance
    }
}
