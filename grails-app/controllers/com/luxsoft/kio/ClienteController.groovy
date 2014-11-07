package com.luxsoft.kio

import grails.converters.JSON
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','MOSTRADOR')"])
@Transactional
class ClienteController {
    
	static scaffold = true
	
	def importadorService
	
	def index(Long max){
		params.max = Math.min(max ?: 25, 100)
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		[clienteInstanceList:Cliente.list(params),clienteInstanceCount:Cliente.count()]
	}

	def spa(){
		render view:'spa/create'
	}

	@Secured(["hasAnyRole('ADMINISTRACION')"])
	def update(Cliente clienteInstance){
		clienteInstance.validate()
		if(clienteInstance.hasErrors()){
			render view:'create',model:[clienteInstance:clienteInstance]
			return
		}
		clienteInstance.save failOnError:true
		flash.message="Cliente actualizado: "+clienteInstance.id
		redirect action:'index'
	}

	
	
	@Secured(["hasAnyRole('ADMINISTRACION')"])
    def importar(){
    	importadorService.importarClientes()
		redirect action:'index'
    }
	
	def search(){
		println params
		def s='%'+params.nombre?:'%'
		s+='%'
		println 'Buscando por: '+s
		def query=Cliente.where{nombre=~s}
		render view:'index',model:[clienteInstanceList:query.list(max:30,sort:'nombre'),clienteInstanceCount:0]
		
	}

	

	def getClientesJSON() {

		// def term='%'+params.term.trim()+'%'
		// def query=Cliente.where{
		//  	nombre=~term 
		//  }
		// def list=query.list(max:30, sort:"nombre")

		def list=Cliente.findAllByNombreIlike("%"+params.term+"%",[max:10,sort:"nombre",order:"desc"])

		
		list=list.collect{ c->
			def nombre="$c.nombre"
			def direccion=[calle:c.direccion?.calle?:'']
			direccion.numeroInterior=c.direccion?.numeroInterior?:''
			direccion.numeroExterior=c.direccion?.numeroExterior?:''
			direccion.colonia=c.direccion?.colonia?:''

			def jsonDir=direccion as JSON
			//println 'Direccion: '+jsonDir
			jsonDir.toString()

			[id:c.id,
			label:nombre,
			value:nombre,
			nombre:nombre,
			rfc:c.rfc,
			//direccion:jsonDir,
			emailCfdi:c.emailCfdi,
			direccion:jsonDir
			]
		}
		def res=list as JSON
		
		render res
	}

	@Secured(["hasAnyRole('ADMINISTRACION')"])
	def delete(Cliente clienteInstance){
		clienteInstance.delete flush:true
		flash.message="Cliente eliminado $clienteInstance.nombre"
		redirect action:'index'
	}

	def socios(Cliente clienteInstance){
		def list=Socio.findAllByCliente(clienteInstance)
		[clienteInstance:clienteInstance,socioInstanceList:list]
	}

	def find(Cliente cliente){
		println 'Buscando cliente:  '+cliente.nombre
		def data=Cliente.findAll("from Cliente c where c.nombre like upper(?) or c.rfc like upper(?)"
			,[cliente.nombre,cliente?.rfc],[max:20,sort:'nombre'])
		//def list=query.list(max:30,sort:'nombre')
		render view:'index',model:[clienteInstanceList:data,clienteInstanceCount:0]


	}
}

class ClienteException extends RuntimeException{
	String message
	Cliente cliente
}
