package com.luxsoft.kio

import grails.transaction.Transactional

import org.apache.commons.lang.exception.ExceptionUtils

import com.luxsoft.cfdi.MonedaUtils;

@Transactional
class VentaService {

    def salvar(Venta venta) {
    	try {
            registrarPagoMembresia(venta)
			actualizarTotales(venta)
    		venta.save failOnError:true
    	}
    	catch(Exception e) {
    		String msg=ExceptionUtils.getRootCauseMessage(e)
    		log.error 'Error al salvar venta '+msg,e
    		throw new VentaException(message:msg,venta:venta)
    	}
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
        actualizarPartida(det)
        actualizarTotales(det.venta)
        det.save failOnError:true
        return det
    }

    def agregarPartida(Long ventaId,VentaDet det){
        def venta=Venta.get(ventaId)
        def prod=det.producto
        
		det.precio=prod.precioNeto
        det.importe=det.precio*det.cantidad
        det.subTotal=det.importe
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
				socio.servicios.each{
					def det=new VentaDet(it)
					det.cantidad=1
					det.actualizarImportes()
					det.impuesto=MonedaUtils.calcularImpuesto(det.importe)
					venta.addToPartidas(det)
				}
			}
		}
		return this
	}
	
	def actualizarTotales(Venta venta){
		venta.importe=venta.partidas.sum 0.0 ,{it.importe}
		venta.descuento=venta.partidas.sum 0.0,{it.descuento}
		venta.subTotal=venta.partidas.sum 0.0,{it.subTotal}
		venta.impuesto=venta.partidas.sum 0.0,{it.impuesto}
		venta.total=venta.subTotal+venta.impuesto
	}

    def actualizarPartida(VentaDet det){
        def prod=det.producto
        det.precio=prod.precioNeto
        det.importe=det.precio*det.cantidad
        det.subTotal=det.importe
        det.impuesto=MonedaUtils.calcularImpuesto(det.importe)
    }


}

class VentaException extends RuntimeException{
	String message
	Venta venta
}
