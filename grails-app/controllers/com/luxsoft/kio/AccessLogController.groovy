package com.luxsoft.kio
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION')"])
class AccessLogController {

    def socioService

    def index(Integer max) { 
    	//println 'Registro de accessos.'
    	params.max = Math.min(max ?: 50, 100)
		params.sort=params.sort?:'dateCreated'
		params.order='desc'
        def now=new Date()
        def list=AccessLog.findAll("from AccessLog a where date(a.dateCreated) between ? and ?",[now-1,now],params)
        def count=AccessLog.executeQuery("select count(*) from AccessLog a where date(a.dateCreated) between ? and ?",[now-1,now])
		[accessLogInstanceList:list,accessLogInstanceCount:count[0]]
    }

    def limpiarLog(){
    	//AccessLog.executeUpdate("delete from AccessLog")
    	redirect action:'index'
    }

    def exportarALectora(){
        socioService.exportarALectora()
        redirect action:'index'
    }


}
