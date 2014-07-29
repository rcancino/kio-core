<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Venta ${ventaInstance.id}</title>
	<asset:javascript src="forms/autoNumeric.js"/>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<g:link class="btn btn-default btn-sm" controller="venta" action="edit" id="${ventaInstance.id}" >
  							Venta: ${ventaInstance.id} ${ventaInstance.cliente}
  						</g:link>
					</div>
					<div class="panel-body">
						<g:if test="${flash.message}">
							<div class="alert alert-warning" >
								<strong>${flash.message}</strong>
							</div>
						</g:if>
						<g:hasErrors bean="${ventaDetInstance}">
							<div class="alert alert-danger alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
								<ul>
									<g:eachError var="err" bean="${ventaDetInstance}">
										<li><g:message error="${err}"/></li>
									</g:eachError>
								</ul>
							</div>
						</g:hasErrors>
						<g:render template="createForm"/>
					</div>
						
					<div class="panel-footer">
  						<div class="btn-group">
  						
  							<g:link class="btn btn-default btn-sm" controller="venta" action="edit" id="${ventaInstance.id}" >
  								<span class="glyphicon glyphicon-hand-left"></span> Regresar
  							</g:link>
  							
  							
  							
  							
  						</div>
					</div><!-- end .panel-footer -->

				</div>
			</div>
		</div>
			
		
	</div><!-- end .container -->

	

</body>
</html>