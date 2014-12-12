package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured
import grails.converters.JSON
import com.luxsoft.sec.LuxorSession

@Secured(["hasAnyRole('ADMINISTRACION','MOSTRADOR','CAJERO')"])
class ConsultaController {

    def socioService
    def productoService

    def index() { }

    def socios(){
    	params.max = 30
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
    }

    def buscarPorNumeroDeSocio(){
        params.max = 30
        params.sort=params.sort?:'lastUpdated'
        params.order='desc'
        def list=Socio.findAllByNumeroDeSocioLike(params.numero+"%")
        render view:'socios',model:[socioInstanceList:list,socioInstanceCount:list.size()]
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
        //Direccion.sleep(2000)
        socio.direccion=direccion
        socio=socioService.actualizarSocio(socio)

        def data=direccion.properties as JSON
        render data

    }
    
    def actualizarMembresia(){
        def socio=Socio.get(params.id)
        assert socio,'No localizo el socio: '+params.socio
        log.info 'Actualizando membresia: '
        
        bindData(socio.membresia,params,[include: ['ultimoPago', 'proximoPago','toleranca','servicio','diaDeCorte']])
        
        
        if(params.tipoDeCorporativo){
            //println 'Tipo de corporativo: '+params.tipoDeCorporativo
            def corporativo=null
            if(params.tipoDeCorporativo!='null'){
                corporativo=TipoDeCorporativo.get(params.tipoDeCorporativo)
                
            }
            socio.perfil.tipoDeCorporativo=corporativo
        }

        def servicio=Producto.get(params.productoId)
        if(servicio){
            socio.membresia.servicio=servicio
        }
        
        socio=socioService.actualizarSocio(socio)
        def now=new Date()
        // def membresia=socio.membresia
        // def data= membresia as JSON
        // render data
        def diasParaProximoPago=socio.membresia.diasParaProximoPago
        def data= [diasParaProximoPago:diasParaProximoPago]
        data.atraso=socio.membresia.atraso
        data.suspender=socio.membresia.getSuspender()?.format('dd/MM/yyyy')
        
        render data as JSON

    }
    def actualizarContacto(){
        def socio=Socio.get(params.id)
        assert socio,'No localizo el socio: '+params.socio
        log.info 'Actualizando contacto: '
        if(!socio.membresia.diaDeCorte){
            socio.membresia.diaDeCorte=1
        }
        bindData(socio,params,[include: ['telefonoCasa', 'telefonoTrabajo','celular','email','email2','tarjeta']])
        socio=socioService.actualizarSocio(socio)
        def data= socio as JSON
        render data
    }

    def productos(){
        log.info 'Productos...'
        params.max = 30
        params.sort=params.sort?:'lastUpdated'
        params.order='desc'
        [productoInstanceList:Producto.list(params),productoInstanceCount:Producto.count()]
    }

    def showProducto(Producto p){
        [productoInstance:p]
    }

    def actualizarProducto(Producto p){
        productoService.save(p)
        redirect action:'productos'
    }

    def sesiones(){
        [luxorSessionList:LuxorSession.list()]
    }

    
}
