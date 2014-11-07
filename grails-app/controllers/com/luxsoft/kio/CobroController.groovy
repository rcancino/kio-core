package com.luxsoft.kio

class CobroController {

    def cobroService
    
    def index(Long max){
        params.max = Math.min(max ?: 50, 100)
        params.sort=params.sort?:'dateCreated'
        params.order='desc'
        [cobroInstanceList:Cobro.list(params),cobroInstanceListTotal:Cobro.count()]
    }

    def pendientes(Long max){
        params.max = Math.min(max ?: 50, 100)
        params.sort=params.sort?:'dateCreated'
        params.order='desc'
        def query=Venta.where{status=='VENTA' }
        [ventaInstanceList:query.list(params),ventaInstanceListTotal:query.count(params)]
    }

    def registrar(Venta venta){
        if(!venta){
            response.sendError(404)

        }else{
            def cobroInstance=new Cobro(fecha:new Date(),cliente:venta.cliente,importe:venta.total,formaDePago:'EFECTIVO')
            [ventaInstance:venta,cobroInstance:cobroInstance]
        }
    }

    def show(Cobro cobroInstance){
        [cobroInstance:cobroInstance]
    }

    def cobrar(Cobro cobroInstance){
        if(!cobroInstance){
            response.sendError 404
        }else{
            try {
				def venta=Venta.get(params.ventaId)
				cobroInstance.venta=venta
				cobroInstance.cliente=venta.cliente
				cobroInstance.recibe=cobroInstance.importe
				cobroInstance.cambio=0.0
                cobroInstance=cobroService.save(cobroInstance)
				log.info 'Cobro registrado: '+cobroInstance
                //render view:'show',model:[ventaInstance:cobroInstance.venta,cobroInstance:cobroInstance]
				redirect action:'show',params:[id:venta.id]
				
            }
            catch(CobroException ex) {
				log.error ex.message
				flash.message=ex.message
                def cobro=ex.cobro
                def venta=Venta.get(params.ventaId)
                render view:'registrar',model:[ventaInstance:venta,cobroInstance:cobro]
                  
            }
            
        }
        
    }

    def delete(Cobro cobroInstance){
        cobroService.delete(cobroInstance)
		flash.message="Cobro $cobroInstance.id eliminado"
		redirect action:'index'
    }

    
}