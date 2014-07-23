package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode

//@EqualsAndHashCode(includes='apellidoPaterno,apellidoMaterno,nombres')
//@ToString(includes='nombre',includeNames=true,includePackage=false)
class Venta {

	Cliente cliente

	

	@BindingFormat('dd/MM/yyyy')
	Date fecha

	TipoDeVenta tipo

	Currency moneda //=MonedaUtils.PESOS

	String status

	List partidas

	BigDecimal importeBruto=0.0

	BigDecimal descuento=0.0

	BigDecimal importeNeto=0.0

	BigDecimal impuesto=0.0

	BigDecimal impuestoTasa=0.16

	BigDecimal total=0

	Date dateCreated
	Date lastUpdated

	static hasMany = [partidas: VentaDet]

    static constraints = {
    	cliente()
    	fecha()
    	tipo()
    	moneda()
    	status inList:['COTIZACION','PEDIDO','VENTA','FACTURADA','CANCELADA']
    	importeBruto(scale:4)
    	descuento(scale:4)
    	importeNeto(scale:4)
    	impuestoTasa(scale:6)
    	impuesto(scale:4)
    	total(scale:4)
    	
    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
	}
	
	def actualizarImportes(){
		importeBruto=0
		descuento=0
		importeNeto=0
		impuesto=0
		total=0
		partidas.each{
			it.actualizarImportes()
			importeBruto+=it.importeBruto
			descuento+=it.descuento
			importeNeto+=importeNeto

		}
		impuesto=importeNeto*impuestoTasa
		total=importeNeto+impuesto
		return this
	}
	
}
