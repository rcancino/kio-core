<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nueva venta</title>
	%{-- <asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> --}%
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">
	

		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						Generacion de pedido nuevo
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<fieldset>
									<g:render template="form"/>
								</fieldset>
							</div>
						</div>
					</div>
						
					<div class="panel-footer">
  						<div class="btn-group">
  							
  							<g:link class="btn btn-default btn-sm" action="index" params="[tipo:'PEDIDO']">
  								Cancelar
  							</g:link>

  							<button class="btn btn-default btn-sm">
  								<span class="glyphicon glyphicon-floppy-saved"></span> Salvar
  							</button>
  							
  							<button class="btn btn-default btn-sm">
  								<span class="glyphicon glyphicon-plus"></span> Agregar partida
  							</button>
  							
  						</div>
					</div><!-- end .panel-footer -->

				</div>
			</div>
		</div>
			
		
	</div><!-- end .container -->



</body>
</html>