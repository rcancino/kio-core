package com.luxsoft.kio

import grails.transaction.Transactional
import org.apache.commons.lang.time.DateUtils

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
    	pago.addToAplicaciones(fecha:new Date(),importe:cobro.importe,venta:cobro.venta)
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
        //aplicarPagoAMembresiaDeSocio(venta,fecha)
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

    def actualizarMembresias(Long id){
        def pago=Pago.get(id)
        pago.aplicaciones.each{a->
            def venta=a.venta
            venta.partidas.each{det ->
                if(det.producto.tipo.clave=='MEMBRESIA'){
                    def socio=det.socio
                    if(socio){
                        socio.membresia.ultimoPago=a.fecha
                        Calendar cal=Calendar.getInstance()
                        cal.set(Calendar.DATE,socio.membresia.diaDeCorte)   

                        socio.membresia.proximoPago=
                    }
                }
            }
        }
    }

    def aplicarPagoAMembresiaDeSocio(Venta venta,Date fecha){
        
        def found=venta.partidas.find{it.producto.tipo.clave=='MEMBRESIA'}
        if(found){
            //Actualizando la membresia
            
            if(servicio.duracion){
                def servicio=found.producto
                def duracion=Math.round(servicio.duracion/30.4)
                def socio=it.socio
                def m=socio.membresia
                def fpago=m.proximoPago?:new Date()
                def proximo=DateUtils.addMonths(fpago,duracion)
                m.proximoPago=proximo
                m.ultimoPago=fecha
                m.save()
                if(socio.activo==false){
                    socio.activo=true
                    socio.save()
                } 
            }
            
        }
    }

    def cancelarAplicacionAMembresiaDeSocio(Venta venta,Date fecha){
       
        def found=venta.partidas.find{it.producto.tipo.clave=='MEMBRESIA'}
        if(found){
            //Actualizando la membresia
            println 'Actualizando membresia a partir de la aplicacion de un pago......'+found.producto
            if(servicio.duracion){
                def servicio=found.producto
                def duracion=Math.round(servicio.duracion/30.4)
                def socio=it.socio
                def m=socio.membresia
                def fpago=m.proximoPago
                if(fpago){
                    def ul=DateUtils.addMonths(fpago,-duracion)
                    m.proximoPago=ul
                    m.ultimoPago=null
                    m.save()
                    if(m.getAtraso()>=m.getTolerancia()){
                        socio.activo=false
                        socio.save()
                    }
                }
            }
            
            
        }
    }
}
