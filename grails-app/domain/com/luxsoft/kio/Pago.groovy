package com.luxsoft.kio



class Pago extends Abono{

	String formaDePago
	
	String banco
	
	String referenciaBancaria

	


    static constraints = {
    	formaDePago inList:['EFECTIVO','DEPOSITO','TRANSFERENCIA','CHEQUE','TARJETA_CREDITO','TARJETA_DEBITO','RECURRENTE']
    }
}
