package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class ServicioPorSocioService {

    def agregarServicio(Socio socio,ServicioPorSocio servicio) {
    	
    	socio.addToServicios(servicio)
		socio.save failOnError:true
    }
}
