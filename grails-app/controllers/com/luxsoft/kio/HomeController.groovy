package com.luxsoft.kio

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_REMEMBERED'])
class HomeController {
	
	

    def index() { }
	
	
}
