package com.luxsoft.kio

import grails.converters.JSON
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','MOSTRADOR')"])
class SocioController {
    
    //static scaffold = true
	
	def importadorService
	def socioService
	
	def index(Long max){
		println 'index action'
		params.max = Math.min(max ?: 20, 100)
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
	}

	def create(){
		[socioInstance:new Socio()]
	}
	def save(Socio socioInstance){
		
		println 'Cliente de socio: '+params.cliente.direccion
		
		
		if(socioInstance.cliente==null){
		 	
		 	def cliente=new Cliente(params.cliente)
		 	cliente.emailCfdi=socioInstance.cfdiEmail
		 	if(!cliente.rfc){
		 		cliente.rfc='XAXX010101000'
		 	}
		 	
			socioInstance.cliente=cliente
		}
		println socioInstance.cliente
		
		if(socioInstance.perfil==null){
			//socioInstance.perfil=new SocioPerfil(tipoDeSocio:TipoDeSocio.first())
		}
		/*
		if(socioInstance.membresia==null){
			socioInstance.membresia=new SocioMembresia()
		}*/
		socioInstance.nombre=socioInstance.toString()
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

	def show(Socio socioInstance){
		//edit(socioInstance)
		[socioInstance:socioInstance]
	}

	def edit(Socio socioInstance){
		//flash.message="Editando socio"

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
		socioInstance.membresia.validate()
		if(socioInstance.membresia.hasErrors()){
			log.debug 'Erores de validacion de membresia: '+socioInstance.membresia.errors
			flash.message="Errores en membresia de socio "+socioInstance.membresia.errors
			render view:'edit/edit',model:[socioInstance:socioInstance]
			return
		}
		
		socioInstance=socioService.actualizarSocio(socioInstance)
		flash.message="Socio modificado $socioInstance.nombre"
		redirect action:'index'
	}

	def delete(Socio socioInstance){
		socioService.delete(socioInstance)
		flash.messge="Socio eliminado: "+socioInstance.id
		redirect action:'index'
	}
	
	@Secured(["hasAnyRole('ROLE_ADMIN')"])
	def importar(){
		importadorService.importarSocios()
		redirect action:'index'
	}
	
	def search(){
		def s='%'+params.nombre?:'%'
		s+='%'
		def query=Socio.where{nombre=~s }
		def list=query.list(max:30,sort:'nombre')
		render view:'index',model:[socioInstanceList:list,socioInstanceCount:query.count()]
	}

	def find(Socio socio){

		log.info 'Busqueda avanzada de socio en base a:'+socio
		def query=Socio.where{
			apellidoPaterno==socio.apellidoPaterno || apellidoMaterno==socio.apellidoMaterno || nombres==socio.nombres || numeroDeSocio==socio.numeroDeSocio
		}
		def list=query.list(max:30,sort:'nombre')
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

	def activar(Socio socio){
		socio=socioService.activar(socio, !socio.activo)
		redirect action:'edit',params:[id:socio.id]
	}
	
	
	def suspender(Socio socio){
		socio=socioService.activar(socio, !socio.activo)
		redirect action:'edit',params:[id:socio.id]
	}
	

	def getSociosJSON() {

		def term='%'+params.term.trim()+'%'
		def query=Socio.where{
		 	//apellidoPaterno=~term || apellidoMaterno=~term || nombres=~term
		 	nombre=~term
		 }
		def list=query.list(max:30, sort:"nombre")
		
		list=list.collect{ c->
			def nombre=c.toString()
			[id:c.id,
			label:nombre,
			value:nombre,
			nombre:nombre,
			cliente:[id:c.cliente.id,nombre:c.cliente.nombre]
			]
		}
		def res=list as JSON
		
		render res
	}

	def spa(){
		render view:'spa/create'
	}

	def actualizarTarjeta(Socio socioInstance){
		log.info 'Actualizando tarjeta socio: '+socioInstance
		def tarjeta=params.tarjeta
		def found=Socio.find("from Socio s where s.id!=? and s.tarjeta=?",[socioInstance.id,tarjeta])
		if(found){
			flash.message="No se puede asignar tarjeta ya que está asignada a: $found"
			redirect action:'edit',params:[id:socioInstance.id]
			return	
		}
		socioInstance.tarjeta=params.tarjeta
		socioInstance.save flush:true
		socioService.logAccess(socioInstance)
		flash.message="Tarjeta actualizada"
		redirect action:'edit',params:[id:socioInstance.id]
	}
	
	
}

class SocioFotoCmd{
	
	Long socioId
	byte[] foto

	static constraints = {
    	importFrom SocioPerfil, include: ["foto"]
	}

}
