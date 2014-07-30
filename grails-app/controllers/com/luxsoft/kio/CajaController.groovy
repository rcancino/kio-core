package com.luxsoft.kio

class CajaController {
    static scaffold = true

    def index(Long max){
    	params.max = Math.min(max ?: 20, 100)
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
		
		def query=Venta.where{status=='VENTA'}
		[ventaInstanceList:query.list(params),ventaInstanceListTotal:query.count(params)]
    }

    def cobrar(Venta ventaInstance){
    	[ventaInstance:ventaInstance]	
    }
}
