<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Venta</title>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-md-12">

				<div class="panel panel-primary">
					<!-- Default panel contents -->
  					<div class="panel-heading">
  						Venta: ${ventaInstance.id}  (${ventaInstance?.status})
  					</div>
  					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<fieldset >
									
									<g:render template="showForm"/>
								</fieldset>
							</div>
							
						</div>
  					</div>
  					<div class="panel-footer">
  						<div class="btn-group">
  							<g:link class="btn btn-default btn-sm" action="edit" id="${ventaInstance.id}">
  								<span class="glyphicon glyphicon-pencil"></span> Editar
  							</g:link>
  							<g:link class="btn btn-default btn-sm" action="delete" id="${ventaInstance.id}"
  								onclick="return confirm('Eliminar venta');">
  								<span class="glyphicon glyphicon-trash"></span> Eliminar
  							</g:link>
  							<g:link class="btn btn-default btn-sm" action="create">
  								<span class="glyphicon glyphicon-floppy-saved"></span> Nueva
  							</g:link>
  							<g:if test="${ventaInstance.status=='PEDIDO' }">
  								<g:link class="btn btn-default btn-sm" action="create">
  									<span class="glyphicon glyphicon-shopping-cart"></span> Mandar Facturar
  								</g:link>
  							</g:if>
  							
  						</div>
						
					</div>
				</div>

			</div>

		</div><!-- end .row -->
		


		
	</div>
	
	
</body>
</html>