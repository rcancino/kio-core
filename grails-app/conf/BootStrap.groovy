import com.luxsoft.kio.*
import com.luxsoft.cfdi.*
import com.luxsoft.sec.Role
import com.luxsoft.sec.Usuario
import com.luxsoft.sec.UsuarioRole


class BootStrap {

    def init = { servletContext ->

    	def adminRole=Role.findOrSaveWhere(authority:'ROLE_ADMIN')
		def userRole=Role.findOrSaveWhere(authority:'ROLE_USER')
		def mostradorRole=Role.findOrSaveWhere(authority:'MOSTRADOR')
		def cajeroRole=Role.findOrSaveWhere(authority:'CAJERO')
		def administracionRole=Role.findOrSaveWhere(authority:'ADMINISTRACION')
		

		
		def admin=Usuario.findByUsername('admin')
		if(!admin){
			admin=new Usuario(username:'admin'
				,password:'admin'
				,apellidoPaterno:'admin'
				,apellidoMaterno:'admin'
				,nombres:'admin'
				,nombre:' ADMIN ADMIN').save(flush:true)
			UsuarioRole.create(admin,userRole,true)
			UsuarioRole.create(admin,adminRole,true)
			UsuarioRole.create(admin,administracionRole,true)
		}
		
		environments {
			development {
				
				TipoDeCliente.findOrSaveWhere(clave:'PARTICULAR',descripcion:'Particular')
				TipoDeCliente.findOrSaveWhere(clave:'EMPRESARIAL',descripcion:'Empresa')
				
		
				MedioDeContacto.findOrSaveWhere(clave:'NO_DEFINIDO',descripcion:'Sin definir')
				MedioDeContacto.findOrSaveWhere(clave:'PEDIODICO',descripcion:'Anuncio en periodico')
				MedioDeContacto.findOrSaveWhere(clave:'RECOMENDACION',descripcion:'Recomandado por una amistad/familiar')
				MedioDeContacto.findOrSaveWhere(clave:'WEB',descripcion:'Página web')
				
		
				TipoDeSocio.findOrSaveWhere(clave:'GENERAL',descripcion:'Pendiente de asignar')
				TipoDeSocio.findOrSaveWhere(clave:'PROFESIONISTA',descripcion:'Profesionista')
				TipoDeSocio.findOrSaveWhere(clave:'AMA DE CASA',descripcion:'Señoras amas de casa')
				TipoDeSocio.findOrSaveWhere(clave:'ESTUDIANTE',descripcion:'Estudiante')

				TipoDeCorporativo.findOrSaveWhere(clave:'MAZDA',descripcion:'Mazda')
				TipoDeProducto.findOrSaveWhere(clave:'MEMBRESIA',descripcion:'Membresias de acceso')
		
				
				Cliente.findOrSaveWhere(nombre:'MOSTRADOR'
					,rfc:'XAXX010101000'
					,tipo:TipoDeCliente.findOrSaveWhere(clave:'MOSTRADOR',descripcion:'Cliente mostrador no requiere iva desgosado')
					)

				TipoDeVenta.findOrSaveWhere(clave:'MEMBRESIA',descripcion:'Venta para el cobro de membresias')
				TipoDeVenta.findOrSaveWhere(clave:'GENERAL',descripcion:'Venta general de productos y servicios')

				def folioSocio=CfdiFolio.findWhere(serie:'SOCIOS')
				
				if(folioSocio==null){
					folioSocio=new CfdiFolio(serie:'SOCIOS',folio:50000)
					folioSocio.save()
				}
				
				
			}
			
			test {
				
			}
			
			production {
				
			}
		}
    	


    }

    def destroy = {
    }
}
