package com.luxsoft.kio

class AccessLogController {

    def index(Integer max) { 
    	//println 'Registro de accessos.'
    	params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'lastUpdated'
		params.order='desc'
		[accessLogInstanceList:AccessLog.list(params),accessLogInstanceCount:AccessLog.count()]
    }


}
