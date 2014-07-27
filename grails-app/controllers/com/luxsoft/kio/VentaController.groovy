package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import grails.converters.JSON

class VentaController {
    static scaffold = true

    def ventaService

    def index(Long max){
    	params.max = Math.min(max ?: 20, 100)
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
		def tipo=params.tipo?:'%'
		def query=Venta.where{tipo.clave=~tipo}
		
		[ventaInstanceList:query.list(params),ventaInstanceListTotal:query.count(params)]
    }

    def create(){
        
    	def ventaInstance=new Venta(fecha:new Date())
    	render view:'spa/spaCreate' ,model:[ventaInstance:ventaInstance]
		
    }
	
	

    def save(Venta venta){
    	//log.info 'Salvando venta: '+params
        venta.moneda=MonedaUtils.PESOS
        venta.status='PEDIDO'
        log.info 'Venta: '+venta
        log.info 'Partidas:'+venta.partidas
        //redirect action:'create'
        
    	//def venta=cmd.toVenta()
    	venta.validate()
    	if(venta.hasErrors()){
    		flash.message="Errores de validacion al intentar salvar la venta"
    		render view:'create',model:[ventaInstance:venta]
    	}
    	println 'Salvando venta:'+venta.errors
    	venta=ventaService.salvar(venta)
    	flash.message="Venta $venta.id generada"
    	//render view:'show',model:[id:venta.id]
        //respond venta,[view:'show',model:[ventaInstance:venta]]
        redirect action:'index'
        
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

    def productosPorCliente(Long id){
        log.info 'Localizando servicios para cliente: '+id
        def list=ServicioPorSocio.findAll("from ServicioPorSocio s where s.socio.cliente.id=?",[id])
        def res=list.collect{
            [servicioPorSocio:it.id
            ,producto:it.servicio.id
            ,clave:it.servicio.clave
            ,descripcion:it.servicio.descripcion
            ,unidad:it.servicio.unidad
            ,cantidad:1.0
            ,precioUnitario:it.servicio.precioBruto
            ,importeBruto:it.precioNeto]
        }
        render res as JSON
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
