package com.luxsoft.kio



import spock.lang.*

/**
 *
 */
class ClienteIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Dar de alta  un cliente nuevo"() {
    	given:"Dado un cliente completamente nuevo"
    	def cliente=Cliente.build(nombre:'EMPRESA')

    	when:'Se salva el cliente'
    	cliente.save()

    	then:'La entidad es persistida en la base de datos sin errores'
    	cliente.errors.errorCount==0
    	cliente.id
    	Cliente.get(cliente.id).nombre=='EMPRESA'
    }
}
