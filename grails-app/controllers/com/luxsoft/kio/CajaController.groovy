package com.luxsoft.kio

class CajaController {
    static scaffold = true

    def index(Long max){
    	params.max = Math.min(max ?: 20, 100)
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
		def tipo=params.tipo?:'%'
		def query=Venta.where{tipo.clave=~tipo}
		[ventaInstanceList:query.list(params),ventaInstanceListTotal:query.count(params)]
    }

    def cobrar(Venta ventaInstance){
    	[ventaInstance:ventaInstance]	
    }
}
