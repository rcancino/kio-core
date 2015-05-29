package com.luxsoft.kio



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.validation.Validateable
import org.springframework.security.access.annotation.Secured
import grails.converters.JSON

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
@Transactional(readOnly = true)
class NotaDeCreditoController {

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NotaDeCredito.list(params), model:[notaDeCreditoInstanceCount: NotaDeCredito.count()]
    }

    def show(NotaDeCredito notaDeCreditoInstance) {
        respond notaDeCreditoInstance
    }

    def create() {
        [notaDeCreditoInstance:new AltaDeNotaCommand()]
    }

    @Transactional
    def save(AltaDeNotaCommand command) {
        
        if (command == null) {
            notFound()
            return
        }
        if (command.hasErrors()) {
            render view:'create',model:[notaDeCreditoInstance:command]
            return
        }
        def notaDeCreditoInstance =command.generarNota()
        def user=getAuthenticatedUser().username
        notaDeCreditoInstance.usuario=user
        notaDeCreditoInstance.save failOnError:true
        flash.message="Nota generada: $notaDeCreditoInstance.id"
        redirect action:'edit',params:[id:notaDeCreditoInstance.id]
        // notaDeCreditoInstance.save flush:true

        // request.withFormat {
        //     form multipartForm {
        //         flash.message = message(code: 'default.created.message', args: [message(code: 'notaDeCredito.label', default: 'NotaDeCredito'), notaDeCreditoInstance.id])
        //         redirect notaDeCreditoInstance
        //     }
        //     '*' { respond notaDeCreditoInstance, [status: CREATED] }
        // }
    }

    def edit(NotaDeCredito notaDeCreditoInstance) {
        // if(notaDeCreditoInstance.cfdi){
        //     redirect action:'show',params:[id:notaDeCreditoInstance.id]
        //     return
        // }
        respond notaDeCreditoInstance
    }

    @Transactional
    def update(NotaDeCredito notaDeCreditoInstance) {
        if (notaDeCreditoInstance == null) {
            notFound()
            return
        }

        if (notaDeCreditoInstance.hasErrors()) {
            respond notaDeCreditoInstance.errors, view:'edit'
            return
        }

        notaDeCreditoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'NotaDeCredito.label', default: 'NotaDeCredito'), notaDeCreditoInstance.id])
                redirect notaDeCreditoInstance
            }
            '*'{ respond notaDeCreditoInstance, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'notaDeCredito.label', default: 'NotaDeCredito'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def cfdiService

    @Transactional
    def mandarTimbrar(NotaDeCredito notaDeCreditoInstance){
        if(notaDeCreditoInstance.cfdi){
            flash.message="Nota ya timbrada"
            redirect acion:'show',params:[id:notaDeCreditoInstance.id]
            return
        }
        def cfdi=cfdiService.generar(notaDeCreditoInstance)
        redirect controller:'cfdi',action:'show',params:[id:cfdi.id]
        
    }


    def agregarAplicacion(NotaDeCredito notaDeCreditoInstance){
        [aplicacionDeNotaInstance:new AplicacionDeNotaCommand(nota:notaDeCreditoInstance,fecha:new Date())]
    }

    def notaDeCreditoService

    @Transactional
    def salvarAplicacion(AplicacionDeNotaCommand command){
        assert command,'AplicacionDeNotaCommand no puede ser nulo'

        log.info 'Aplicando nota: '+command?.nota?.id
        log.info 'A Venta: '+command?.venta?.id
        log.info 'Importe:'+command?.importe
        command.validate()
        if(command.hasErrors()){
            flash.message="Errores de validacion"
            render view:'agregarAplicacion',model:[aplicacionDeNotaInstance:command]
            return
        }
        //agregarAplicacion(Pago pago,Venta venta,Date fecha,BigDecimal importe,String comentario)
        def nota=notaDeCreditoService.agregarAplicacion(
            command.nota
            ,command.venta
            ,command.fecha
            ,command.importe
            ,command.comentario)
        render view:'edit',model:[notaDeCreditoInstance:nota]
        
    }

    @Transactional
    def eliminarAplicacion(AplicacionDeNota aplicacion){
        assert aplicacion,'Error aplicacion no puede ser nula'
        def nota=notaDeCreditoService.eliminarAplicacion(aplicacion)
        flash.message="Aplicacion $aplicacion.id eliminada"
        render view:'edit',model:[notaDeCreditoInstance:nota]
    }

    def buscarVentasPendientesJSON() {

        def pago=NotaDeCredito.get(params.id)
        def term='%'+params.term.trim()+'%'

        def query=Venta.where{
            cliente==pago.cliente && saldo>0 
         }
        def list=query.list(max:30, sort:"id")
        
        list=list.collect{ v->
            def descripcion="$v.id - ${v.fecha.format('dd/MM/yyyy')} Total:${v.total} Saldo:${v.saldo}"
            [id:v.id,
            ,label:descripcion
            ,total:v.total
            ,saldo:v.saldo
            ,importe:pago.disponible>v.saldo?v.saldo:pago.disponible
            ]
        }
        def res=list as JSON
        //log.info 'Buscando ventas disponibles para '+pago.cliente+ ' Found: '+res
        render res
    }

    //@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
    @Transactional
    def delete(NotaDeCredito notaDeCreditoInstance){
        notaDeCreditoService.delete(notaDeCreditoInstance)
        flash.message="Nota $notaDeCreditoInstance.id eliminado"
        redirect action:'index'
    }
}

@Validateable
class AltaDeNotaCommand{
    Cliente cliente 
    Date fecha=new Date()
    String tipo
    String comentario

    static constraints = {
        importFrom NotaDeCredito

    }

    String toString(){
        return "$cliente $tipo"
    }

    NotaDeCredito generarNota(){
        def nota=new NotaDeCredito(
            cliente:this.cliente,
            fecha:this.fecha,
            tipo:this.tipo,
            comentario:this.comentario

        )

    }

}

import org.grails.databinding.BindingFormat

@Validateable
class AplicacionDeNotaCommand{
    
    Venta venta
    NotaDeCredito nota
    @BindingFormat('dd/MM/yyyy')
    Date fecha
    BigDecimal importe
    String comentario

    static constraints={
        importe min:1.0,validator:{val,obj->
            if(val>obj.nota.disponible){
                return 'excedeDisponible'
            }
            return true
        }
        comentario nullable:true
    }

    Aplicacion toAplicacion(){
        AplicacionDeNota a=new AplicacionDeNota(venta:venta,fecha:fecha,comentario:comentario,importe:importe)
        return a
    }
}
