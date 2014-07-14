<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos"/>
	<title>Clientes</title>
</head>
<body>
	<content tag="header">
		<h3>Catálogo de Clientes</h3>
	</content>
	<content tag="toolbar">
		<div class="col-md-12 toolbar-panel">
	<div class="btn-group">
		<g:link action="index" class="btn btn-default ">
			<span class="glyphicon glyphicon-repeat"></span> Refrescar
		</g:link>
		<g:link action="create" class="btn btn-default">
			<span class="glyphicon glyphicon-floppy-saved"></span> Alta
		</g:link>
		<g:link action="importar" class="btn btn-default">
			<span class="glyphicon glyphicon-import"></span> Importar
		</g:link>
	</div>
	<div class="btn-group">
		<form class="form-inline" action="search" role="search">
			<div class="form-group">
				<div class="input-group ">
					<div class="input-group-addon"><span class="glyphicon glyphicon-search"></span></div>
					<input type="text" class="form-control" placeholder="Buscar" autofocus="autofocus">
				</div>
				
			</div>
			
		</form>
	</div>
	
</div>
	</content>
</body>
</html>