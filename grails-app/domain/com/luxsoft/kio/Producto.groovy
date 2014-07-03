package com.luxsoft.kio

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='clave')
class Producto {

	String clave
	String descripcion
    String descripcion2
	Boolean inventariable
	TipoDeProducto tipo

    String unidad

    BigDecimal precioBruto
    BigDecimal descuento
    BigDecimal precioNeto

	Date dateCreated
	Date lastUpdated


    static constraints = {
    	clave unique:true,maxSize:40
    	descripcion blank:false
    	inventariable()
        descripcion2 nullabel:true
        unidad blan:false,maxSize:15
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
