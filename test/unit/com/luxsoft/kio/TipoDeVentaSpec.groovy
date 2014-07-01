package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TipoDeVenta)
class TipoDeVentaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "ToString adecuado"() {
    	given:'Un tipo de venta'
    	def tipo=new TipoDeVenta(clave:'MOSTRADOR',descripcion:'Venta a publico en general')

    	expect: tipo.toString()=='MOSTRADOR'
    }

    void "Clave en mayusculas"(){
    	given:'Un tipo nuevo'
    	def tipo=new TipoDeVenta(clave:'mostrador',descripcion:'Venta a publico en general')
    	when:'Salvamos el tipo'
    	tipo.save(flush:true)

    	then:'La clave es persistida en mayusculas'
    	TipoDeVenta.get(tipo.id).clave=='MOSTRADOR'
    }
}
