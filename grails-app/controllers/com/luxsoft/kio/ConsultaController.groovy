package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured
import grails.converters.JSON

@Secured(["hasAnyRole('ADMINISTRACION','MOSTRADOR','CAJERO')"])
class ConsultaController {

    def socioService

    def index() { }

    def socios(){
    	params.max = 30
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
    }

    def showSocio(Socio socio){
    	if(socio==null){
    		redirect action:'socios'
    		return
    	}
    	//log.info 'Mostrando detalle de socio'
    	[socioInstance:socio]
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
        redirect action:'showSocio',params:[id:socio.id]
    }

    def actualizarDireccion(Direccion direccion){
        //log.info 'Actualizando direccion: '+params
        def socio=Socio.get(params.id)
        assert socio,'No localizo el socio: '+params.socio
        log.info 'Nueva direccion: '+direccion
        direccion.validate()
        if(direccion.hasErrors()){
            render direccion as JSON
        }
        Direccion.sleep(2000)
        socio.direccion=direccion
        socio=socioService.actualizarSocio(socio)

        def data=socio.direccion as JSON
        render data

    }
    
    def actualizarMembresia(){
        def socio=Socio.get(params.id)
        assert socio,'No localizo el socio: '+params.socio
        log.info 'Actualizando membresia: '
        
        bindData(socio.membresia,params,[include: ['ultimoPago', 'proximoPago','toleranca']])
        socio=socioService.actualizarSocio(socio)
        def membresia=socio.membresia
        def data= membresia as JSON
        render data
    }
    def actualizarContacto(){
        def socio=Socio.get(params.id)
        assert socio,'No localizo el socio: '+params.socio
        log.info 'Actualizando contacto: '
        
        bindData(socio,params,[include: ['telefonoCasa', 'telefonoTrabajo','celular','email','email2','tarjeta']])
        socio=socioService.actualizarSocio(socio)
        def data= socio as JSON
        render data
    }
}
