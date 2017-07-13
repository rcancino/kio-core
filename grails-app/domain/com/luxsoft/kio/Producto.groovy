package com.luxsoft.kio

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='clave')
class Producto {

	String clave
	String descripcion
    String descripcion2
	TipoDeProducto tipo
    String unidad
	Boolean inventariable

    BigDecimal precioBruto
    BigDecimal descuento
    BigDecimal precioNeto
	
	String periodicidad
	Integer duracion

    Boolean suspendido=false

    BigDecimal tasaIva = 16
	

	Date dateCreated
	Date lastUpdated


    static constraints = {
    	clave unique:true,maxSize:40
    	descripcion blank:false
		descripcion2 nullabel:true
		tipo()
		unidad blan:false,maxSize:15
    	inventariable()
		precioBruto()
		descuento()
		precioNeto()
        periodicidad nullable:true, inList:['MENSUAL','TRIMESTRAL','SEMESTRAL','ANUAL','ESPECIAL']
		duracion nullable:true
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
