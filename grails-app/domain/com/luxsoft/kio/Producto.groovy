package com.luxsoft.kio

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='clave')
class Producto {

	String clave
	String descripcion

	Boolean inventariable

	TipoDeProducto tipo

	Date dateCreated
	Date lastUpdated


    static constraints = {
    	clave unique:true
    	descripcion blank:false
    	inventariable()
    }

    String toString(){
    	"$clave ($descripcion)"
    }

    def beforeInsert() {
    	clave=clave.toUpperCase()
    }
    def beforeUpdate() {
    	clave=clave.toUpperCase()
    }
}
