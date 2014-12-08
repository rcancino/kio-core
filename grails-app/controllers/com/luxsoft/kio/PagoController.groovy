package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured
import grails.validation.Validateable
import grails.converters.JSON
import org.grails.databinding.BindingFormat

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
class PagoController {

	def pagoService

    def index(Integer max) { 
    	params.max = Math.min(max ?: 40, 100)
    	params.sort?:'lastUpdated'
    	params.order?:'desc'
        //def list=Pago.executeQuery("from Pago p where (p.importe-p.aplicado)>0")
        def list=Pago.executeQuery("from Pago p order by lastUpdated desc")
    	[pagoInstanceList:list,pagoInstanceCount:list.size()]
    }

    def create(){
    	[pagoInstance:new Pago(fecha:new Date())]
    }

    def save(Pago pagoInstance){
    	pagoInstance.validate()
    	if(pagoInstance.hasErrors()){
    		flash.message="Errores de validacion"
    		render view:'create',model:[pagoInstance:pagoInstance]
    	}
    	pagoService.save(pagoInstance)
    	flash.message="Pago generado $pagoInstance.id"
    	render view:'edit',model:[pagoInstance:pagoInstance]
    }

    def edit(Pago pagoInstance){
    	[pagoInstance:pagoInstance]
    }

    def update(Pago pagoInstance){

    }

    def agregarAplicacion(Pago pagoInstance){
    	[aplicacionDePagoInstance:new AplicacionCommand(pago:pagoInstance,fecha:new Date())]
    }

    def salvarAplicacion(AplicacionCommand command){
        assert command,'AplicacionCommand no puede ser nulo'

        log.info 'Aplicando pago: '+command?.pago?.id
        log.info 'A Venta: '+command?.venta?.id
        log.info 'Importe:'+command?.importe
        command.validate()
        if(command.hasErrors()){
            flash.message="Errores de validacion"
            render view:'agregarAplicacion',model:[aplicacionDePagoInstance:command]
            return
        }
        //agregarAplicacion(Pago pago,Venta venta,Date fecha,BigDecimal importe,String comentario)
        def pago=pagoService.agregarAplicacion(
            command.pago
            ,command.venta
            ,command.fecha
            ,command.importe
            ,command.comentario)
        render view:'edit',model:[pagoInstance:pago]
        
    }
    
    @Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
    def delete(Pago pagoInstance){
        pagoService.delete(pagoInstance)
        flash.message="Pago $pagoInstance.id y todas sus aplicaciones eliminados"
        redirect action:'index'
    }

    
    def eliminarAplicacion(AplicacionDePago aplicacion){
        assert aplicacion,'Error aplicacion no puede ser nula'
        def pago=pagoService.eliminarAplicacion(aplicacion)
        flash.message="Aplicacion $aplicacion.id eliminada"
        redirect action:'edit',params:[id:pago.id]
    }

    def buscarVentasPendientesJSON() {

        def pago=Pago.get(params.id)
        def term='%'+params.term.trim()+'%'

        def query=Venta.where{
            cliente==pago.cliente && saldo>0 
         }
        def list=query.list(max:30, sort:"id")
        
        list=list.collect{ v->
            def descripcion="$v.id - ${v.fecha.format('dd/MM/yyyy')} Total:${v.total} Saldo:${v.saldo}"
            [id:v.id,
            ,label:descripcion
            ,total:v.total
            ,saldo:v.saldo
            ,importe:pago.disponible>v.saldo?v.saldo:pago.disponible
            ]
        }
        def res=list as JSON
        //log.info 'Buscando ventas disponibles para '+pago.cliente+ ' Found: '+res
        render res
    }

    @Secured(["hasAnyRole('ADMINISTRACION')"])
    def actualizarMembresias(Long id){
        pagoService.actualizarMembresias(id)
        flash.message="Membresias del pago actualizadas"
        redirect action:'edit',params:[id:id]
    }

    @Secured(["hasAnyRole('ADMINISTRACION')"])
    def cancelarPagoDeMembresias(Long id){
        pagoService.cancelarPagoDeMembresias(id)
        flash.message="Pago de membresias cancelado"
        redirect action:'edit',params:[id:id]
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

@Validateable
class AplicacionCommand{
    
    Venta venta
    Pago pago
    @BindingFormat('dd/MM/yyyy')
    Date fecha
    BigDecimal importe
    String comentario

    static constraints={
        importe min:1.0,validator:{val,obj->
            if(val>obj.pago.disponible){
                return 'excedeDisponible'
            }
            return true
        }
        comentario nullable:true
    }

    Aplicacion toAplicacion(){
        AplicacionDePago a=new AplicacionDePago(venta:venta,fecha:fecha,comentario:comentario,importe:importe)
        return a
    }
}
