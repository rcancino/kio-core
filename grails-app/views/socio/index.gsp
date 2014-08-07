<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos"/>
	<title>Socios</title>
</head>
<body>
	<content tag="header">
		<h3>Catálogo de Socios </h3>
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
				<g:form class="form-inline" action="search" role="search">
					<div class="form-group ">
						<div class="input-group ">
							<div class="input-group-addon"><span class="glyphicon glyphicon-search"></span></div>
							<input name="term" type="text" class="form-control" placeholder="Apellido paterno" 
							autofocus="autofocus" autocomplete="off">
						</div>
						%{-- <input name="term" type="text" class="form-control" placeholder="Apellido materno" 
							autofocus="autofocus" autocomplete="off"> --}%
					</div>
				</g:form>
			</div>
	
		</div>
		
	</content>
	
</body>
</html>