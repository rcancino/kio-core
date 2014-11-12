package com.luxsoft.kio

import com.luxsoft.cfdi.Cfdi

class NotaDeCredito extends Abono {

	String tipoDeNota

	

	Cfdi cfdi

    static constraints = {
    	tipoDeNota inList:['DESCUENTO','BONIFICACION','DEVOLUCION']
    	cfdi nulllable:true
    }
}
