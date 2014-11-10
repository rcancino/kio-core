package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Pago)
@Build([Pago,Cliente])
class PagoSpec extends Specification {

	def cliente

    def setup() {
    	cliente=Cliente.build(nombre:'DEMO')
    }

    def cleanup() {
    }

    void "Generacion de un pago"() {
    	given:'Una pago nuevo'
    	def pago =Pago.buildWithoutSave(formaDePago:'CHEQUE',cliente:cliente)

    	when:'Salvamos la instancia'
    	pago.save()

    	then: 'El pago es persistido exitosamente en la base de datos'
    	pago.errors.errorCount==0
    	pago.id
    	Pago.get(pago.id)
    }
}
