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
      cron cronExpression: "0 0 5,23 ? * MON-SUN"
    }

    def socioService

    def concurrent = false

    
    def execute() {
        def fecha=new Date()-1
        try {
            def res=socioService.limpiarBitacora(fecha,false)
            log.info 'Limpiando AccessLog anterior a: '+fecha.format('HH:mm:ss')+ " Eliminados: $res"
        }
        catch(Exception e) {
            log.error e
        }
    	
        
    }
}
