package com.luxsoft.kio



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CajaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Caja.list(params), model:[cajaInstanceCount: Caja.count()]
    }

    def show(Caja cajaInstance) {
        respond cajaInstance
    }

    def create() {
        respond new Caja(params)
    }

    @Transactional
    def save(Caja cajaInstance) {
        if (cajaInstance == null) {
            notFound()
            return
        }

        if (cajaInstance.hasErrors()) {
            respond cajaInstance.errors, view:'create'
            return
        }

        cajaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'caja.label', default: 'Caja'), cajaInstance.id])
                redirect cajaInstance
            }
            '*' { respond cajaInstance, [status: CREATED] }
        }
    }

    def edit(Caja cajaInstance) {
        respond cajaInstance
    }

    @Transactional
    def update(Caja cajaInstance) {
        if (cajaInstance == null) {
            notFound()
            return
        }

        if (cajaInstance.hasErrors()) {
            respond cajaInstance.errors, view:'edit'
            return
        }

        cajaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Caja.label', default: 'Caja'), cajaInstance.id])
                redirect cajaInstance
            }
            '*'{ respond cajaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Caja cajaInstance) {

        if (cajaInstance == null) {
            notFound()
            return
        }

        cajaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Caja.label', default: 'Caja'), cajaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'caja.label', default: 'Caja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
