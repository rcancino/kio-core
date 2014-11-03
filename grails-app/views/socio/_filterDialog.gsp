<%@page expressionCodec="none"%>
<div class="modal fade" id="filtrarDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Filtrar</h4>
			</div>

			<g:form class="form-horizontal" action="search" >
				<div class="modal-body">
					<div class="form-group">
						<label for="nombreField" class="col-sm-2 control-label">Nombre</label>
						<div class="col-sm-10">
							<g:field id="nombreField" type="text" value="nombre" name="nombre" class="form-control"  />
						</div>
					</div>
					
				</div>	
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:submitButton class="btn btn-primary" name="aceptar"
							value="Filtrar" />
				</div>
			</g:form>

		</div>
		<!-- moda-content -->
	</div>
	<!-- modal-di -->
</div>
<script>
	$('#filtrarDialog').on('shown.bs.modal', function () {
    	$('#nombreField').focus();
    	//console.log("Modal visible:...."+field.text());
	})
</script>