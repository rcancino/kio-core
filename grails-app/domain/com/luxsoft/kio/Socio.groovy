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
	String sexo
	
	@BindingFormat('dd/MM/yyyy')
	Date fechaDeNacimiento

	String estadoCivil
	Boolean hijos
	String telefonoCasa
	String telefonoTrabajo
	String celular
	String email

	//Clasificacion
	MedioDeContacto medioDeContacto
	TipoDeSocio tipoDeSocio
	String areaDeInteres
	Instructor instructor

	Membresia membresia

	//Redes sociales
	String twitter
	String faceBook
	String whatsApp
	String skype
	byte[] foto

	

	Date dateCreated
	Date lastUpdated

	static hasOne = [membresia: Membresia]

	
    static constraints = {
    	
    	sexo inList:['M','F']
    	estadoCivil inList:['SOLTERO','CASADO','EN RELACION']
    	areaDeInteres inList:['PESAS','CLASES','AMBOS']

    	telefonoTrabajo nullable:true
    	telefonoCasa nullable:true
    	celular nullable:true
    	email nullable:true,email:true

    	twitter nullable:true ,maxSize:100
		faceBook nullable:true ,maxSize:100
		whatsApp nullable:true ,maxSize:100
		skype nullable:true ,maxSize:100

		instructor nullable:true

    }

    static mapping = {
    	fechaDeNacimiento type:'date'
    }

    String toString(){
    	return "$apellidoPaterno $apellidoMaterno $nombres ($id)"
    }

}
