package com.luxsoft.kio


import org.joda.time.LocalDate



class SocioMembresia {

    Socio socio
    
    //LocalDate alta=LocalDate.now()
    Date alta=new Date()

    LocalDate ultimoPago

    LocalDate proximoPago

    LocalDate suspender

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
        alta type:'date'
    }

    String toString(){
        "$socio $proximoPago"
    }
}
