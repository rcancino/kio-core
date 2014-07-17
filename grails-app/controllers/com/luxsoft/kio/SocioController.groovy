package com.luxsoft.kio

class SocioController {
    static scaffold = true
	
	def importadorService
	def socioService
	
	def index(Long max){
		params.max = Math.min(max ?: 15, 100)
		params.sort=params.sort?:'apellidoPaterno'
		params.order='asc'
		
		[socioInstanceList:Socio.list(params),socioInstanceCount:Socio.count()]
	}
	
	def importar(){
		importadorService.importarSocios()
		redirect action:'index'
	}
	
	def search(){
		def found=Cliente.find{origen==1L}
		log.debug 'Cliente encontrado: '+found
		redirect action:'index'
	}

	def save(Socio socioInstance,boolean mostrador){
		log.info 'Salvando socio:'+socioInstance+ ' Mostrador: '+mostrador
		if(mostrador){
			def cliente=Cliente.findByRfc('XAXX010101000')
			assert cliente,'Debe estar dado de alta  el cliente mostrador'
			socioInstance.cliente=cliente
		}
		socioInstance=socioService.salvarSocio(socioInstance)
		render view:'show',model:[socioInstance:socioInstance]
	}

	
	
}
