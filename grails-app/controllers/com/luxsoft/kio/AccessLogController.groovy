package com.luxsoft.kio
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION')"])
class AccessLogController {

    def index(Integer max) { 
    	//println 'Registro de accessos.'
    	params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		[accessLogInstanceList:AccessLog.list(params),accessLogInstanceCount:AccessLog.count()]
    }

    def limpiarLog(){
    	AccessLog.executeUpdate("delete from AccessLog")
    	redirect action:'index'
    }


}
