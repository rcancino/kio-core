package com.luxsoft.kio

import grails.converters.JSON

class ClienteController {
    
	static scaffold = true
	
	def importadorService
	
	def index(Long max){
		params.max = Math.min(max ?: 25, 100)
		params.sort=params.sort?:'nombre'
		params.order='asc'
		[clienteInstanceList:Cliente.list(params),clienteInstanceCount:Cliente.count()]
	}
	
	
    def importar(){
    	importadorService.importarClientes()
		redirect action:'index'
    }
	
	def search(){
		def s=params.term?:'%'
		s+='%'
		def query=Cliente.where{nombre=~s}
		render view:'index',model:[clienteInstanceList:query.list(max:20,sort:'nombre'),clienteInstanceCount:query.count()]
		
	}

	

	def getClientesJSON() {

		def term='%'+params.term.trim()+'%'
		def query=Cliente.where{
		 	nombre=~term 
		 }
		def list=query.list(max:30, sort:"nombre")
		//println 'Buscando clientes JSON: '+list.size()+' params: '+params.term
		list=list.collect{ c->
			def nombre="$c.nombre"
			def direccion=c.direccion as JSON
			[id:c.id,
			label:nombre,
			value:nombre,
			rfc:c.rfc,
			direccion:direccion
			]
		}
		def res=list as JSON
		
		render res
	}


}
