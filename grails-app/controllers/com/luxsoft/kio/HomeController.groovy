package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_REMEMBERED'])
class HomeController {
	
	

    def index() { }


    def cambiarPeriodo(Periodo command){
    	//println 'Request: '+request?.getHeader('referer')
    	def origin=request.getHeader('referer')
    	session.periodo=command
    	redirect(uri: request.getHeader('referer') )
    	
    }
	
	
}
