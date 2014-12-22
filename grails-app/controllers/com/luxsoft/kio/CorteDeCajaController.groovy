package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured
import org.apache.commons.lang.StringUtils
import org.grails.databinding.BindingFormat
import grails.validation.Validateable

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
class CorteDeCajaController {

    def corteDeCajaService

    def index() { 
    	params.max = 50
    	params.sort?:'lastUpdated'
    	params.order?:'asc'
    	//def list=CorteDeCaja.list()  //.findAll("from CorteDeCaja c where date(c.fecha)=?",new Date())
        def cajero=getAuthenticatedUser().username
        def time=session.fecha?:new Date()
        def list=CorteDeCaja.findAll("from CorteDeCaja c where date(c.fechaHora)=? and c.cajero=?",[time,cajero])
    	[corteDeCajaInstanceList:list,fecha:time]
    }

    def create(CorteDeCajaCommand command){
        //Todos los pagos del dia del cajero
        def cajero=getAuthenticatedUser().username
        def corte=corteDeCajaService.generarCorte(cajero,command.fecha)
    	[corteDeCajaInstance:corte,partidas:corte.partidas]
    }

    def save(CorteDeCaja corteDeCajaInstance){
        println 'Corte: '+corteDeCajaInstance
        
    	corteDeCajaInstance=corteDeCajaService.generarCorte(corteDeCajaInstance.cajero,corteDeCajaInstance.fechaHora)
        corteDeCajaInstance.creadoPor=getAuthenticatedUser().username
        corteDeCajaInstance=corteDeCajaService.salvar(corteDeCajaInstance)
        flash.message="Corte registrado: $corteDeCajaInstance.id "
        redirect action:'index'
    }

    @Secured(["hasAnyRole('ADMINISTRACION')"])
    def delete(CorteDeCaja corteDeCajaInstance){
        // assert aplicacion,'Error aplicacion no puede ser nula'
        // def pago=pagoService.eliminarAplicacion(aplicacion)
        // flash.message="Aplicacion $aplicacion.id eliminada"
        // redirect action:'edit',params:[id:pago.id]
    }

    def show(CorteDeCaja corteDeCajaInstance){
        [corteDeCajaInstance:corteDeCajaInstance,partidas:corteDeCajaInstance.partidas]
    }
}

@Validateable
class CorteDeCajaCommand{

    @BindingFormat('dd/MM/yyyy')    
    Date fecha=new Date()
    

    
}

