package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Aplicacion)
class AplicacionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    /*
    void "Equals de aplicaciones con documento #documento1  y Documento2 #documento2 es #res"() {
    	
    	//where:'Algunas aplicaciones'
    	def a1=new Aplicacion(documento:documento1,fecha:fecha1,importe:10000.00,documentoTipo:'VENTA')
    	def a2=new Aplicacion(documento:documento2,fecha:fecha2,importe:10000.00,documentoTipo:'VENTA')
    	
    	expect:
    	a1.equals(a2)==res
    	//expect:a2.equals(a1)
    	//expect:a1.hashCode()==a2.hashCode()
    	where:
    	documento1|documento2|fecha1|fecha2||res
    	1|1|Date.parse('dd/MM/yyyy','30/10/2014')|Date.parse('dd/MM/yyyy','30/10/2014')||true

    	
    	
    }
    */
}
