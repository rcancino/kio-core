package com.luxsoft.kio

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured
import grails.validation.Validateable

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
@Transactional(readOnly = true)
class NotaDeCreditoDetController {

    def index() { }

    def agregarConcepto(NotaDeCredito nota){
    	[notaDeCreditoInstance:nota,concepto:new NotaDeCreditoDet()]
    }
 
    @Transactional
    def save(NotaDeCreditoDet concepto){
    	def nota=NotaDeCredito.get(params.nota)
    	assert nota,'Debe existir la nota origen'

    	concepto.validate()
    	if(concepto.hasErrors()){
    		
    		flash.message="Errores de validacion"
    		render view:'agregarConcepto', model:[notaDeCreditoInstance:nota,concepto:concepto]
    		return
    	}
    	nota.addToConceptos(nota)
    	nota.save failOnError:true
    	flash.message="Concepto agregado"
    	redirect action:'edit', controller:'notaDeCredito',params:[id:nota.id]

    }
}
