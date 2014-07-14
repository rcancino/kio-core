package com.luxsoft.kio



class ClienteController {
    
	static scaffold = true
	
	def importadorService
	
	def index(Long max){
		params.max = Math.min(max ?: 25, 100)
		params.sort=params.sort?:'nombre'
		params.order='asc'
		[clienteInstanceList:Cliente.list(params),clienteInstanceCount:Cliente.count()]
	}
	
	
    def importar(){
    	importadorService.importarClientes()
		redirect action:'index'
    }
	
	def search(){
		def s=params.term?:'%'
		s+='%'
		def query=Cliente.where{nombre=~s}
		render view:'index',model:[clienteInstanceList:query.list(max:20,sort:'nombre'),clienteInstanceCount:query.count()]
		
	}
}
