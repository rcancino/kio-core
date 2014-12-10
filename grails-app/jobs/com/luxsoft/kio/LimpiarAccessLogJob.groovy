package com.luxsoft.kio


/**
*
*  Limpia la bitacora de acceso  todos los registros a partir del dia anterior.
*  Este proceso permite mantener la tabla de AccessLog relativamente limpia.
*
*/
class LimpiarAccessLogJob {

    static triggers = {
      //simple name:'simpleTrigger', startDelay:60000, repeatInterval: 60000, repeatCount: 10
      cron cronExpression: "0 20 4,5 ? * MON-SUN"
    }

    def socioService

    def concurrent = false

    
    def execute() {
        def fecha=new Date()-1
    	def res=socioService.limpiarBitacora(fecha,true)
        log.info 'Limpiando AccessLog anterior a: '+fecha.format('HH:mm:ss')+ " Eliminados: $res"
    }
}
