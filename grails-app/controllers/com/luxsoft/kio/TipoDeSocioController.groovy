package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION')"])
class TipoDeSocioController {
    
    static scaffold = true

    // def index(){
    	
    // 	flash.message="Nuevo socio registrado"
    // }
}
