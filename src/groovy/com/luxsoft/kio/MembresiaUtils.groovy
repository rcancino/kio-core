package com.luxsoft.kio

class MembresiaUtils {


	public static Date calcularProximoPago(Date pago,int diaDeCorte,int meses){
		Calendar c=pago.toCalendar()
		c.add(Calendar.MONTH,meses)
		def maximo=c.getActualMaximum(Calendar.DATE)

		if(diaDeCorte>maximo){
		  diaDeCorte=maximo
		}

		c.set(Calendar.DATE,diaDeCorte)
		return c.getTime()
	}
}