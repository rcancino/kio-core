package com.luxsoft.kio

import grails.transaction.Transactional

import org.springframework.beans.BeanUtils

import com.luxsoft.cfdi.CfdiFolio

import org.apache.commons.lang.StringUtils

@Transactional
class SocioService {

    def salvarSocio(Socio socio) {
        if(socio.id){
			throw new SocioError(message:'Socio ya registrado')
		}
    	socio.validate()
    	if(socio.hasErrors()){
    		throw new SocioError(message:'Errores de validacion en socio',socio:socio)
    	}
        
        //log.debug 'Direccion de socio: '+socio.direccion
        def cliente=socio.cliente
        
        if(!cliente.id){
            cliente.nombre=socio.nombre
            cliente.tipo=TipoDeCliente.first()
            if(!cliente.validate(['rfc'])){
                cliente.rfc='XAXX010101000'
            }
            cliente.save flush:true
            //socio.cliente=cliente
        }
        //socio.membresia.validate()
        
        if(socio.id==null){
            def folio=CfdiFolio.findBySerie('SOCIOS')
            if(folio==null){
                folio=new CfdiFolio(serie:'SOCIOS',folio:60000)
                folio.save flush:true
            }
            socio.numeroDeSocio=StringUtils.leftPad(folio.next().toString(),6,'0')
        }
        
    	socio=socio.save failOnError:true
        
    	return socio
    }
	
	def actualizarSocio(Socio socio) {
		
				
		socio=socio.save failOnError:true
		
		return socio
	}

    def actualizarFoto(Socio socio){
        socio.save()
        return socio
    }

    def delete(Socio socio){
        socio.delete flush:true
    }
	
    def Socio activar(Socio socio,boolean valor){
		socio.activo=valor
		socio.save()
		SocioLog log=new SocioLog()
		log.nombreDeSocio=socio.nombre
		log.numeroDeSocio=socio.numeroDeSocio
		log.numeroDeTarjeta=socio.tarjeta
		log.activo=socio.activo
		log.save()
		
	}
}


class SocioError extends RuntimeException{
	
	String message
	Socio socio


}



