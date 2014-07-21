package com.luxsoft.kio

class ServicioPorSocioController {
	
    static scaffold = true
	
	def agregarServicioREST(ServicioCmd cmd){
		println 'Agregando servicio...'+params
		println 'Agregando: '+cmd
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