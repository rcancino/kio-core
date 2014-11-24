<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="holder/holder.js"/>
	<title>Producto ${productoInstance.clave}</title>
</head>
<body>

	<div class="container">
		
		<div class="row">
			<div class="col-md-12">
				<div class="well ${productoInstance.suspendido?'alert alert-danger':''}">
					<h3>${productoInstance} ${productoInstance.suspendido?'SUSPENDIDO':'ACTIVO'}
						
					</h3>
					<g:if test="${flash.message}">
                    	<span class="label label-warning">${flash.message}</span>
                	</g:if> 
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<g:form class="form-horizontal" role="form" action="actualizarProducto" id="${productoInstance.id}">
					
					<g:hiddenField name="version" value="${productoInstance.version}"/>
					<f:with bean="${productoInstance}">

						<div class="col-md-6">
							<div class="panel-header"><h3>Características</h3></div>
								<f:field property="clave" input-class="form-control"/>
								<f:field property="descripcion" input-class="form-control"/>
								<f:field property="descripcion2" input-class="form-control"/>
								<f:field property="unidad" input-class="form-control"/>
								<f:field property="inventariable" input-class="form-control"/>
								<f:field property="tipo" input-class="form-control"/>
								<f:field property="periodicidad" input-class="form-control"/>
								<f:field property="duracion" input-class="form-control" input-type="text"/>
								<f:field property="suspendido" input-class="form-control" />
							</div>

						<div class="col-md-6">
							<div class="panel-header"><h3>Precio / Descuento</h3></div>
							<f:field property="precioBruto" input-class="form-control" input-type="text"/>
							<f:field property="descuento" input-class="form-control" input-type="text"/>
							<f:field property="precioNeto" input-class="form-control" input-type="text"/>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-2">
								<g:submitButton name="Actualizar" class="btn btn-primary " />
							</div>
						</div>
					</f:with>
				</g:form>
			</div>
		</div>

		<script type="text/javascript">
		
		</script>
	
	</div><!-- .end container -->
	

</body>
</html>