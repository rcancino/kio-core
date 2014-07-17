package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Socio)
@Build(Socio)
class SocioSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Nombre en mayusculas al salvar"() {
    	given: 'Un socio nuevo'
    	def socio=Socio.build(apellidoPaterno:'lopez',apellidoMaterno:'perez',nombres:'juan')
    	socio=socio.save(flush:true)

    	expect:
    	socio.apellidoPaterno=='LOPEZ'
    	socio.apellidoMaterno=='PEREZ'
    	socio.nombres=='JUAN'
    }
}
