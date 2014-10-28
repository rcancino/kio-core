<%@page expressionCodec="none"%>
<div class="modal fade" id="cambioDeTarjetaForm" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Actualizar tarjeta de acceso</h4>
			</div>

			<g:form class="form-horizontal" action="actualizarTarjeta" id="${socioInstance.id}">
				<div class="modal-body">
					<div class="form-group">
						<label for="tarjetaField" class="col-sm-2 control-label">Número</label>
						<div class="col-sm-10">
							<g:field id="tarjetaField" value="${socioInstance.tarjeta}" type="text" name="tarjeta" class="form-control" autocomplete="off"/>
						</div>
					</div>
					
				</div>	
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:submitButton class="btn btn-primary" name="aceptar"
							value="Aceptar" />
				</div>
			</g:form>

		</div>
		<!-- moda-content -->
	</div>
	<!-- modal-di -->
</div>
