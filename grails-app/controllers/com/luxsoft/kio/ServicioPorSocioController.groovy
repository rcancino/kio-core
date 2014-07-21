package com.luxsoft.kio

import grails.converters.JSON

class ServicioPorSocioController {
	
    static scaffold = true
	
	def servicioPorSocioService
	
	def agregarServicioREST(Socio socio,Producto producto){
		println "Socio $socio ($socio.id)"
		println 'Agregando servicio...'+producto
		println 'Params: '+params
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
	
}


class ServicioCmd {
	
	
	Long servicio
	BigDecimal precio
	BigDecimal descuento
	
	String toString(){
		return "$servicio $precio $descuento"
	}
}