package com.luxsoft.kio

import grails.transaction.Transactional
import org.apache.commons.lang.exception.ExceptionUtils

@Transactional
class VentaService {

    def salvar(Venta venta) {
    	
    	try {
			//venta.actualizarImportes()
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

    def eliminarPartida(VentaDet det){
        def venta=det.venta
        venta.removeFromPartidas(det)
        venta.actualizarImportes()
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


}

class VentaException extends RuntimeException{
	String message
	Venta venta
}
