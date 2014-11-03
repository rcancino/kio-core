<%@page expressionCodec="none"%>
<div class="modal fade" id="searchDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Busqueda avanzada</h4>
			</div>

			<g:form class="form-horizontal" action="find" >
				<div class="modal-body">
					<f:with bean="${new com.luxsoft.kio.Socio()}">
						<f:field property="apellidoPaterno" input-class="form-control uppercase-field" 
						colsLabel="col-md-4" cols="col-md-8"/>
						<f:field property="apellidoMaterno" input-class="form-control uppercase-field" 
						colsLabel="col-md-4" cols="col-md-8"/>
						<f:field property="nombres" input-class="form-control uppercase-field" 
						colsLabel="col-md-4" cols="col-md-8"/>
						<f:field property="numeroDeSocio" input-class="form-control" 
						colsLabel="col-md-4" cols="col-md-8"/>
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