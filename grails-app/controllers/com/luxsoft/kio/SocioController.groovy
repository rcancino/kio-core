package com.luxsoft.kio

class SocioController {
    static scaffold = true
	
	def importadorService
	
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
		println 'Cliente encontrado: '+found
		redirect action:'index'
	}
	
}
