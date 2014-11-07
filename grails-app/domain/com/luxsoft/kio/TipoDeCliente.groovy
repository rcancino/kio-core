package com.luxsoft.kio
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ROLE_ADMINISTRACION')"])
class TipoDeCliente {

	String clave
	String descripcion

    static constraints = {
    	clave nullable:false,unique:true,maxSize:20
    	descripcion nullable:false
    }

    String toString(){
    	return clave
    }
}
