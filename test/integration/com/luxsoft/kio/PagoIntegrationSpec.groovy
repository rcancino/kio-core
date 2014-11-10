package com.luxsoft.kio



import spock.lang.*
import grails.buildtestdata.mixin.Build
/**
 *
 */
 @Build([Pago,Cliente])
class PagoIntegrationSpec extends Specification {

    def cliente

    def setup() {
    	cliente=Cliente.build(nombre:'DEMO')
    }

    def cleanup() {
    }

    void "Generacion de un pago"() {
    	given:'Una pago nuevo'
    	def pago =Pago.buildWithoutSave(formaDePago:'CHEQUE',cliente:cliente)

    	when:'Salvamos la instancia'
    	pago.save()

    	then: 'El pago es persistido exitosamente en la base de datos'
    	pago.errors.errorCount==0
    	pago.id
    	Pago.get(pago.id)
    }

    void "Modificacion de un pago"(){
    	given:'Un pago existente'
    	def pago=Pago.build(cliente:cliente,importe:50000.00).save flush:true

    	when:'Modificamos el importe'
    	def found=Pago.get(pago.id)
    	found.importe=60000.00
    	found.save flush:true

    	then:'La modificaion persiste en la base de datos'
    	Pago.get(found.id).importe==60000.00
    }

    void "Eliminar un pago"(){
    	given:'Un pago existente'
    	def pago=Pago.build(cliente:cliente)

    	when:'Eliminamos el pago'
    	def found =Pago.get(pago.id)
    	found.delete flush:true

    	then:'El pago ya no existe en la base de datos'
    	!Pago.exists(found.id)

    }
}
