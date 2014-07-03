<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Clientes</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">

				<div class="panel panel-primary">
					<!-- Default panel contents -->
  					<div class="panel-heading">Catálogo de clientes</div>
  					<div class="panel-body">
						<g:render template="toolbar"/>
  					</div>
  					<div class="row">
						<div class="col-md-12"><g:render template="grid"/></div>
					</div>
				</div>

			</div>
		</div>
		


		%{-- <div class="row">
			<div class="col-md-12">
				<div class="well well-sm"><h2>Catálogo de socios</h2></div>
			</div>
			
		</div><!-- end -row 1 -->
		
		<div class="row">

			<div class="col-lg-4">
				<div class="btn-group ">
					<g:link action="index" class="btn btn-default">
						<span class="glyphicon glyphicon-repeat"></span> Refrescar
					</g:link>
					<g:link action="create" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-saved"></span> Alta
					</g:link>
					
					<g:link action="create" class="btn btn-default">
						<span class="glyphicon glyphicon-filter"></span> Filtrar
					</g:link>
				</div>
				
			</div><!-- /.col-lg-6 -->
			
			<div class="col-lg-8">
				<form class="form-inline" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Buscar2" autofocus="autofocus" autocomplete="on">
					</div>
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span> Buscar
					</button>
				</form>
			</div>

		</div><!-- end -row 2 -->

		<div class="row">
			<div class="col-md-12">
				<g:render template="grid"/>
				
			</div>
			
		</div> --}%
	</div>
	
	
</body>
</html>