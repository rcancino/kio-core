package com.luxsoft.kio

import grails.converters.JSON

class RestController {

   def getClientesJSON() {
   		println 'REST Lookup: '+params
		def term=params.term.trim()+'%'
		// def query=Cliente.where{}
		// query=query.where{
		// 	nombre=~term 
		// }
		/*
		def list=Cliente.list()
		println 'Buscando clientes JSON: '+list.size()+' params: '+params.term
		list=list.collect{ c->
			def nombre="$c.nombre"
			[id:c.id,
			label:nombre,
			value:nombre,
			rfc:c.rfc
			]
		}
		def res=list as JSON
		
		render res
		*/
		render Cliente.list() as JSON

	}
}
