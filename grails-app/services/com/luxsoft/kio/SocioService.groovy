package com.luxsoft.kio

import grails.transaction.Transactional
import org.springframework.beans.BeanUtils


@Transactional
class SocioService {

    def salvarSocio(Socio socio) {
    	log.info 'Salvando socio: '+socio
    	socio.validate()
    	if(socio.hasErrors()){
    		throw new SocioError(message:'Errores de validacion en socio',socio:socio)
    	}

    	if(socio.cliente.id==null){
    		def cliente=socio.cliente
    		log.debug 'Cliente nuevo al dar de alta socio: '+cliente
    		cliente.validate()
    		if(cliente.hasErrors()){
    			throw new SocioError(message:'Errores en los datos de facturacion',socio:socio)
    		}
    		cliente.save flush:true
    	}
    	socio=socio.save failOnError:true
    	return socio
    }
    /*
    Cliente createCliente(Socio socio){
        if(cliente==null){
            def target=new Direccion()
            BeanUtils.copyProperties(socio.direccion,target)
            cliente=new Cliente(
                nombre:"$apellidoPaterno $apellidoMaterno $nombres ",
                rfc:"'XAXX010101000'",
                direccion:target,
                tipo:TipoDeCliente.findByClave('MOSTRADOR')

            )
        }
    }
    */
}


class SocioError extends RuntimeException{
	
	String message
	Socio socio


}



