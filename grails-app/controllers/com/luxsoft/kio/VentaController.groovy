package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import grails.converters.JSON
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('MOSTRADOR')"])
class VentaController {
    //static scaffold = true

    def ventaService

    def index(Long max){
    	params.max = Math.min(max ?: 20, 100)
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
		def query=Venta.where{status=='PEDIDO'}
		
		[ventaInstanceList:query.list(params),ventaInstanceListTotal:query.count()]
    }

    def todas(PeriodoCommand command){
        def list=Venta.executeQuery("from Venta v where date(v.fecha) between ? and ? "
            ,[command.fechaInicial,command.fechaFinal])
        [ventaInstanceList:list,ventaInstanceListTotal:list.size(),periodo:command]
    }

    
    def create(){
        
    	def ventaInstance=new Venta(fecha:new Date(),tipo:TipoDeVenta.first())
    	//render view:'spa/spaCreate' ,model:[ventaInstance:ventaInstance]
        [ventaInstance:ventaInstance]
		
    }
	
	def mandarFacturar(Venta ventaInstance){
		ventaService.mandarFacturar(ventaInstance)
		redirect action:'index'
	}
	
	

    def save(Venta venta){
    	venta.fecha=new Date()
        venta.moneda=MonedaUtils.PESOS
        venta.status='PEDIDO'
        log.info 'Venta: '+venta
        venta.creadoPor=getAuthenticatedUser().username
        //redirect action:'create'
        
    	//def venta=cmd.toVenta()
    	venta.validate()
    	if(venta.hasErrors()){
            log.info "Has Errores2:" +venta.hasErrors()
    		flash.message="Errores de validacion al intentar salvar la venta"
    		render view:'create',model:[ventaInstance:venta]
            return
    	}
    	venta=ventaService.salvar(venta)
    	//flash.message="Venta $venta.id generada"
        //redirect action:'index'
        redirect action:'edit',params:[id:venta.id]
        
        
    }

    def edit(Long id){
        
        Venta ventaInstance=Venta.get(id)
        if(ventaInstance.cfdi){
            redirect action:'show',params:[id:id]
        }
        [ventaInstance:ventaInstance]
    }

    def show(Venta ventaInstance){
        [ventaInstance:ventaInstance]
    }

    def update(Venta ventaInstance){
        log.info 'Actualizando ventas:'
        flash.message="Venta $ventaInstance.id actualizada"
        chain action:'index'
        //[ventaInstance:ventaInstance]
    }

    def getServiciosJSON(Long clienteId) {
        log.info params
        def list=ServicioPorSocio.findAll("from ServicioPorSocio s where s.socio.cliente.id=?",[clienteId])
        
        def data=list.collect{ s->
            
            [id:s.id,
            servicio:[clave:s.servicio.clave,descripcion:s.servicio.descripcion],
            precioBruto:s.servicio.precioBruto
            ]
        }
        def res=data as JSON
        render res
    }

    def crearPartidasPorServiciosDeCliente(Long clienteId){
        def list=ServicioPorSocio.findAll("from ServicioPorSocio s where s.socio.cliente.id=?",[clienteId])
        def res=list.collect{
            new VentaDet(
                servicioPorSocio:it
                ,producto:it.servicio
                ,cantidad:1.0
                ,precioUnitario:it.precioBruto
                ,importeNeto:it.precioNeto
                ,descuentoTasa:it.descuento
                ,importeBruto:it.precioNeto)
        }
        render template:"partidasGrid",model:[partidas:res]
    }

    def productosPorCliente(Long clienteId){
        log.info 'Localizando servicios para cliente: '+clienteId
        def list=ServicioPorSocio.findAll("from ServicioPorSocio s where s.socio.cliente.id=?",[clienteId])
        def res=list.collect{
            [servicioPorSocio:it.id
            ,producto:it.servicio.id
            ,clave:it.servicio.clave
            ,descripcion:it.servicio.descripcion
            ,unidad:it.servicio.unidad
            ,cantidad:1.0
            ,precio:it.servicio.precioNeto
            ,importe:it.servicio.precioNeto]
        }
        render res as JSON
    }

    def delete(Venta venta){
        ventaService.eliminar(venta)
        flash.message="Venta eliminada ${venta.id}"
        redirect action:'index'
    }

    
}

class VentaPorSocioCmd {
	
	Socio socio
	
	@BindingFormat('dd/MM/yyyy')
	Date fecha
	
	TipoDeVenta tipo

	static constraints = {
        importFrom Venta
        
    }

    String toString(){
    	return "$socio ($tipo)"
    }

    Venta toVenta(){
    	Venta v=new Venta(
    		cliente:socio.cliente
    		,fecha:fecha
    		,tipo:tipo
    		,moneda:MonedaUtils.PESOS
    		,status:'PEDIDO')
    	return v
    }
}
