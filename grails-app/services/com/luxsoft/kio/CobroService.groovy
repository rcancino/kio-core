package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class CobroService {

    def save(Cobro cobro) {
		cobro.validate()
		if(cobro.hasErrors()){
			throw new CobroException(cobro:cobro,message:'Errores de validacion')
		}
		cobro=cobro.save failOnError:true
		def venta=cobro.venta
		//def abonos=Cobro.executeQuery('select sum(c.importe) from Cobro c where c.venta=?',[venta])[0]
		//venta.abonos=abonos
		//venta.status='PAGADA'
		actualizarAbonos(venta)
		
		return cobro
    }
	
	def actualizarAbonos(Venta venta){
		def abonos=Cobro.executeQuery('select sum(c.importe) from Cobro c where c.venta=?',[venta])[0]
		venta.abonos=abonos
		if(venta.saldo<=0.0	)
			venta.status='PAGADA'
		venta.save()
	}
	
	def delete(Cobro cobro){
		def venta=cobro.venta
		cobro.delete flush:true
		
		venta.abonos-=cobro.importe
		venta.status='VENTA'
		venta.save flush:true
		
	}
	
	
}

class CobroException extends RuntimeException{
	Cobro cobro
	String message
}
