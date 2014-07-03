import com.luxsoft.kio.*


class BootStrap {

    def init = { servletContext ->

    	TipoDeCliente.findOrSaveWhere(clave:'PARTICULAR',descripcion:'Particular')
    	TipoDeCliente.findOrSaveWhere(clave:'EMPRESA_NIVEL1',descripcion:'Empresa nivel 1')
        

    	MedioDeContacto.findOrSaveWhere(clave:'UNDEFINED',descripcion:'Sin definir')
    	MedioDeContacto.findOrSaveWhere(clave:'PER01',descripcion:'Periodico Reforma')
    	MedioDeContacto.findOrSaveWhere(clave:'PROMO01',descripcion:'Promocion especial verano 2014')
    	MedioDeContacto.findOrSaveWhere(clave:'EXPO01',descripcion:'Promocion expo fitness WTC')

    	TipoDeSocio.findOrSaveWhere(clave:'GENERAL',descripcion:'Pendiente de asignar')
    	TipoDeSocio.findOrSaveWhere(clave:'PROFESIONISTA',descripcion:'Profesionista')
    	TipoDeSocio.findOrSaveWhere(clave:'AMA DE CASA',descripcion:'Señoras amas de casa')

    	Instructor.findOrSaveWhere(apellidoPaterno:'RAMOS',apellidoMaterno:'GOMEZ',nombres:'FULANO',nivel:'A')
        /*
        Cliente.findOrSaveWhere(nombre:'MOSTRADOR'
            ,rfc:'XAXX010101000'
            ,tipo:TipoDeCliente.findOrSaveWhere(clave:'MOSTRADOR',descripcion:'Cliente mostrador no requiere iva desgosado')
            )
        */
        TipoDeVenta.findOrSaveWhere(clave:'MOSTRADOR',descripcion:'Venta publico en general')

    	


    }

    def destroy = {
    }
}
