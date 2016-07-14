package com.luxsoft.kio

public enum MetodoDePago {

	EFECTIVO('01'),
	CHEQUE('02'),
	TRANSFERENCIA('03'),
	TARJETA_DE_CREDITO('04'),
	TARJETA_DE_DEBITO('28'),
	TARJETA_DE_SERVICIO('29'),
	//MONEDERO_ELECTRONICO('05'),
	//DINERO_ELECTRONICO('06'),
	//VALES_DE_DESPENSA('08'),
	OTROS('99')


	final String clave 

	private MetodoDePago(String clave){
		this.clave = clave
	}

	public String value() {
        return name();
    }

    public String getClave(){
    	return clave;
    }

    public static MetodoDePago fromValue(String val){
        try {
        	return valueOf(val)
        }
        catch(Exception e) {
        	return OTROS;
        }
        
    }

    public  FormaDePago toFormaDePago(){
    	switch(this) {
    		case EFECTIVO:
    			return FormaDePago.EFECTIVO
    		case CHEQUE:
    			return FormaDePago.CHEQUE
    		case TARJETA_DE_CREDITO:
    			return FormaDePago.TARJETA_DE_CREDITO
    		case TARJETA_DE_DEBITO:
    			return FormaDePago.TARJETA_DE_DEBITO
    		case TARJETA_DE_SERVICIO:
    			return FormaDePago.AMERICAN_EXPRESS
    		case TRANSFERENCIA:
    			return FormaDePago.TRANSFERENCIA
    		default:
    			return FormaDePago.EFECTIVO
    		break
    	}
    }
}

