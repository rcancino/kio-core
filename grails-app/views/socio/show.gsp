<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Socios</title>
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
								  <li><a href="#membresia" role="tab" data-toggle="tab">Membresia</a></li>
								  <li><a href="#settings" role="tab" data-toggle="tab">Settings</a></li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="tab-content">
								  <div class="tab-pane active" id="generales">
								  	<g:render template="generales"/>
								  	
								  	
								  </div>
								  <div class="tab-pane" id="profile"><g:render template="perfil"/></div>
								  <div class="tab-pane" id="membresia">...</div>
								  <div class="tab-pane" id="settings">...</div>
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