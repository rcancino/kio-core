package com.luxsoft.kio



import spock.lang.*


/**
 *
 */
class CobroIntegrationSpec extends Specification {

	@Shared
    def venta

    @Shared
    def cliente

    def setup() {
        cliente=Cliente.build(nombre:'Albus Dumbledore')
        venta=Venta.build(total:5000.00,cliente:cliente)
        assert Venta.get(venta.id).saldo==5000.00
    }

    def cleanup() {
    }

    void "Salvar un cobro nuevo"() {
    	given: 'Un cobro nuevo'

    	def cobro=Cobro.buildWithoutSave(venta:venta,importe:venta.saldo)

    	when:'Salvamos el cobro'
    	cobro.save()

    	then:'El Cobro es persistido exitosamente en la base de datos'
    	cobro.errors.errorCount==0
    	cobro.id
    	println cobro

    }

    @Unroll
    void "Un saldo de una venta nueva de #total despues de un cobro de #pago debe ser #saldo"(){
        given: 'Una venta de #importe'
        def sale=Venta.build(cliente:cliente,total:total)
        and:'Un cobro de la misma'
        def cobro=Cobro.build(venta:sale,importe:sale.saldo)

        expect: 'El saldo de la venta debe ser '+saldo
        Venta.get(sale.id).saldo==saldo

        where:
        total|pago|saldo
        5000.00|5000.00|0.0
        10000.00|10000.00|0.0
        150000.00|100000.00|50000.00

    }

   
}
