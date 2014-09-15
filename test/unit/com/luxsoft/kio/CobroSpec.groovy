package com.luxsoft.kio

import grails.test.mixin.TestFor
import grails.test.mixin.gorm.Domain
import grails.test.mixin.TestMixin
import grails.test.mixin.hibernate.HibernateTestMixin
import spock.lang.Specification
import spock.lang.Shared
import grails.buildtestdata.mixin.Build



/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestMixin(HibernateTestMixin)
@TestFor(Cobro)
@Mock([Cobro,Venta])
@Build([Cobro,Venta])
//@Domain([Cobro,Venta,VentaDet,Cliente,TipoDeCliente])
class CobroSpec extends Specification {

	@Shared
	def venta

    def setup() {
    	venta=Venta.build(total:5000.00)
    	assert Venta.get(venta.id).saldo==5000.00
    }

    def cleanup() {
    }

    void "Pesistencia de cobro"() {
    	given:'Un cobro nuevo'
    	def cobro=Cobro.buildWithoutSave(venta:venta,importe:venta.saldo)

    	when:'Salvamos el cobro'
    	cobro.save()

    	then:'El cobro persiste exitosamente'
    	cobro.errors.errorCount==0
    	cobro.id
    	Cobro.get(cobro.id).importe==venta.saldo
    	println cobro
    }

    /*
    void "Actualizar el saldo de la venta"(){
    	given: 'Una venta nueva'
    	sale=Venta.build(total:5000.00)
    	when:'Realiamos un cobro'
    	def cobro=Cobro.build(venta:sale,importe:venta.saldo)

    	then:'El saldo de la venta se actualiza'
    	sale.saldo==0.0

    }
    */
}
