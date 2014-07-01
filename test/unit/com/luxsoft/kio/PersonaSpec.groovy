package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Persona)
class PersonaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Uso del metodo toString"() {
    	
    	given: 'Una persona '
    	def persona=new Persona(apellidoPaterno:'CANCINO',apellidoMaterno:'RAMOS',nombres:'RUBEN')

    	expect:
    	persona.toString()
    	persona.toString()=='CANCINO RAMOS RUBEN'

    }
}
