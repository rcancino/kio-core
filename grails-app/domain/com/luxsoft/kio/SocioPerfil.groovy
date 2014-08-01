package com.luxsoft.kio

import org.grails.databinding.BindingFormat

class SocioPerfil {

	Socio socio

	@BindingFormat('dd/MM/yyyy')
	Date fechaDeNacimiento

	String estadoCivil='NA'

	Boolean hijos

	TipoDeSocio tipoDeSocio

	MedioDeContacto medioDeContacto

	String areaDeInteres='AMBOS'

	Instructor instructor

	String twitter

	String faceBook

	String whatsApp

	String skype

	//byte[] foto

	static belongsTo = [socio: Socio]

    static constraints = {

    	fechaDeNacimiento nullable:true
    	estadoCivil inList:['SOLTERO','CASADO','EN RELACION','NA']
    	hijos nullable:true
    	tipoDeSocio()
    	medioDeContacto nullable:true
    	areaDeInteres inList:['PESAS','CLASES','AMBOS']
    	instructor nullable:true
    	twitter nullable:true ,maxSize:100
		faceBook nullable:true ,maxSize:100
		whatsApp nullable:true ,maxSize:100
		skype nullable:true ,maxSize:100
		//foto nullable:true,maxSize:(1024 * 1024)

    }

    static mapping = {
    	fechaDeNacimiento type:'date'
    	
    }
}
