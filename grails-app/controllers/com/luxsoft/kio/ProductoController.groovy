package com.luxsoft.kio

import grails.converters.JSON

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
	
	def getProductosAsJSON() {
		
		def term='%'+params.term.trim()+'%'
		def query=Producto.where{
			clave=~term || descripcion=~term
		}
		def list=query.list(max:30, sort:"descripcion")
		//println 'Buscando productos JSON: '+list.size()+' params: '+params.term
		list=list.collect{ c->
			def descripcion="$c.descripcion ($c.clave)"
			[id:c.id,
				label:descripcion,
				value:descripcion,
				clave:c.clave,
				descripcion:c.descripcion,
				precioBruto:c.precioBruto,
				descuento:c.descuento,
				precioNeto:c.precioNeto
			]
		}
		def res=list as JSON
		render res
			}
}
