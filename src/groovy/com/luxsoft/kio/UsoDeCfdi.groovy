package com.luxsoft.kio

public enum UsoDeCfdi {

	ADQUISICION_DE_MERCANCIAS('G01'),
	GASTOS_EN_GENERAL('G03'),
	POR_DEFINIR('P01'),


	final String clave 

	private UsoDeCfdi(String clave){
		this.clave = clave
	}

	public String value() {
        return name();
    }

    public String getClave(){
    	return clave;
    }

    public static UsoDeCfdi fromValue(String val){
        try {
        	return valueOf(val)
        }
        catch(Exception e) {
        	return POR_DEFINIR;
        }
        
    }
    
}

