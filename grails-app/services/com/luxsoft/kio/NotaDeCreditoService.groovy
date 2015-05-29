package com.luxsoft.kio

import grails.transaction.Transactional
import org.apache.commons.lang.time.DateUtils

@Transactional
class NotaDeCreditoService {

    def agregarAplicacion(NotaDeCredito nota,Venta venta,Date fecha,BigDecimal importe,String comentario){
        def a=new AplicacionDeNota(venta:venta,importe:importe,comentario:comentario,fecha:fecha)
        nota.addToAplicaciones(a)
        nota.save failOnError:true
        actualizarSaldos(nota)
        //actualizarDisponible(nota)
        //actualizarMembresia(a)
        log.info 'Aplicacion de nota registrada '
        return nota
    }

    def eliminarAplicacion(AplicacionDeNota aplicacion){
        def nota=aplicacion.nota
        def ventas=nota.aplicaciones.collect{it.venta}
        nota.removeFromAplicaciones(aplicacion)
        nota.save flush:true

        ventas.each{ venta->
            venta.abonos=NotaDeCredito.executeQuery("select sum(importe) from AplicacionDeNota a where a.venta=?",[venta])[0]
            venta.save()
            log.info "Saldo actuaizado ${venta.saldo}  (abonos: ${venta.abonos}) "
        }
        log.info 'Aplicacion eliminada '+aplicacion.id
        return nota
    }

    def actualizarSaldos(NotaDeCredito nota){
        if(nota.aplicaciones){
            def ventas=nota.aplicaciones.collect{it.venta}
            ventas.each{ venta->
                venta.abonos=NotaDeCredito.executeQuery("select sum(importe) from AplicacionDeNota a where a.venta=?",[venta])[0]
            }
        }
    }

    def delete(NotaDeCredito nota){
        nota.delete flush:true

    }
}
