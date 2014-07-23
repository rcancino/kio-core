package com.luxsoft.kio

import grails.transaction.Transactional
import org.apache.commons.lang.exception.ExceptionUtils

@Transactional
class VentaService {

    def salvar(Venta venta) {
    	
    	try {
    		venta.save failOnError:true
    	}
    	catch(Exception e) {
    		String msg=ExceptionUtils.getRootCauseMessage(e)
    		log.error 'Error al salvar venta '+msg,e
    		throw new VentaException(message:msg,venta:venta)
    	}
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
