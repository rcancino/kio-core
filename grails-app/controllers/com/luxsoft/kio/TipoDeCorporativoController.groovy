package com.luxsoft.kio
import org.springframework.security.access.annotation.Secured
import grails.transaction.Transactional

@Secured(["hasAnyRole('ADMINISTRACION')"])
@Transactional
class TipoDeCorporativoController {

	
    static scaffold = true



    @Transactional
    def delete(TipoDeCorporativo tipoDeCorporativoInstance){
    	tipoDeCorporativoInstance.delete flush:true
    	flash.message="Corporativo eliminado: "+tipoDeCorporativoInstance.clave
    	redirect action:'index'


    }
}
