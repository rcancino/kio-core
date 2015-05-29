
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
			tipoDeCorporativo(controller:'tipoDeCorporativo',action:'index',titleText:'Corporativos')
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
				//cobrosPendientes(controller:'caja',action:'index',titleText:'Pendientes de cobrar')
				pendientes(controller:'cobro',action:'pendientes',titleText:'Ventas por cobrar')
				cobros(controller:'cobro',action:'index',data:[icon:'fa fa-money fa-fw'])
				pagos(controller:'pago',action:'index',titleText:'Pagos ',data:[icon:'fa fa-pencil fa-fw'])
				cobranza(controller:'pago',action:'cobranza',titleText:'Cobranza ',data:[icon:'fa fa-usd fa-fw'])
				corte(controller:'corteDeCaja',action:'index',data:[icon:'fa fa-tag fa-fw'])
				notasDeCredito(controller:'notaDeCredito',action:'index')
				ventas(titleText:'Ventas (Todas)')
			}
			//pagos(controller:'pago',action:'index')
			cxc(controller:'cxc',action:'index')
			cfdi(controller:'cfdi',action:'index',titleText:"CFDI's")
			credencial(controller:'credencial',action:'index')
		}
		procesos(){
			cfdi(controller:'cfdi',action:'index')
		}

		reportes(controller:'report',action:'index'){
			ventas(controller:'report'){
				ventasGenerales(controller:'report')
				ventasPorProducto(controller:'report')
			}
			socios(controller:'report'){
				catalogo(controller:'report',action:'catalogoDeSocios')
			}
		}
		consulta(titleText:'Socios'){
			socios(titleText:'Socios (Ctrl+S) ')
			productos(titleText:'Productos (Alt+P)')
			ventas(controller:'venta',action:'todas')
			acceso(controller:'accessLog',action:'index')
			
			
		}
		configuracion(){
			usuarios(controller:'usuario',action:'index')
			emresa(controller:'empresa',action:'index')
		}
		info(view:'info')
	}
	
}