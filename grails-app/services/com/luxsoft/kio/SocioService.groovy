package com.luxsoft.kio

import grails.transaction.Transactional
import org.springframework.beans.BeanUtils


@Transactional
class SocioService {

    def salvarSocio(Socio socio) {
    	println 'Socio: '+socio
        println 'Membresia de cliente: '+socio.membresia.id
        
    	socio.validate()
    	if(socio.hasErrors()){
    		throw new SocioError(message:'Errores de validacion en socio',socio:socio)
    	}
        def cliente=socio.cliente
        
        
        if(cliente.nombre=='MOSTRADOR'){
            def target=new Direccion()
            
            def nvoCliente=new Cliente(
                nombre:"$socio.nombres $socio.apellidoPaterno $socio.apellidoMaterno",
                rfc:cliente.rfc,
                tipo:TipoDeCliente.findByClave('PARTICULAR'),
                direccion:new Direccion()
                )
            BeanUtils.copyProperties(socio.direccion,nvoCliente.direccion)
            nvoCliente.save failOnError:true
            socio.cliente=nvoCliente
        }
    	
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



