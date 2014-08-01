<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Socio ${socioInstance.id}</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
	<asser:javascript src="holder/holder.js"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="well"><h3>${socioInstance}  (${socioInstance.id})</h3></div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs ">
				<li class="active"><a href="#generales" role="tab" data-toggle="tab">Generales</a></li>
				<li><a href="#profile" role="tab" data-toggle="tab">Perfil</a></li>
				<li ><a href="#servicios" role="tab" data-toggle="tab">Servicios</a></li>
				<li><a href="#otros" role="tab" data-toggle="tab">Facturación</a></li>
			</ul>
			<div class="tab-content">
				 <div class="tab-pane active" id="generales">
				 	<g:render template="edit/generalesForm"/>
				 </div>
				<div class="tab-pane" id="profile">
					%{-- <g:render template="perfil"/> --}%
				</div>
			  	<div class="tab-pane" id="servicios">
			  		%{-- <g:render template="servicios"/> --}%
			  	</div>
				<div class="tab-pane" id="otros">
					%{-- <g:render template="facturacion"/> --}%
				</div>
			</div>
		</div>
	</div>
</div>






	
	
</body>
</html>