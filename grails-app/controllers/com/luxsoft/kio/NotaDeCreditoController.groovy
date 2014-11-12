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
        respond new NotaDeCredito(params)
    }

    @Transactional
    def save(NotaDeCredito notaDeCreditoInstance) {
        if (notaDeCreditoInstance == null) {
            notFound()
            return
        }

        if (notaDeCreditoInstance.hasErrors()) {
            respond notaDeCreditoInstance.errors, view:'create'
            return
        }

        notaDeCreditoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'notaDeCredito.label', default: 'NotaDeCredito'), notaDeCreditoInstance.id])
                redirect notaDeCreditoInstance
            }
            '*' { respond notaDeCreditoInstance, [status: CREATED] }
        }
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

    @Transactional
    def delete(NotaDeCredito notaDeCreditoInstance) {

        if (notaDeCreditoInstance == null) {
            notFound()
            return
        }

        notaDeCreditoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'NotaDeCredito.label', default: 'NotaDeCredito'), notaDeCreditoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
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
