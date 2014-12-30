import com.luxsoft.kio.*
import com.luxsoft.cfdi.*
import com.luxsoft.sec.Role
import com.luxsoft.sec.Usuario
import com.luxsoft.sec.UsuarioRole
import org.bouncycastle.jce.provider.BouncyCastleProvider


class BootStrap {

	def grailsApplication

    def init = { servletContext ->

    	java.security.Security.addProvider(new BouncyCastleProvider())

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

		def serie=grailsApplication.config.luxsoft.cfdi.serie.venta
		def cfdiFolio=CfdiFolio.findBySerie(serie)
		if(!cfdiFolio){
			cfdiFolio=new CfdiFolio(serie:serie,folio:0)
			cfdiFolio.save()
		}

		def empresa=Empresa.findWhere(clave:'GASOC')
		if(!empresa){
			
			empresa=new Empresa(clave:'GASOC',nombre:'OPERADORA Y ADMINISTRADOR GASOC S.A. DE C.V.',
				rfc:'OAG100209GN8',
				regimen:'REGIMEN GENERAL DE LEY PERSONAS MORALE',
	            registroPatronal:'0')
			empresa.direccion=new Direccion(
				calle:'AVENIDA CUAUHTEMOC',
				numeroExterior:'1461',
				colonia:'SANTA CRUZ ATOYAC',
				municipio:'BENITO JUAREZ',
				codigoPostal:'03310',
				estado:'DISTRITO FEDERAL',
				pais:'MEXICO'
				
	        )
	        empresa.numeroDeCertificado='00001000000201478375'
	        empresa.certificadoDigital=grailsApplication.mainContext
	  		.getResource("/WEB-INF/sat/00001000000201478375.cer").file.readBytes()
	  		empresa.llavePrivada=grailsApplication.mainContext
	  		.getResource("/WEB-INF/sat/gasoc.key").file.readBytes()	
	  		empresa.usuarioPac="OAG100209GN8"
	  		empresa.passwordPac="guwueofei"
	  		//empresa.certificadoDigitalPfx=grailsApplication.mainContext
	  		//.getResource("/WEB-INF/data/kio/PAPEL_CFDI_CERT.pfx").file.readBytes()	
			empresa.save()
		}
	  	if(empresa.passwordPfx==null){
	  		//println 'Alta de datos para cancelacion'
	  		def file=grailsApplication.mainContext
	  			.getResource("/WEB-INF/sat/gasoc.pfx")
	  		assert file.exists(),'Debe existir el archivo PFX'
	  		empresa.certificadoDigitalPfx=grailsApplication.mainContext
	  		.getResource("/WEB-INF/sat/gasoc.pfx").file.readBytes()
	  		empresa.passwordPfx="pfxfilegasoc"
	  		empresa.save(flush:true)
	  		//empresa.save failOnError:true
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
		}
    	


    }

    def destroy = {
    }
}
