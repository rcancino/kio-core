<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Socio nuevo</title>
	
	<asset:javascript src="socio/spa.js"/>
</head>
<body>
	<div class="container" ng-app="SociosApp">

		<div class="row" ng-controller="SocioCtrl">
			<div class="col-md-12">
				<div class="well">
					<h3 ng-if="socio.apellidoPaterno" >{{socio.apellidoPaterno}}</h3>
					<h3 ng-if="!socio.apellidoPaterno" >{{'Alta de socio'}}</h3>
				</div>
			</div>
			<div class="col-md-12">
				<form name="socioForm" novalidate class="form-horizontal" ng-submit="salvar(socio)">
				</form>
			</div>
		</div>



	</div>



</body>
</html>