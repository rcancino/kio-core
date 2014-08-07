package com.luxsoft.kio

import grails.converters.JSON

class SocioController {
    
    //static scaffold = true
	
	def importadorService
	def socioService
	
	def index(Long max){
		params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
	}

	def create(){
		[socioInstance:new Socio()]
	}
	def save(Socio socioInstance){
		
		if(socioInstance.cliente==null){
		 	
		 	def cliente=new Cliente(params.cliente)
		 	cliente.emailCfdi=socioInstance.cfdiEmail
		 	if(!cliente.rfc){
		 		cliente.rfc='XAXX010101000'
		 	}
		 	
			socioInstance.cliente=cliente
		}
		if(socioInstance.perfil==null){
			socioInstance.perfil=new SocioPerfil(tipoDeSocio:TipoDeSocio.first())
		}
		/*
		if(socioInstance.membresia==null){
			socioInstance.membresia=new SocioMembresia()
		}*/

		socioInstance.validate()
		if(socioInstance.hasErrors()){
			log.info 'Errores de validacion'
			flash.message="Errores de validación"
			render view:'create',model:[socioInstance:socioInstance]
			return
		}
		socioInstance=socioService.salvarSocio(socioInstance)
		render view:'edit',model:[socioInstance:socioInstance]
	}

	def edit(Socio socioInstance){
		flash.message="Editando socio"

		render view:'edit',model:[socioInstance:socioInstance]
	}
	def update(Socio socioInstance){
		
		socioInstance.validate()
		if(socioInstance.hasErrors()){
			log.debug 'Erores de validacion: '+socioInstance.errors
			flash.message="Errores de validacion en el socio"
			render view:'edit/edit',model:[socioInstance:socioInstance]
			return 
		}
		socioInstance=socioService.salvarSocio(socioInstance)
		flash.message="Socio modificado $socioInstance.id"
		//render view:'edit',model:[socioInstance:socioInstance]
		redirect action:'index'
	}

	def delete(Socio socioInstance){
		socioService.delete(socioInstance)
		flash.messge="Socio eliminado: "+socioInstance.id
		redirect action:'index'
	}
	
	def importar(){
		importadorService.importarSocios()
		redirect action:'index'
	}
	
	def search(){
		def s=params.term?:'%'
		s+='%'
		def materno=params.materno?:'%'

		def query=Socio.where{apellidoPaterno=~s || apellidoMaterno=~s }
		def list=query.list(max:30,sort:'apellidoPaterno')
		//log.info 'Search result: '+list+ '  search params: '+s
		render view:'index',model:[socioInstanceList:list,socioInstanceCount:query.count()]
	}

	def cargarFoto(SocioFotoCmd cmd){
		if(cmd.hasErrors()){
			log.info 'Errores al cargar la imagen'
			redirect action:'edit',id:cmd.socioId,fragment:'perfil'
			return
		}
		def socio=Socio.findById(cmd.socioId)
		if(socio.foto==null)
			socio.foto=new SocioFoto()
		socio.foto.imagen=cmd.foto	
		socio=socioService.actualizarFoto(socio)
		//redirect action:'edit',model:[socioInstance:socio],fragment:'#perfil'
		render view:'edit',model:[socioInstance:socio]
	}

	def renderFoto(Long id){
		def socio=Socio.get(id)
		if(socio?.foto){
			response.setContentLength(socio.foto.imagen.size())
        	response.outputStream.write(socio.foto.imagen)
		}else{
			response.sendError(404)
			//render "holder.js/200x200'"
		}
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

	def spa(){
		render view:'spa/create'
	}
	
	
}

class SocioFotoCmd{
	
	Long socioId
	byte[] foto

	static constraints = {
    	importFrom SocioPerfil, include: ["foto"]
	}

}
