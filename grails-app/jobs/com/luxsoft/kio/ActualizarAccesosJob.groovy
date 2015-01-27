package com.luxsoft.kio


/**
*  Actualiza las lectoras activando o desactivando los socios con atrasos
*
*
**/
class ActualizarAccesosJob {

	def socioService

    static triggers = {
      //simple name:'simpleTrigger', startDelay:10000, repeatInterval: 60000, repeatCount: 1
      cron cronExpression: "0 0 4,14,23 * * ?"
    }

    def execute() {
    	try {
    		def time=new Date().format('dd/MM/yyyy HH:mm:ss')
    		def res=socioService.suspender()
    		log.info "Resultado de la suspencion automatica: $res Ejecutado: $time"
    	}catch(Exception e) {
    		log.error e
    	}
    	
        
        
    }
}
