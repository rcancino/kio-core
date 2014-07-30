package com.luxsoft.kio

import org.grails.databinding.BindingFormat
import com.luxsoft.cfdi.Cfdi
import groovy.transform.EqualsAndHashCode

//@EqualsAndHashCode(includes='apellidoPaterno,apellidoMaterno,nombres')
//@ToString(includes='nombre',includeNames=true,includePackage=false)
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

	BigDecimal total=0
	
	Cfdi cfdi

	Date dateCreated
	Date lastUpdated

	static hasMany = [partidas: VentaDet]

    static constraints = {
    	cliente()
    	fecha()
    	tipo()
    	moneda()
    	status inList:['COTIZACION','PEDIDO','VENTA','FACTURADA','CANCELADA']
    	importe(scale:4)
    	descuento(scale:4)
    	subTotal(scale:4)
    	impuesto(scale:4)
    	total(scale:4)
		formaDePago(nullable:false,maxSize:30)
		cfdi nullable:true
    	
    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
	}
	
	
	
}
