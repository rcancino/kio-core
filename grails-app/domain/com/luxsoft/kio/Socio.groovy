package com.luxsoft.kio

//import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import org.grails.databinding.BindingFormat

//@ToString(includes='nombre',includeNames=true,includePackage=false)
//@EqualsAndHashCode(includes='apellidoPaterno,apellidoMaterno,nombres')
class Socio {
	
	Cliente cliente
	
	//Datos personales
	String apellidoPaterno
	String apellidoMaterno
	String nombres
	
	String sexo='M'
	
	@BindingFormat('dd/MM/yyyy')
	Date fechaDeNacimiento
	String estadoCivil='NA'
	Boolean hijos
	String telefonoCasa
	String telefonoTrabajo
	String celular
	String email

	//Clasificacion
	MedioDeContacto medioDeContacto
	TipoDeSocio tipoDeSocio
	String areaDeInteres='AMBOS'
	Instructor instructor

	

	//Redes sociales
	String twitter
	String faceBook
	String whatsApp
	String skype
	byte[] foto

	Boolean activo='true'
	String status='ACTIVO'
	Boolean corporativo=false
	String origen

	Date dateCreated
	Date lastUpdated

	
	static hasMany = [membresias: Membresia]

	
    static constraints = {
    	
    	sexo inList:['M','F']
    	estadoCivil inList:['SOLTERO','CASADO','EN RELACION','NA']
    	areaDeInteres inList:['PESAS','CLASES','AMBOS']
    	status inList:['ACTIVO','SUSPENDIDO','CANCELADO']
    	fechaDeNacimiento nullable:true
    	medioDeContacto nullable:true
    	telefonoTrabajo nullable:true
    	telefonoCasa nullable:true
    	celular nullable:true
    	email nullable:true,email:true

    	twitter nullable:true ,maxSize:100
		faceBook nullable:true ,maxSize:100
		whatsApp nullable:true ,maxSize:100
		skype nullable:true ,maxSize:100

		instructor nullable:true
		origen nullable:true
		activo()

		foto nullable:true
		hijos nullable:true
		

    }

    static mapping = {
    	fechaDeNacimiento type:'date'
    	membresias cascade: "all-delete-orphan"
    }

    String toString(){
    	return "$apellidoPaterno $apellidoMaterno $nombres "
    }

    def beforeUpdate() {
    	capitalizarNombre()
    }

    def beforeInsert() {
    	capitalizarNombre()
    }

    private capitalizarNombre(){
    	apellidoPaterno=apellidoPaterno.toUpperCase()
    	apellidoMaterno=apellidoMaterno.toUpperCase()
    	nombres=nombres.toUpperCase()
    }

}
