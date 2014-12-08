package com.luxsoft.kio

import grails.transaction.Transactional

import org.apache.commons.lang.exception.ExceptionUtils


import com.luxsoft.kio.MonedaUtils

@Transactional
class VentaService {

    def salvar(Venta venta) {
    	try {
            if(venta.tipo.clave=='MEMBRESIA'){
                registrarPagoMembresia(venta)
            }
			actualizarTotales(venta)
    		venta.save failOnError:true
    	}
    	catch(Exception e) {
    		String msg=ExceptionUtils.getRootCauseMessage(e)
    		log.error 'Error al salvar venta '+msg,e
    		throw new VentaException(message:msg,venta:venta)
    	}
    }

    def actualizar(Venta venta){
        if(venta.status=='PEDIDO')
            venta.save failOnError:true
        return venta
    }

    def eliminar(Venta venta){
        if(venta.cfdi){
            throw new VentaException(message:'Venta ya facturada imposible eliminar')
        }
        try {
            venta.delete flush:true

        }
        catch(Exception e) {
            String msg=ExceptionUtils.getRootCauseMessage(e)
            log.error 'Error al eliminar venta '+msg,e
            throw new VentaException(message:msg,venta:venta)
        }
        
        
    }

    def salvarPartida(VentaDet det){
        actualizarTotales(det.venta)
        det.save failOnError:true
        return det
    }

    def agregarPartida(Long ventaId,VentaDet det){
        def venta=Venta.get(ventaId)
        det.precio=det.producto.precioNeto
        venta.addToPartidas(det)
		actualizarTotales(venta)
        //venta.save failOnError:true
        return venta
    }

    def eliminarPartida(VentaDet det){
        def venta=det.venta
        venta.removeFromPartidas(det)
        actualizarTotales(venta)
        venta.save failOnError:true
        //println 'Partida eliminada venta: '+venta?.id
        return venta
    }

    def mandarFacturar(Venta venta){
        if(venta.status=='PEDIDO'){
            venta.status='VENTA'
            venta.save()
            //Todo Mandar mesanje de venta pendiente de facturar
            return venta
        }else{
            throw new RuntimeException(
                message:"Solo se pueden mandar facturar ventas en status PEDIDO status actual:${venta.status}",
                venta:venta
                )
        }
    }
	
	def registrarPagoMembresia(Venta venta){
		
		if(!venta.partidas){
			
			def socios=Socio.findAll{cliente==venta.cliente}
			socios.each{socio ->
                def s=socio.membresia.servicio
                if(s){

                    def det=new VentaDet()
                    det.socio=socio
                    det.producto=s
                    det.precio=s.precioNeto
                    det.cantidad=1
                    //det.actualizarImportes()
                    //det.impuesto=MonedaUtils.calcularImpuesto(det.importe)
                    log.debug 'Agregando membresia : '+det.producto
                    venta.addToPartidas(det)
                }
				
			}
		}
		
		return this
	}
	
	

    

    def actualizarTotales(Venta venta){
        venta.partidas.each{ det ->
            det.actualizarImportes()
        }
        //venta.descuento=0.0
        //venta.total=venta.partidas.sum 0.0 ,{it.subTotal}
        venta.actualizarImportes()
        
    }


}

class VentaException extends RuntimeException{
	String message
	Venta venta
}
