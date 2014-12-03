package com.luxsoft.kio

//import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import org.apache.commons.lang.math.NumberUtils

//@ToString(includes='nombre',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='apellidoPaterno,apellidoMaterno,nombres')
class Socio {
	
	//Datos personales
	String apellidoPaterno

	String apellidoMaterno

	String nombres
	
	String nombre
	
	String sexo

	String telefonoCasa

	String telefonoTrabajo

	String celular

	String email

	String email2

	//Datos de facturacion
	Cliente cliente
	Direccion direccion
	String cfdiEmail
	
	String origen

    String numeroDeSocio

    String tarjeta

    Boolean activo=true;

	Date dateCreated
	Date lastUpdated

	
    static constraints = {
    	apellidoPaterno(unique:['apellidoMaterno','nombres'])
    	sexo inList:['MASCULINO','FEMENINO']
    	telefonoCasa nullable:true,maxSize:30
    	telefonoTrabajo nullable:true,maxSize:30
    	celular nullable:true,maxSize:30
    	email nullable:true,maxSize:50
    	email2 nullable:true,maxSize:50
    	cfdiEmail nullable:true,maxSize:50
		direccion nullable:true
		origen nullable:true
        perfil unique:true
        membresia unique:true
        foto nullable:true
        numeroDeSocio nullable:true
        tarjeta nullable:true,maxSize:50
    }

    

    static hasOne = [perfil: SocioPerfil,foto:SocioFoto,membresia:SocioMembresia]

    static embedded = ['direccion']

    static mapping = {
    	 foto lazy: true
    }

    String toString(){
    	return "$nombres $apellidoPaterno $apellidoMaterno"
    }

    def beforeUpdate() {
    	capitalizarNombre()
        logLectora()
    }

    def beforeInsert() {
    	capitalizarNombre()
        logLectora()

    }

    private capitalizarNombre(){
        if (isDirty('apellidoPaterno') || isDirty('apellidoMaterno') || isDirty('nombres')) {
            apellidoPaterno=apellidoPaterno.toUpperCase()
            apellidoMaterno=apellidoMaterno.toUpperCase()
            nombres=nombres.toUpperCase()
            nombre="$nombres $apellidoPaterno $apellidoMaterno"
        }
    	
    }

    def logLectora(){
        if (isDirty('activo') || isDirty('tarjeta') ) {
            actualizarLectora()
        }
    }

    def actualizarLectora(){
        AccessLog.withNewSession{
            AccessLog log=new AccessLog()
            log.nombre=this.nombre
            log.numero=NumberUtils.toLong(this.numeroDeSocio)
            log.tarjeta=this.tarjeta
            log.activo=this.activo
            log.save failOnError:true
            return log
        }
        
    }


    

}
