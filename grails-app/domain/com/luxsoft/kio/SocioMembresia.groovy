package com.luxsoft.kio


//import org.joda.time.LocalDate
import org.grails.databinding.BindingFormat


class SocioMembresia {

    Socio socio

    @BindingFormat('dd/MM/yyyy')
    Date inscripcion

    @BindingFormat('dd/MM/yyyy')
    Date ultimoPago

    @BindingFormat('dd/MM/yyyy')
    Date proximoPago

    @BindingFormat('dd/MM/yyyy')
    Date suspender

    int toleranciaEnDias=5

    Integer diasParaProximoPago=0

    Producto servicio

    String comentario

    static belongsTo = [socio: Socio]

    static constraints = {
        inscripcion nullable:true
    	ultimoPago nullable:true
    	proximoPago nullable:true
    	suspender nullable:true
    	servicio nullable:true
    	comentario nullable:true
        diasParaProximoPago nullable:true
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
