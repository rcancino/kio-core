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
			
			<form name="partidaForm" novalidate class="form-horizontal" >
			
				<div class="modal-body">
						
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
							<input type="number" id="precioBruto" class="form-control" autocomplete="off"
								required ng-model="partidaNueva.precioBruto">
						</div>
					</div>
					<div class="form-group {{'has-error'}}">
						<label for="descuento" class="control-label col-sm-2">Descuento</label>
						<div class="col-sm-10">
							<input type="number" id="descuento" class="form-control" autocomplete="off"
								ng-model="partidaNueva.descuento">
						</div>
					</div>
				</div>

				<div class="modal-footer">
					
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        			<button  ng-click="agregarPartida(partidaNueva)" 
        				class="btn btn-primary"  data-dismiss="modal" ng-disabled="partidaForm.$invalid">Salvar</button>
				</div>

			</form><!-- end .form-->

		</div>
	</div>
</div>