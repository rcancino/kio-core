<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Venta</title>
	%{-- <asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> --}%
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
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
									
									<g:render template="form"/>
								</fieldset>
							</div>
							
						</div>
  					</div>
  					<div class="panel-footer">
  						<div class="btn-group">
  							<button class="btn btn-default btn-sm">Editar</button>
  							<button class="btn btn-default btn-sm">Eliminar</button>
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