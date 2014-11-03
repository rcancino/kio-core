<%@page expressionCodec="none"%>
<div class="modal fade" id="searchDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Busqueda avanzada</h4>
				<span class="label label-info">Puede usar el comodin %</span>
			</div>

			<g:form class="form-horizontal" action="find" >
				<div class="modal-body">
					<f:with bean="${new com.luxsoft.kio.Cliente()}">
						<f:field property="nombre" input-class="form-control uppercase-field" />
						<div class="form-group">
							<label for="rfcField" class="control-label col-sm-2"> RFC</label>
							<div class="col-sm-10">
								<input type='text' name="rfc" class="form-control"/>
							</div>
						</div>
						%{-- <f:field property="rfc" input-class="form-control uppercase-field"/> --}%
						
					</f:with>
				</div>	
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:submitButton class="btn btn-primary" name="aceptar"
							value="Buscar" />
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