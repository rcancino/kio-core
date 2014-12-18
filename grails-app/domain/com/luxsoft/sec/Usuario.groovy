package com.luxsoft.sec

import com.luxsoft.kio.AccessLog

class Usuario {

	transient springSecurityService

	String apellidoPaterno
	String apellidoMaterno
	String nombres
	String nombre
	String email
	
	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Integer numeroDeEmpleado
	String tarjeta

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		apellidoPaterno()
		apellidoMaterno()
		nombre()
		enabled()
		accountExpired()
		accountLocked()
		passwordExpired()
		email nullable:true,email:true
		tarjeta nullable:true
		numeroDeEmpleado nullable:true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UsuarioRole.findAllByUsuario(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
		capitalizarNombre()
		logLectora()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
			
		}
		if (isDirty('apellidoPaterno') || isDirty('apellidoMaterno') || isDirty('nombres')) {
			capitalizarNombre()
			
		}
		logLectora()
		
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
	
	private capitalizarNombre(){
		apellidoPaterno=apellidoPaterno.toUpperCase()
		apellidoMaterno=apellidoMaterno.toUpperCase()
		nombres=nombres.toUpperCase()
		nombre="$nombres $apellidoPaterno $apellidoMaterno"
	}

	def logLectora(){
        if (isDirty('enabled') || isDirty('tarjeta') ) {
            actualizarLectora()
        }
    }

	def actualizarLectora(){
        //socioService.logAccess(this)
        if(numeroDeEmpleado){
        	AccessLog.withNewSession{
        	    AccessLog log=new AccessLog()
        	    log.nombre=this.nombre
        	    log.numero=numeroDeEmpleado
        	    log.tarjeta=this.tarjeta
        	    log.activo=this.enabled
        	    log.save failOnError:true
        	    return log
        	}
        }
        
        
    }
}
