package com.luxsoft.kio

class CobroController {
    static scaffold = true

    def create(){
    	[cobroInstance:new Cobro(fecha:new Date())]
    }

    def cobrar(){
    	
    	def venta=Venta.get(params.ventaId)
    	def cobroInstance=new Cobro(fecha:new Date(),cliente:venta.cliente,importe:venta.total)
    	[cobroInstance:cobroInstance]
    }
}
