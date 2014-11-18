package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class PagoService {

    def save(Pago pago){
        pago.save failOnError:true
        actualizarDisponible pago
        actualizarSaldos pago
        return pago
    }

    def registrarPago(Cobro cobro) {
    	def pago=new Pago(cliente:cobro.cliente
    		,fecha:cobro.fecha
    		,formaDePago:cobro.formaDePago
    		,referenciaBancaria:cobro.referencia
    		,importe:cobro.importe
    		,aplicado:0.0)
    	pago.addToAplicaciones(fecha:cobro.fecha,importe:cobro.importe,venta:cobro.venta)
    	pago.save failOnError:true
    	actualizarDisponible(pago)
    	actualizarSaldos(pago)
    	log.info 'Pago generado: '+pago
    	return pago

    }

    def actualizarDisponible(Pago pago){
        if(pago.aplicaciones)
    	   pago.aplicado=pago.aplicaciones.sum 0.0,{it.importe}
        else{
            pago.aplicado=0.0 
        }
    }
    def actualizarSaldos(Pago pago){
        if(pago.aplicaciones){
            def ventas=pago.aplicaciones.collect{it.venta}
            ventas.each{ venta->
                venta.pagos=Pago.executeQuery("select sum(importe) from AplicacionDePago a where a.venta=?",[venta])[0]
                venta.status='PAGADA'
            }
        }
    }

    def agregarAplicacion(Pago pago,Venta venta,Date fecha,BigDecimal importe,String comentario){
        pago.addToAplicaciones(venta:venta,importe:importe,comentario:comentario,fecha:fecha)
        pago.save failOnError:true
        actualizarSaldos(pago)
        actualizarDisponible(pago)
        log.info 'Aplicacion de pago registrada '
        return pago
    }


    def eliminarAplicacion(AplicacionDePago aplicacion){
        def pago=aplicacion.pago
        def ventas=pago.aplicaciones.collect{it.venta}
        pago.removeFromAplicaciones(aplicacion)
        pago.save flush:true
        ventas.each{ venta->
            def aplicaciones=AplicacionDePago.executeQuery("select sum(importe) from AplicacionDePago a where a.venta=?",[venta])[0]
            venta.pagos=aplicaciones?:0.0
            if(venta.pagos==0.0){
                venta.status='VENTA'
            }
            venta.save()
            log.info "Saldo actuaizado ${venta.saldo}  (Pagos: ${venta.pagos}) "
        }
        actualizarDisponible(pago)
        log.info 'Aplicacion eliminada '+aplicacion.id
        return pago
    }

    def delete(Pago pago){
    	def ventas=pago.aplicaciones.collect{it.venta}
    	pago.delete flush:true

    	ventas.each{ venta->
    		def aplicaciones=AplicacionDePago.executeQuery("select sum(importe) from AplicacionDePago a where a.venta=?",[venta])[0]
    		venta.pagos=aplicaciones?:0.0
            if(venta.pagos==0.0){
                venta.status='VENTA'
            }
    		venta.save()
    		log.info "Saldo actuaizado ${venta.saldo}  (Pagos: ${venta.pagos}) "
    	}
    	
    	

    }
}
