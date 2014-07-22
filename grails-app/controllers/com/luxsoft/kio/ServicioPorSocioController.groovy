package com.luxsoft.kio

import grails.converters.JSON

class ServicioPorSocioController {
	
    static scaffold = true
	
	def servicioPorSocioService
	
	def agregarServicioREST(Socio socio,Producto producto){
		log.debug "Agregando  $producto a $socio"
		if(socio!=null){
			def precioBruto=producto.precioBruto
			def precioNeto=producto.precioNeto
			def serv=new ServicioPorSocio(servicio:producto,percioBruto:precioBruto,precioNeto:precioNeto)
			serv.inscripcion=new Date()
			serv=servicioPorSocioService.agregarServicio(socio,serv)
			
			def res=serv as JSON
			render res
		}
	}
	
	def delete(ServicioPorSocio servicio){
		log.debug "Eliminando servicio $servicio"
		assert servicio,'No existe el servicio'
		def socio=servicioPorSocioService.delete(servicio)
		flash.message="Servicio eliminado "
		redirect controller:'socio',action:'show',params:[id:socio.id,tab:'servicio']
	}
	
}


class ServicioCmd {
	
	BigDecimal precioBruto
	BigDecimal descuento
	
}