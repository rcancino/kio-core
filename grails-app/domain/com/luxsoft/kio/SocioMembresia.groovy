package com.luxsoft.kio


//import org.joda.time.LocalDate



class SocioMembresia {

    Socio socio

    Date ultimoPago

    Date proximoPago

    Date suspender

    int toleranciaEnDias=5

    Producto servicio

    String comentario

    static belongsTo = [socio: Socio]

    static constraints = {
    	ultimoPago nullable:true
    	proximoPago nullable:true
    	suspender nullable:true
    	servicio nullable:true
    	comentario nullable:true
    }
    
    static mapping = {
    	//servicios cascade: "all-delete-orphan"
        ultimoPago type:'date'
        proximoPago type:'date'
        suspender type:'date'
        
    }

    String toString(){
        "$socio $proximoPago"
    }
}
