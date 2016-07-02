package com.luxsoft.cfdi



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ROLE_ADMIN')"])
@Transactional(readOnly = true)
class EmpresaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        //params.max = Math.min(max ?: 10, 100)
        //respond Empresa.list(params), model:[empresaInstanceCount: Empresa.count()]
        redirect action:'show'
    }

    def show(Empresa empresaInstance) {
        if(empresaInstance==null)
            empresaInstance=Empresa.first()
        respond empresaInstance
    }

    def create() {
        respond new Empresa(params)
    }

    @Transactional
    def save(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }

        if (empresaInstance.hasErrors()) {
            respond empresaInstance.errors, view:'create'
            return
        }

        empresaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empresa.label', default: 'Empresa'), empresaInstance.id])
                redirect empresaInstance
            }
            '*' { respond empresaInstance, [status: CREATED] }
        }
    }

    def edit(Empresa empresaInstance) {
        respond empresaInstance
    }

    @Transactional
    def update() {

        def empresa=Empresa.get(params.id)
        if(empresa){
            bindData(empresa, params,[exclude: ['id', 'version']])
        }

        if (empresa.hasErrors()) {
            redirect action:'show',model:[empreaInstance:empresa]
            return
        }
        empresa.save flush:true
        redirect action:'show',params:[id:empresa.id]

        
    }

    @Transactional
    def delete(Empresa empresaInstance) {

        if (empresaInstance == null) {
            notFound()
            return
        }

        empresaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Empresa.label', default: 'Empresa'), empresaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empresa.label', default: 'Empresa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    @Transactional
    def registrarCertificado(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }
        println 'Actualizando certificado digital '+params
        def file=request.getFile('file')
        
        empresaInstance.numeroDeCertificado=file.getOriginalFilename()-'.cer'
        empresaInstance.certificadoDigital=file.getBytes()
        empresaInstance.save flush:true
        redirect action: 'show',id:empresaInstance.id
        
    }

    @Transactional
    def registrarLlavePrivada(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }
        def file=request.getFile('file')
        empresaInstance.llavePrivada=file.getBytes()
        empresaInstance.save flush:true
        redirect action: 'show',id:empresaInstance.id
        
    }

    @Transactional
    def registrarCertificadoPfx(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }
        def file=request.getFile('file')
        empresaInstance.certificadoDigitalPfx=file.getBytes()
        empresaInstance.save flush:true
        redirect action: 'show',id:empresaInstance.id
        
    }
}
