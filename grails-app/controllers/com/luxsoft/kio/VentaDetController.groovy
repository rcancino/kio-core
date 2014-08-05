package com.luxsoft.kio

class VentaDetController {
    //static scaffold = true

    def ventaService
	
	def create(Venta ventaInstance){
        def socios=Socio.findAll{cliente==ventaInstance.cliente}
		[ventaInstance:ventaInstance,ventaDetInstance:new VentaDet(cantidad:1),socios:socios]
	}

    def edit(VentaDet det){
        def socios=Socio.findAll([max:10],{cliente:det.venta.cliente})
    	[ventaInstance:det.venta,ventaDetInstance:det,socios:socios]
    }
	
	def save(Long ventaId,VentaDet det){
		//def ventaInstance=Venta.get(ventaId)
		def ventaInstance=ventaService.agregarPartida(ventaId,det)
		redirect controller:'venta',action:'edit',id:ventaInstance.id
	}

    def update(VentaDet cmd){
        //println 'Id: '+cmd.id+" Vta: "+cmd.venta?.id+ " "+cmd.cantidad
        
    	cmd.validate()
    	if(cmd.hasErrors()){
    		render view:'edit',model:[ventaInstance:cmd.venta,ventaDetInstance:cmd]
            return
    	}
        def det=ventaService.salvarPartida(cmd)
        flash.message="Partida actualizada ${det}"
        redirect controller:'venta',action:'edit',id:det.venta.id
        
    }

    def delete(VentaDet det){
    	def venta=ventaService.eliminarPartida(det)
    	flash.message="Partida eliminada ${det.producto}  "
    	redirect controller:'venta',action:'edit',id:venta.id
    }
}

class VentaItemCmd {

    Long id
    Venta venta
    Socio socio
    Producto producto 
    BigDecimal precio
    BigDecimal cantidad

    String toString(){
        return " ${cantidad} - ${producto.clave} - ${precio}"
    }
}
