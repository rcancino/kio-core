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

    Integer atraso

    Producto servicio

    String comentario

    Integer diaDeCorte=1

    static belongsTo = [socio: Socio]

    static constraints = {
        inscripcion nullable:true
    	ultimoPago nullable:true
    	proximoPago nullable:true
    	//suspender nullable:true
    	servicio nullable:true
    	comentario nullable:true
        //diasParaProximoPago nullable:true
        diaDeCorte range:1..28
    }
    
    static mapping = {
    	//servicios cascade: "all-delete-orphan"
        ultimoPago type:'date'
        proximoPago type:'date'
        suspender type:'date'
        
    }

    static transients = ['diasParaProximoPago','suspender','atraso']

    String toString(){
        "$socio $proximoPago"
    }

    Integer getDiasParaProximoPago(){
        if(proximoPago){
            def now=new Date()
            return proximoPago-now
        }
        else
            return 0
    }

    Date getSuspender(){
        if(proximoPago){
            return proximoPago+toleranciaEnDias
        }
        return proximoPago
    }

    Integer getAtraso(){
        if(proximoPago){
            def now=new Date()
            atraso=now-proximoPago
            return atraso>0?atraso:0
        }
        return 0
    }
    
    // def beforeUpdate() {

    //     if(proximoPago ){
    //         println 'Actualizando membresia...'
    //         def now=new Date()
    //         socio.activo=getSuspender()>now
            
    //     }
    // }

}
