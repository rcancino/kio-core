package com.luxsoft.kio

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured
import grails.validation.Validateable
import com.luxsoft.cfdi.MonedaUtils

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
        if(concepto.cantidad && concepto.valorUnitario){
            concepto.importe=concepto.cantidad*concepto.valorUnitario
        }
    	concepto.validate()
    	if(concepto.hasErrors()){
    		
    		flash.message="Errores de validacion"
    		render view:'agregarConcepto', model:[notaDeCreditoInstance:nota,concepto:concepto]
    		return
    	}

    	nota.addToConceptos(concepto)
        nota.subTotal=nota.conceptos.sum 0.0,{it.importe}
        nota.impuesto=MonedaUtils.calcularImpuesto(nota.subTotal)
        nota.total=nota.subTotal+nota.impuesto
    	nota.save flush:true
    	flash.message="Concepto agregado"
    	redirect action:'edit', controller:'notaDeCredito',params:[id:nota.id]

    }

    @Transactional
    def eliminar(NotaDeCreditoDet concepto){
        def nota=concepto.nota
        nota.removeFromConceptos(concepto)
        nota.subTotal=nota.conceptos.sum 0.0,{it.importe}
        nota.impuesto=MonedaUtils.calcularImpuesto(nota.subTotal)
        nota.total=nota.subTotal+nota.impuesto
        nota.save flush:true
        flash.message="Concepto eliminado"
        redirect action:'edit', controller:'notaDeCredito',params:[id:nota.id]

    }
}
