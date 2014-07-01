package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Producto)
@Build(Producto)
class ProductoSpec extends Specification {



    def setup() {
    }

    def cleanup() {
    }

    void "ToString adecuado"() {
    	given:'Un producto'
    	def producto=new Producto(clave:'PROD1',descripcion:'Descripcion de Producto')

    	expect:
    	producto.toString()=='PROD1 (Descripcion de Producto)'
    }

    @Unroll
    void "Equals y HashCode  para productos con clave #clave1 y #clave2  deben ser iguales #res "(){
    	given:'Un producto'
    	def source=Producto.buildWithoutSave(clave:clave1)
    	def target=Producto.buildWithoutSave(clave:clave2)

    	expect:
    	source.equals(target)==res
    	source.hashCode().equals(target.hashCode())==res

    	where:
    	clave1|clave2||res
    	'POL1'|'POL1'||true
    	'POL1'|'POL2'||false
    	'POL2'|'POL1'||false
    	'POL2'|'POL2'||true

    }

    void "Al salvar un producto nuevo la clave  siempre se debe persistr con maysculas"(){
    	given: 'Un producto nuevo'
    	def producto=Producto.buildWithoutSave(clave:'producto')

    	when:'Salvamos el producto por primera vez'
    	producto.save flush:true

    	then: 'La clave se persiste en maysculas'
    	Producto.get(producto.id).clave=='PRODUCTO'

    }

    void "Al actualizar un producto existente la clave siempre se persiste en maysculas"(){
    	given: 'Un producto nuevo'
    	def producto=Producto.build(clave:'producto')

    	when:'Actualizamos la clave del producto existente'
    	def found=Producto.get(producto.id)
    	found.clave='producto'
    	found.save flush:true

    	then:'La clave se periste en maysculas'
    	Producto.get(found.id).clave=='PRODUCTO'
    }
}
