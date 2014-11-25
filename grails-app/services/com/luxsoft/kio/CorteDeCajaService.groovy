package com.luxsoft.kio

import grails.transaction.Transactional

@Transactional
class CorteDeCajaService {

    def generarCorte(String cajero) {
    	def time=new Date()
    	def pagos=Pago.findAll("from Pago p where date(p.fecha)=? and p.usuario=?",[time,cajero])
    	

    	log.info "$pagos.size pagos registrados por  $cajero "
    	
    	
    	def total=pagos.sum 0.0,{it.importe}
    	def corte=new CorteDeCaja(fechaHora:new Date()
    	    ,cajero:cajero
    	    ,total:total)

    	def pagosPorTipo=pagos.groupBy{it.formaDePago}
    	
    	pagosPorTipo.each{k,v->
    	    def cobrado=v.sum 0.0,{it.importe}
    	    def det=new CorteDeCajaDet(
    	        formaDePago:k
    	        ,cobrado:cobrado
    	        ,acumulado:0.0)
    	    def acumulado=CorteDeCajaDet
    	    	.executeQuery(
    	    		"select sum(c.importeCorte) from CorteDeCajaDet c where date(c.corte.fechaHora)=? and c.formaDePago=? and c.corte.cajero=?"
    	    		,[time,k,cajero])
    	    det.acumulado=acumulado[0]?:0.0
    	    det.importeCorte=det.cobrado-det.acumulado
    	    if(det.importeCorte){
    	    	corte.addToPartidas(det)
    	    }
    	    
    	}
    	return corte
    }

    def salvar(CorteDeCaja corte){
    	corte.save failOnError:true
    	return corte
    }
}
