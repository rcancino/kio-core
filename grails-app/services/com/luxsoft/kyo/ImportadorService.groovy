package com.luxsoft.kyo

import org.apache.commons.lang.exception.ExceptionUtils;

import grails.transaction.Transactional
import grails.transaction.NotTransactional
import groovy.sql.Sql

import com.luxsoft.kio.*

class ImportadorService {
	
	static transactional = false
	
	def dataSource_importacion
	
	
	
    def importarClientes() {
		log.info 'Importando clientes desde siipap-gasoc'
		def db = new Sql(dataSource_importacion)
		def tipo
		def importados=0
		def res=db.eachRow("select * from SX_CLIENTES"){row->
			//log.info 'Importando: '+row
			def found=Cliente.findByOrigen(row.CLIENTE_ID.toLong())
			if(!found){
				if(!tipo){
					tipo=TipoDeCliente.findOrSaveWhere(clave:'GENERAL',descripcion:'Cliente sin clasificación')
				}
				//log.info "Importando cliente:${row.NOMBRE} (${row.CLAVE})"
				
				def cliente=new Cliente(
					origen:row.CLIENTE_ID,
					nombre:row.NOMBRE,
					rfc:row.RFC,
					tipo:tipo,
					emailCfdi:row.EMAIL1)
				cliente.validate()
				if(cliente.hasErrors()){
					cliente.errors.allErrors.each{
						//println "Validation error : "+it.
					}
				}
				def direccion=new Direccion(
					calle:row.CALLE?:''
					,numeroExterior:row.NUMERO?:''
					,colonia:row.COLONIA?:''
					,municipio:row.DELMPO?:''
					,estado:row.ESTADO?:''
					,codigoPostal:row.CP?:''
					)
				//cliente.direccion=direccion
				try{
					found=cliente.save(failOnError:true)
					importados++
				}catch(Exception th){
					//log.error "Error importando ${row.NOMBRE} ${row.CLAVE} Messge:"+ExceptionUtils.getRootCauseMessage(th)
					log.info "Error importando: "+row.CLIENTE_ID+"  "+ExceptionUtils.getRootCauseMessage(th)
				}
				
			}else{
				//log.info "YA Importado :${row.NOMBRE} (${row.CLAVE})"
				
			}
			
		}
		['importados':importados]
    }
	
	
	def importarSocios() {
		log.info 'Importando socios desde siipap-gasoc'
		def db = new Sql(dataSource_importacion)
		def tipo=TipoDeSocio.findByClave('GENERAL')
		assert tipo,'Debe existir el tipo de Socio General'
		
		def importados=0
		def res=db.eachRow("select s.* from SX_SOCIOS2 s "){row->
			//log.info 'Importando: '+row
			def found=Socio.findByOrigen(row.SOCIO)
			if(!found){
				log.info "Importando socio:${row.APELLIDOP} ${row.APELLIDOM} ${row.NOMBRES}  clie:(${row.CLIENTE_ID})"+row
				try{
					def cliente=Cliente.findByOrigen(row.CLIENTE_ID)
					//assert cliente,'No existe el cliente: '+row.CLIENTE_ID
					if(cliente){
						found=new Socio(
						origen:row.SOCIO,
						apellidoPaterno:row.APELLIDOP,
						apellidoMaterno:row.APELLIDOM,
						nombres:row.NOMBRES,
						telefonoCasa:row.TELEFONO1,
						telefonoTrabajo:row.TELEFONO2,
						activo:row.VIGENTE,
						tipoDeSocio:tipo,
						cliente:cliente
						)
						found.save(failOnError:true)
						importados++
					}
					
				}catch(Exception th){
					log.error "Error importando ${row.APELLIDOP} (${row.SOCIO}) Messge:"+ExceptionUtils.getRootCauseMessage(th)
				}
				
			}else{
				
				
			}
			
		}
		['importados':importados]
	}

	def importarProductos(){
		log.info 'Importando socios desde siipap-gasoc'
		def db = new Sql(dataSource_importacion)
		def servicio=TipoDeProducto.findOrSaveWhere(clave:'SERVICIO',descripcion:'Serivicio generico') 
		def articulo=TipoDeProducto.findOrSaveWhere(clave:'GENERAL',descripcion:'Articulo de caracter general') 
		def importados=0
		def res=db.eachRow("select s.* from SX_PRODUCTOS s where s.linea_id!=13"){row->
			def found=Producto.findByClave(row.CLAVE)
			if(!found){
				def producto=new Producto(
					clave:row.CLAVE,
					descripcion:row.DESCRIPCION,
					descripcion2:'Importado',
					inventariable:row.INVENTARIABLE,
					tipo:row.INVENTARIABLE?articulo:servicio,
					precioBruto:row.PRECIOCONTADO,
					descuento:0.0,
					precioNeto:row.PRECIOCONTADO,
					unidad:row.INVENTARIABLE?'PIEZA':'SERVICIO'
					)
				try{
					producto.validate()
					producto.save failOnError:true
				}catch(Exception ex){
					log.error "Error importando ${row.CLAVE} "+ExceptionUtils.getRootCauseMessage(ex)

				}
			}
		}

	}
}
