package com.luxsoft.kio

class ServicioPorSocioController {
	
    static scaffold = true
	
	def agregarServicioREST(ServicioCmd cmd){
		println 'Agregando servicio...'+params
		println 'Agregando: '+cmd
	}
	
}


class ServicioCmd {
	Long socio
	
	String toString(){
		return "$socio"
	}
}