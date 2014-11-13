package com.luxsoft.kio



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.validation.Validateable
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO')"])
@Transactional(readOnly = true)
class NotaDeCreditoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
