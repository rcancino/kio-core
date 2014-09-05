package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import com.luxsoft.cfdi.Cfdi
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import com.luxsoft.kio.MonedaUtils

//@EqualsAndHashCode(includes='apellidoPaterno,apellidoMaterno,nombres')
//@ToString(includes='nombre',includeNames=true,includePackage=false)
//@Sortable(includes="id")
class Venta {

	

	Cliente cliente
	
	@BindingFormat('dd/MM/yyyy')
	Date fecha

	TipoDeVenta tipo

	Currency moneda //=MonedaUtils.PESOS
	
	String formaDePago='NO DEFINIDO'

	String status

	List partidas=[]

	BigDecimal importe=0.0

	BigDecimal descuento=0.0

	BigDecimal subTotal=0.0

	BigDecimal impuesto=0.0

	BigDecimal impuestoTasa=16

	BigDecimal total=0

	BigDecimal saldo

	BigDecimal abonos=0
	
	Cfdi cfdi

	Date dateCreated
	Date lastUpdated

	static hasMany = [partidas: VentaDet]

    static constraints = {
    	cliente()
    	fecha()
    	moneda()
    	status inList:['COTIZACION','PEDIDO','VENTA','FACTURADA','CANCELADA']
    	importe(scale:2)
    	descuento(scale:2)
    	subTotal(scale:2)
    	impuesto(scale:2)
    	impuestoTasa(scale:2)
    	total(scale:2)
		cfdi nullable:true
		tipo nullable:true
    	
    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
	}

	static transients = ['saldo']

	
	def actualizarImportes(){
		importe=partidas.sum 0.0,{it.importeBruto}
		descuento=partidas.sum 0.0,{it.descuento}
		total=partidas.sum 0.0,{it.importeNeto}
		subTotal=MonedaUtils.calcularImporteDelTotal(total)
		impuesto=total-subTotal
		return this
	}

	def getSaldo(){
		return total-abonos
	}
	
	
}
