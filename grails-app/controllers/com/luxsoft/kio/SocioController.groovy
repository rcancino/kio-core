package com.luxsoft.kio

import grails.converters.JSON

class SocioController {
    static scaffold = true
	
	def importadorService
	def socioService
	
	def index(Long max){
		params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'apellidoPaterno'
		params.order='asc'
		
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
	}
	
	def importar(){
		importadorService.importarSocios()
		redirect action:'index'
	}
	
	def search(){
		def s='%'+params.term?:'%'
		s+='%'

		def query=Socio.where{apellidoPaterno=~s || apellidoMaterno=~s || nombres=~s}
		def list=query.list(max:20,sort:'apellidoPaterno')
		log.info 'Search result: '+list+ '  search params: '+s
		render view:'index',model:[socioInstanceList:list,socioInstanceCount:query.count()]
	}

	def save(Socio socioInstance,boolean mostrador){
		log.info 'Salvando socio:'+socioInstance+ ' Mostrador: '+mostrador
		if(mostrador){
			def cliente=Cliente.findByRfc('XAXX010101000')
			assert cliente,'Debe estar dado de alta  el cliente mostrador'
			socioInstance.cliente=cliente
		}
		socioInstance=socioService.salvarSocio(socioInstance)
		render view:'show',model:[socioInstance:socioInstance]
	}

	def getSociosJSON() {

		def term='%'+params.term.trim()+'%'
		def query=Socio.where{
		 	apellidoPaterno=~term || apellidoMaterno=~term || nombres=~term
		 }
		def list=query.list(max:30, sort:"apellidoPaterno")
		
		list=list.collect{ c->
			def nombre=c.toString()
			[id:c.id,
			label:nombre,
			value:nombre,
			cliente:[id:c.cliente.id,nombre:c.cliente.nombre]
			]
		}
		def res=list as JSON
		
		render res
	}

	
	
}
