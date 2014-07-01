package com.luxsoft.kio



import spock.lang.*

/**
 *
 */
class VentaDetIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Salvar partidas al salvar una Venta"(){
        given:'Una venta existente'
        def venta=Venta.build()

        when:'Agregamos partidas'
        (1..10).each{
            def det=new VentaDet(clave:"PROD $it",descripcion:"DESC PARA PROD $it",cantidad:it)
            venta.addToPartidas(det)
        }
        venta.save flush:true

        then:'Las partidas persisten '
        Venta.get(venta.id).partidas.size()==10
    }
}
