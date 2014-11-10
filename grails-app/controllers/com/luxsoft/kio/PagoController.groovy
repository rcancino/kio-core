package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured
import grails.validation.Validateable

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
class PagoController {

    def index(Integer max) { 
    	params.max = Math.min(max ?: 10, 100)
    	params.sort?:'lastUpdated'
    	params.order?:'asc'
    	[pagoInstanceList:Pago.list(params),pagoInstanceCount:Pago.count()]
    }

    def create(){
    	[pagoInstance:new Pago()]
    }

    /*
    def search(SearchPagoCommand command){
    	command.nombre=command.nombre?:'%'
        command.folio=command.folio?:'%'
		command.fechaInicial=command.fechaInicial?:new Date()-10
		command.fechaFinal=command.fechaFinal?:new Date()
		
		
		params.max = command.max ?: 50
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
		
		def args=[command.emisor
			,command.referencia
			,command.folio
			,command.fechaInicial
			,command.fechaFinal]
		def hql="from Pago p where lower(p.cliente.nombre) like ?  and c.folio like ? "+ 
			" and date(c.fecha) between ? and ? "
		if(command.total>0.0){
			args.add(command.total)
			hql+=" and c.total=?"
		}
		def list=Cfdi.findAll(hql,args,params)
		render view:'index',model:[cfdiInstanceList:list,cfdiInstanceCount:list.size()]
    }
    */
}


@Validateable
class SearchPagoCommand{

	Cliente cliente
	String nombre
	Date fechaInicial=new Date()-30
	Date fechaFinal=new Date()
	String referenciaBancaria

	static constraints={
		fechaInicial nullable:true
		fechaFinal nullable:true
		referenciaBancaria nullable:true
		nombre nullable:true
	}
}
