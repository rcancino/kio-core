package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CobroDet)
@Build([CobroDet,Venta,Cliente])
class CobroDetSpec extends Specification {

	def cliente 

    def setup() {
    	cliente=Cliente.build(nombre:'Tester')
    }

    def cleanup() {
    }

   /* void "Debe implementar Comparable "() {
    	given:'Un CobroDet nuevo'
    	def cobroDet =new CobroDet()
    	//and: ' Un sorted set'
    	//def sortedSet=new TreeSet()

    	expect : 'La instancia de CobroDet implemente Comparable'
    	cobroDet instanceof Comparable
    	//sortedSet.add(cobroDet)

    	

    }

    void "La implementacion de Comparable debe ser en base al Id de la venta"(){
    	given:' Un grupo de instancias de cobroDet'
    	def c1=CobroDet.buildWithoutSave(venta:Venta.buildWithoutSave(cliente:cliente,id:1))
    	def c2=CobroDet.buildWithoutSave(venta:Venta.buildWithoutSave(cliente:cliente,id:2))
    	def c3=CobroDet.buildWithoutSave(venta:Venta.buildWithoutSave(cliente:cliente,id:3))

    	and: 'Un SorteSet'
    	SortedSet set=new TreeSet()

    	when:'Las agregamos a a un sorted set'
    	set.add(c1)
    	set.add(c2)
    	set.add(c3)

    	then:'El orden en que se obtienen es en base al id de la venta'
    	set.size()==3
    	int row=1
    	set.each{
    		it.id==row++
    		println it
    	}
    }*/


}
