package com.luxsoft.kio

import grails.converters.JSON
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class ProductoController {
	
    static scaffold = true

    def importadorService
	
	def productoService
	
	def index(Long max){
		params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'clave'
		params.order='asc'
		
		[productoInstanceList:Producto.list(params),productoInstanceCount:Producto.count()]
	}
	
	@Secured(["hasAnyRole('ROLE_ADMIN')"])
	def importar(){
		println 'Importando productos'
		importadorService.importarProductos()
		redirect action:'index'
	}
	
	def edit(Producto productoInstance){
		render view:'edit2',model:[productoInstance:productoInstance]
	}
	
	
	def update(Producto productoInstance){
		
		productoInstance.validate()
		if(productoInstance.hasErrors()){
			flash.message="Errores de validacion"
			render view:'edit2',model:[productoInstance:productoInstance]
			return
		}
		//productoInstance.save failOnError:true
		productoInstance=productoService.save(productoInstance)
		flash.message="Producto actualizado "+productoInstance.id
		//println 'Salvando: '+productoInstance+' Periodicidad: '+productoInstance.periodicidad
		redirect action:'show',params:[id:productoInstance.id]
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
			def descripcion="$c.descripcion "
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
