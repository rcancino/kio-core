navigation={
	user{
		home(action:'index'){}
		
		catalogos(controller:'home'){
			tipoDeSocio(controller:'tipoDeSocio',action:'index')
			socio(controller:'socio',action:'index')
			tipoDeCliente(controller:'tipoDeCliente',action:'index')
			cliente(controller:'cliente',action:'index')
			medioDeContacto(controller:'medioDeContacto',action:'index')
			instructor(controller:'instructor',action:'index')
			producto(controller:'producto',action:'index')
			tipoDeProducto(controller:'tipoDeProducto',action:'index')
			tipoDeVenta(controller:'tipoDeVenta',action:'index')
		
		}
		operaciones(){
			ventas(controller:'venta',action:'index')
		}
		procesos(){
			cfdi(controller:'cfdi',action:'index')
		}
		reportes(){
			
		}
		configuracion(){
		}
		info(view:'info')
	}
	
}