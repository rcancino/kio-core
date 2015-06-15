package com.luxsoft.kio

import com.luxsoft.kio.MonedaUtils
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('MOSTRADOR')"])
class VentaDetController {
    //static scaffold = true

    def ventaService
	
	def create(Venta ventaInstance){
        def socios=Socio.findAll([max:40],{cliente==ventaInstance.cliente})
		[ventaInstance:ventaInstance,ventaDetInstance:new VentaDet(cantidad:1),socios:socios]
	}

    def edit(VentaDet det){
        def socios=Socio.findAll([max:10],{cliente==det.venta.cliente})
    	[ventaInstance:det.venta,ventaDetInstance:det,socios:socios]
    }
	
	def save(Long ventaId,VentaDet det){
		//def ventaInstance=Venta.get(ventaId)
        // if(det.descuentoTasa>0){
        //     det.descuentoTasa=MonedaUtils.calcularImporteDelTotal(cmd.descuentoTasa)
        // }
        log.info 'salvando partida: '+det+ " Descuento Tasa: "+det.descuentoTasa+ ' Descuento: '+det.descuento
		def ventaInstance=ventaService.agregarPartida(ventaId,det)
		redirect controller:'venta',action:'edit',id:ventaInstance.id
	}

    def update(VentaDet cmd){
        //println 'Id: '+cmd.id+" Vta: "+cmd.venta?.id+ " "+cmd.cantidad
        // if(cmd.descuento>0){
        //     cmd.descuento=MonedaUtils.calcularImporteDelTotal(cmd.descuento)
        // }
    	cmd.validate()
    	if(cmd.hasErrors()){
            
            flash.message="Errores de validacion"
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
