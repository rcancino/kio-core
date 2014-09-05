package com.luxsoft.kio



import spock.lang.*

/**
 *
 */
class CobroIntegrationSpec extends Specification {

	def cliente

    def setup() {
    	cliente=Cliente.build(nombre:'TESTER')
    }

    def cleanup() {
    }

    void "Salvar un cobro nuevo"() {
    	given: 'Un cobro nuevo'

    	def cobro=Cobro.buildWithoutSave(cliente:cliente)

    	when:'Salvamos el cobro'
    	cobro.save()

    	then:'El Cobro es persistido exitosamente en la base de datos'
    	cobro.errors.errorCount==0
    	cobro.id
    	println cobro

    }

    void "Salvar un cobro con partidas"(){
    	given: 'Un cobro nuevo'
    	def cobro=Cobro.buildWithoutSave(cliente:cliente,formaDePago:FormaDePago.EFECTIVO)
    	

    	when:'Agregamos algunas partidas'
    	/*
    	(1..3).each{
    		def venta=Venta.build(cliente:cliente,total:1000*it)
    		//cobro.addToPartidas(venta:venta,importe:venta.total,saldo:venta.getSaldo())
    	}
    	*/
    	def venta=Venta.build(cliente:cliente,total:1000)
    	def venta2=Venta.build(cliente:cliente,total:2000)
    	CobroDet.build(venta:venta,cobro:cobro)
    	CobroDet.build(venta:venta2,cobro:cobro)
    	
    	then:'El cobro contempla 3 ventas'
    	cobro.partidas.size()==2
    	
    	when:'Salvamos el cobro'
    	cobro.save()

    	then: 'El cobro y sus partidas persisten exitosamente en la base de datos'
    	cobro.errors.errorCount==0
    	cobro.id
    	Cobro.get(cobro.id).partidas.size()==2
    	def found=Cobro.get(cobro.id)
    	found.partidas.each{ println it}

    }
}
