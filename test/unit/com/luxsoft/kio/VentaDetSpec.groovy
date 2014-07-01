package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(VentaDet)
@Build(VentaDet)
class VentaDetSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Una VentaDet debe tener la propiead: #propiedad"() {
    	given:'Una partida de venta nueva'
    	def partida=VentaDet.buildWithoutSave()

    	when:'Asignamos el valor'
    	partida[propiedad]==valor

    	then:'La propiedad debe existir'
    	notThrown(MissingPropertyException)

    	where:
    	propiedad|valor
    	
    	'clave'|'item'
    	'descripcion'|'element'
    	'unidad'|'pza'
    	'cantidad'|0.0
    	'precioUnitario'|0.0
    	'importeBruto'|0.0
    	'descuento'|0.0
    	'descuentoTasa'|0.0
    	'importeNeto'|0.0

    }

    void "VnetaDet debe tener un ToString adecuado"(){
    	given:'Una partida de veneta'
    	def partida=VentaDet.buildWithoutSave(clave:'SERV1',descripcion:'Servicio de prueba')
    	expect: 'El String adecuado para representar el preoducto'
    	partida.toString()=='SERV1 (Servicio de prueba)'
    }

    @Unroll
    void "Equals y hashCode adecuado entre (#xClave1,#xUnidad1) y (#xClave2,#xUnidad2) "(){
    	given:'Una partida '
    	def source=VentaDet.buildWithoutSave(clave:xClave1,unidad:xUnidad1)
    	def target=VentaDet.buildWithoutSave(clave:xClave2,unidad:xUnidad2)

    	expect:
    	source.equals(target)==res

    	where:
    	xClave1|xClave2|xUnidad1|xUnidad2||res
    	'SERV1'|'SERV1'|'PZA'|'PZA'||true
    	'SERV1'|'SERV2'|'PZA'|'KILO'||false
    	'SERV2'|'SERV2'|'KILO'|'KILO'||true
    	'SERV2'|'SERV2'|'KILO'|'PZA'||false
    		
    }

    void "Calcula el importe neto de #cantidad a un precion unitario de :#precio con descuento de:#descuentoTasa"(){
    	given:'Una partida de venta'
    	def partida=VentaDet.buildWithoutSave(cantidad:cantidad,precioUnitario:precio,descuentoTasa:descuentoTasa)

    	expect:
    	partida.actualizarImportes().importeNeto==(cantidad*precio)-(cantidad*precio*descuentoTasa)

    	where:
    	cantidad|precio|descuentoTasa
    	10.00|150.00|0.05
    	10.00|1750.00|0.03
    	8.00|160.50|0.13

    }
    /*
    void "Implementacion de plus()"{}
    */

}
