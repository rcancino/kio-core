
import grails.plugin.springsecurity.SpringSecurityUtils

def loggedIn = { -> 
    springSecurityService.principal instanceof String
}
def loggedOut = { -> 
    !(springSecurityService.principal instanceof String)
}
def isAdmin = { -> 
    SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
}
def isAdministracion = { -> 
    SpringSecurityUtils.ifAllGranted('ADMINISTRACION')
}
def isMostrador ={
	SpringSecurityUtils.ifAllGranted('MOSTRADOR')	
}
def isCajero ={
	SpringSecurityUtils.ifAllGranted('CAJERO')	
}

navigation={
	user{
		home(action:'index'){}
		
		catalogos(controller:'home'){
			tipoDeSocio(controller:'tipoDeSocio',action:'index',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
			tipoDeCorporativo(controller:'tipoDeCorporativo',action:'index',titleText:'Corporativos',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
			socio(controller:'socio',action:'index')
			tipoDeCliente(controller:'tipoDeCliente',action:'index',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
			cliente(controller:'cliente',action:'index')
			medioDeContacto(controller:'medioDeContacto',action:'index',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
			instructor(controller:'instructor',action:'index')
			producto(controller:'producto',action:'index')
			tipoDeProducto(controller:'tipoDeProducto',action:'index',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
			tipoDeVenta(controller:'tipoDeVenta',action:'index',enabled:SpringSecurityUtils.ifAllGranted('ADMINISTRACION'))
		
		}
		operaciones(){
			ventas(controller:'venta',action:'index')
			caja(controller:'cobro',action:'pendientes'){
				cobrosPendientes(controller:'caja',action:'index',titleText:'Pendientes de cobrar')
				pagos(controller:'pago',action:'index',titleText:'Pagos ',data:[icon:'fa fa-pencil fa-fw'])
				notasDeCredito()
			}
			pagos(controller:'pago',action:'index')
			cxc(controller:'cxc',action:'index')
			cfdi(controller:'cfdi',action:'index')
			credencial(controller:'credencial',action:'index')
		}
		procesos(){
			cfdi(controller:'cfdi',action:'index')
		}
		reportes(){
			
		}
		consultas(){
			socios()
			acceso(controller:'accessLog',action:'index')
			reportes()
			
		}
		configuracion(){
			usuarios(controller:'usuario',action:'index')
		}
		info(view:'info')
	}
	
}