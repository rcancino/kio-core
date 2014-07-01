package com.luxsoft.kio



import spock.lang.*

/**
 *
 */
class VentaIntegrationSpec extends Specification {

   
    def cliente

    def setup() {
        //cliente=Cliente.build(nombre:'CLIENTE DE PRUEBA')
    }

    def cleanup() {
    }

    void "Persistir una venta de manera correcta"() {
    	given:'La generacion de una venta nueva'
    	def venta=Venta.build()

        expect:
        venta.errors.errorCount==0
        venta.id
        Venta.get(venta.id).cliente==venta.cliente
    }

    void "Test la modificacion de una venta existente"(){
        given:'Una venta'
        def venta=Venta.build(status:'COTIZACION') 
        
        when:'Modificamos un a propiedad'
        def found=Venta.get(venta.id)
        found.status='PEDIDO'
        found.save flush:true


        then:'Los cambios se persisten en la base de datos'
        Venta.get(found.id).status=='PEDIDO'
    }

    
}
