package com.luxsoft.kio



import spock.lang.*
import grails.buildtestdata.mixin.Build
import grails.test.spock.IntegrationSpec

/**
 *
 */
 @Build([Aplicacion,Pago])
class AplicacionIntegrationSpec extends IntegrationSpec {

	def pago



    def setup() {
    	pago=Pago.build(importe:50000.00)
    }

    def cleanup() {
    }

    void "Generacion de una aplicacion"() {
    	given:'Generamos una aplicacion a  un pago existente'
    	def aplicacion=new Aplicacion(fecha:new Date(),importe:10000.00,documento:1
    		,documentoFecha:new Date(),documentoTipo:'VENTA')
    	and:'La agregamos al pago'
    	println aplicacion
    	pago.addToAplicaciones(aplicacion)

    	when:'Validacmos la aplicacion'
    	aplicacion.validate()
    	then:'La eplicacion no presenta errores'
    	!aplicacion.hasErrors()
    	
    	
    	when:'Salvamos el pago'
    	pago.save flush:true
    	

    	then:'La aplicacion es persisteda satisfactoria en la base de datos'
    	Aplicacion.count()==1
    	Pago.get(pago.id).aplicaciones.size()==1
    }

    void "Eliminacion de una aplicacion"(){
    	given: 'Una aplicacion existente'
    	def aplicacion =Aplicacion.build(abono:pago,importe:10000.00).save flush:true

    	when:'Eliminamos la aplicacion del pago'
    	def found=aplicacion.get(aplicacion.id)
    	def pago=aplicacion.abono
    	pago.removeFromAplicaciones(found) 
    	assert pago.aplicaciones.size()==0
    	pago.save flush:true

    	then:'La aplicacion ya no existe en la base de datos'
    	Pago.get(pago.id).aplicaciones.size()==0
    	Aplicacion.get(found.id)
    	//Aplicacion.count()==0
    	
    }
}
