<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nueva venta</title>
	
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="venta/ventaNuevaSPA.js"/>
	<asset:javascript src="venta/model.js"/>
	<asset:javascript src="venta/directives.js"/>
</head>
<body>
	<div class="container" ng-app="ngVentaNueva" >
	

		<div class="row" ng-controller="MainCtrl">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						{{title}} 
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<fieldset>
									<g:render template="spa/spaForm"/>
								</fieldset>
							</div>
						</div>
					</div>

					<div class="aler alert-warning">
						
						<pre>{{venta | json}}</pre>
					</div>
						
					<div class="panel-footer">
  						<div class="btn-group">
  							
  							<g:link class="btn btn-default btn-sm" action="index" params="[tipo:'PEDIDO']">
  								Cancelar
  							</g:link>

  							<button class="btn btn-default btn-sm" 
  								ng-disabled="ventaNuevaForm.$invalid"
  								ng-click="salvar(venta)">
  								<span class="glyphicon glyphicon-floppy-saved" ></span> Salvar
  							</button>
  							
  							<button class="btn btn-default btn-sm" 
  								data-toggle="modal" data-target="#partidaNuevaDialog">
  								<span class="glyphicon glyphicon-plus"></span> Agregar partida
  							</button>
  							
  						</div>
					</div><!-- end .panel-footer -->

				</div>
			</div>
		</div> <!-- .end row -->
		
		<div class="row">
			<!-- Agregar partida form -->
			<div id="partidaNuevaDialog" class="modal fade" >
				<div class="modal-dialog">
					<div class="modal-content">
						
						<div class="modal-header">
							<button class="close" type="buton" data-dismiss="modal">
								<span aria-hidden="true">&times</span>
								<span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">Agregar Producto/Servicio</h4>
						</div><!-- end .modal-header -->
						
						<form name="partidaForm" novalidate class="form-horizontal" 
							ng-submit="agregarPartida(partidaNueva)">
						
							<div class="modal-body ">
									
								<div class="form-group ">
									<label for="producto" class="control-label col-sm-2" autofocus="true">Producto</label>
									<div class="col-sm-10 ui-front">
										<input type="text" id="producto" class="form-control" autocomplet-producto
											autocomplete="off"
											required ng-model="partidaNueva.producto">
									</div>
								</div>
								<div class="form-group">
									<label for="cantidad" class="control-label col-sm-2">Cantidad</label>
									<div class="col-sm-10">
										<input type="number" id="producto" class="form-control" autocomplete="off"
											required ng-model="partidaNueva.cantidad">
									</div>
								</div>
								<div class="form-group">
									<label for="precio" class="control-label col-sm-2">Precio</label>
									<div class="col-sm-10">
										<input type="number" id="producto" class="form-control" autocomplete="off"
											required ng-model="partidaNueva.precio">
									</div>
								</div>
								<div class="form-group {{'has-error'}}">
									<label for="descuento" class="control-label col-sm-2">Descuento</label>
									<div class="col-sm-10">
										<input type="number" id="producto" class="form-control" autocomplete="off"
											ng-model="partidaNueva.descuento">
									</div>
								</div>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			        			<button type="submit" class="btn btn-primary" ng-disabled="partidaForm.$invalid">Salvar</button>
							</div>

						</form><!-- end .form-->

					</div>
				</div>
			</div>
		</div><!-- end .row 2 -->
		
	</div><!-- end .container -->
	



</body>
</html>