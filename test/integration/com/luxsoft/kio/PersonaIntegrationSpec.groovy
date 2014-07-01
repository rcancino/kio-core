package com.luxsoft.kio



import spock.lang.*

/**
 *
 */
class PersonaIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Alta de una persona"() {
    	given:'Una persona nueva'
    	def persona=Persona.buildWithoutSave(apellidoPaterno:'RAMOS')

    	when:'salvamos la persona'
    	persona.save()

    	then:'Le entidad es persistida en la base de datos'
    	persona.errors.errorCount==0
    	persona.id
    	Persona.get(persona.id).apellidoPaterno=='RAMOS'
    }
}
