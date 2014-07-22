<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Socios</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/>
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
  						Socio: ${socioInstance}  
  					</div>
  					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<ul class="nav nav-tabs " role="tablist">
								  <li class="active"><a href="#generales" role="tab" data-toggle="tab">Generales</a></li>
								  <li><a href="#profile" role="tab" data-toggle="tab">Perfil</a></li>
								  <li class="${tab=='servicio'?'active':'' }"><a href="#servicios" role="tab" data-toggle="tab">Servicios</a></li>
								  <li><a href="#otros" role="tab" data-toggle="tab">Otros</a></li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="tab-content">
								  <div class="tab-pane active" id="generales">
								  	<g:render template="generales"/></div>
								  <div class="tab-pane" id="profile">
								  	<g:render template="perfil"/></div>
								  <div class="tab-pane" id="servicios">
								  	<g:render template="servicios"/></div>
								  <div class="tab-pane" id="otros">...</div>
								</div>
							</div>
						</div>
  					</div>
  					<div class="panel-footer">
  						<div class="btn-group">
  							<button class="btn btn-default btn-sm">Editar</button>
  							<button class="btn btn-default btn-sm">Eliminar</button>
  						</div>
						
					</div>
				</div>

			</div>

		</div><!-- end .row -->
		


		
	</div>
	
	
</body>
</html>