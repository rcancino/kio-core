import com.luxsoft.kio.*


class BootStrap {

    def init = { servletContext ->
		
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
		
				
				Cliente.findOrSaveWhere(nombre:'MOSTRADOR'
					,rfc:'XAXX010101000'
					,tipo:TipoDeCliente.findOrSaveWhere(clave:'MOSTRADOR',descripcion:'Cliente mostrador no requiere iva desgosado')
					)
				TipoDeVenta.findOrSaveWhere(clave:'MOSTRADOR',descripcion:'Venta publico en general')
				
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
