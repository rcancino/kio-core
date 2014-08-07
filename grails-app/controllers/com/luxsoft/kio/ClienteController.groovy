package com.luxsoft.kio

import grails.converters.JSON
import grails.transaction.Transactional

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

	/*
	def save(Cliente clienteInstance){
		println 'Salvando cliente nuevo';
		println 'Cliente: '+clienteInstance.direccion+ "  tipo: "+clienteInstance.tipo
		def stipo=clienteInstance.tipo
		def tipo=TipoDeCliente.first()
		println 'Tipo de cliente: '+tipo
		clienteInstance.tipo=tipo
		clienteInstance.validate()
		println 'Errores: '+clienteInstance.errors
	}*/
	
	
    def importar(){
    	importadorService.importarClientes()
		redirect action:'index'
    }
	
	def search(){
		println params
		def s='%'+params.term?:'%'
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

		def list=Cliente.findAllByNombreIlike(params.term+"%",[max:10,sort:"nombre",order:"desc"])

		
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

	def delete(Cliente clienteInstance){
		clienteInstance.delete flush:true
		flash.message="Cliente eliminado $clienteInstance.nombre"
		redirect action:'index'
	}
}

class ClienteException extends RuntimeException{
	String message
	Cliente cliente
}
