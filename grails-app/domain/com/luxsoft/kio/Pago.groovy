package com.luxsoft.kio



class Pago extends Abono{

	String formaDePago
	
	String banco
	
	String referenciaBancaria

	String autorizacionBancaria


    static constraints = {
    	formaDePago inList:['EFECTIVO','DEPOSITO','TRANSFERENCIA','TARJETA DE CREDITO','TARJETA DE DEBITO']
    }
}
