package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class ServicioPorSocioService {

    def agregarServicio(Socio socio,ServicioPorSocio servicio) {
    	servicio.proximoCargo=new Date()
    	socio.addToServicios(servicio)
		socio.save failOnError:true
    }

    def delete(ServicioPorSocio servicio){
    	def socio=servicio.socio
    	socio.removeFromServicios(servicio)
    	socio.save failOnError:true
    	return socio
    }
}
