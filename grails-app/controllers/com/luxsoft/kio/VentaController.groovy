package com.luxsoft.kio

class VentaController {
    static scaffold = true

    def create(){
    	def ventaInstance=new Venta()
    	[ventaInstance:ventaInstance]
    }
}
