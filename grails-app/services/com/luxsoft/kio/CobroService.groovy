package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class CobroService {

	def pagoService 

    def save(Cobro cobro) {
		//cobro.validate()
		// if(cobro.hasErrors()){
		// 	throw new CobroException(cobro:cobro,message:'Errores de validacion')
		// }
		
		def venta=cobro.venta

		cobro.pago=pagoService.registrarPago(cobro)

		cobro=cobro.save failOnError:true
		//def aplicacion=generarAplicacion(pago,venta)
		//def actualizarSaldo(venta)
		
		return cobro
    }
    
	
	def delete(Cobro cobro){
		def pago=cobro.pago
		if(pago.aplicaciones.size()>1){
			throw new CobroException(message:'Pago con aplicaciones adicionales, eliminar desde pagos',cobro:cobro)
		}
		cobro.pago=null
		cobro.delete flush:true
		pagoService.delete(pago)
	}
	
	
}

class CobroException extends RuntimeException{
	Cobro cobro
	String message
}
