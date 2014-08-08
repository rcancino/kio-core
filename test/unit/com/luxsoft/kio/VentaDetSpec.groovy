package com.luxsoft.kio

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(VentaDet)
@Build([VentaDet,Producto])
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
    	
    	'producto'|'item'
    	'cantidad'|0.0
    	'precio'|0.0
    	'importe'|0.0
        'descuentoTasa'|0.0
    	'descuento'|0.0
    	'subTotal'|0.0

    }
    /*
    void "VnetaDet debe tener un ToString adecuado"(){
    	given:'Una partida de veneta'
        def producto=Producto.build(clave:'SERV1',descripcion:'Servicio de prueba')
    	def partida=VentaDet.buildWithoutSave(producto:producto)
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
    */
    @Unroll
    void "El Sub Total de #cantidad productos a  precion  de :#precio con descuento de:#descuentoTasa debe ser #subTotal"(){
    	given:'Una partida de venta'
    	def partida=VentaDet.buildWithoutSave(cantidad:cantidad,precio:precio,descuentoTasa:descuentoTasa)

    	expect:
    	partida.actualizarImportes()
        .subTotal==subTotal

    	where:
    	cantidad|precio|descuentoTasa||subTotal
    	1.00|1300.00|10|1170.00
        7.00|650.00|10|4095.00
        3.00|1200.00|10|3240.00
    }

    /*
    void "Implementacion de plus()"{}
    */

}
