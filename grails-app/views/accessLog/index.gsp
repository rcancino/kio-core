<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Control de acceso</title>
</head>
<body>
	
	<div class="container">
		<div class="row ">
			<div class="col-md-12">
				<div class="well">
					<h3>
						Control de accesso
					</h3>
				</div>
			</div>
		</div><!-- end row-->

		<div class="row">
			<div class="col-md-12">
				<div class="button-panel">
					<div class="btn-group">
						<input type='text' id="socioField" placeholder="Socio" class="form-control" autocomplete="off" autofocus="autofocus">
					</div>
					<div class="btn-group">
						<input type='text' id="tarjetaField" placeholder="Tarjeta" class="form-control" autocomplete="off" >
					</div>
					<div class="btn-group ">
						<g:link action="index" class="btn btn-default" > Refrescar</g:link>
					</div> <%-- end .btn-group acciones --%>
			</div>
			

		</div><!-- end .row button panel -->

	</div>
	
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
							<input name="term" type="text" class="form-control" placeholder="" 
							autofocus="autofocus" autocomplete="off">
						</div>
						
					</div>
				</g:form>
			</div>
	
		</div>
		
	</content>
	
</body>
</html>