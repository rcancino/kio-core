package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class ProductoService {

    def save(Producto producto) {
		producto.save failOnError:true
		return producto
    }
}
