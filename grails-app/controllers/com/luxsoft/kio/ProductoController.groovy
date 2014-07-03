package com.luxsoft.kio

class ProductoController {
    static scaffold = true

    def importadorService
	
	def index(Long max){
		params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'clave'
		params.order='asc'
		
		[productoInstanceList:Producto.list(params),productoInstanceCount:Producto.count()]
	}
	
	def importar(){
		println 'Importando productos'
		importadorService.importarProductos()
		redirect action:'index'
	}
	
	def search(){
		def s=params.term?:'%'
		s+='%'
		def query=Producto.where{clave=~s || descripcion=~s}
		render view:'index',model:[productoInstanceList:query.list(max:20,sort:'clave'),productoInstanceCount:query.count()]
		
	}
}
