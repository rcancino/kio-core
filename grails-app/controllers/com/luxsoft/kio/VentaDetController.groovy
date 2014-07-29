package com.luxsoft.kio

class VentaDetController {
    //static scaffold = true

    def ventaService

    def edit(VentaDet det){
    	[ventaInstance:det.venta,ventaDetInstance:det]
    }

    def update(VentaDet det){
    	log.info 'Actualizando partida de venta: '+det.precioUnitario
    	log.info 'Params: '+params
    	det.validate()
    	if(det.hasErrors()){
    		render view:'edit',model:[ventaInstance:det.venta,ventaDetInstance:det]
    	}
    	ventaService.salvar(det.venta)
    	flash.message="Partida actualizada ${det.producto}"
    	redirect action:'edit' ,controller:"venta"

    }

    def delete(VentaDet det){
    	def venta=ventaService.eliminarPartida(det)
    	flash.message="Partida eliminada ${det.producto}  "
    	redirect controller:'venta',action:'edit',id:venta.id
    }
}
