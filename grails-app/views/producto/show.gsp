<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Producto</title>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-md-12">

				<div class="panel panel-primary">
					<!-- Default panel contents -->
  					<div class="panel-heading">
  						${productoInstance}  
  					</div>
  					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<g:if test="${flash.message}">
                    				<span class="label label-warning">${flash.message}</span>
             					</g:if>
								<ul class="nav nav-tabs " role="tablist">
								  <li class="active"><a href="#productoPanel" role="tab" data-toggle="tab">Producto</a></li>
								  <li><a href="#ventasPanel" role="tab" data-toggle="tab">Ventas</a></li>
								  <li><a href="#sociosPanel" role="tab" data-toggle="tab">Socios</a></li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="tab-content">
								  <div class="tab-pane active" id="productoPanel"><g:render template="detalle"/></div>
								  <div class="tab-pane" id="ventasPanel">
								  		<h2>PENDIENTE</h2>
								  		<p>Aquí encontrará todas las ventas relacionadas con este producto o servicio</p>
								  	</div>
								  <div class="tab-pane" id="sociosPanel">
								  	<h2>PENDIENTE</h2>
								  		<p>Aquí encontrará todas las socios que han adquirido este producto o servicio</p>
								  </div>
								</div>
							</div>
						</div>
  					</div>
  					<div class="panel-footer">
  						<div class="btn-group">
  							<g:link class="btn btn-default btn-sm" action='index'> 
  								<span class="glyphicon glyphicon-arrow-left"> Catálogo
  							</g:link>
  							<g:link class="btn btn-default btn-sm" action='edit' id="${productoInstance.id}"> 
  								<span class="glyphicon glyphicon-pencil"> Editar
  							</g:link>
  							<g:link class="btn btn-danger btn-sm" action='delete' onclick="return confirm('Seguro que desea eliminar este producto');"> 
  								<span class="glyphicon glyphicon-trash"> Eliminar
  							</g:link>
  							
  						</div>
						
					</div>
				</div>

			</div>

		</div><!-- end .row -->
		


		
	</div>
	
	
</body>
</html>