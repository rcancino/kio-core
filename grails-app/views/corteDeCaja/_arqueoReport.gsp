<%@page expressionCodec="none"%>
<div class="modal fade" id="arqueoForm" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Reporte de Arqueo</h4>
			</div>

			<g:form class="form-horizontal" action="arqueo" controller="report">
				
				<div class="modal-body">
					<div class="form-group">
						<label for="mailField" class="col-sm-3 control-label">Cajero</label>
						<div class="col-sm-8">
							<p class="form-control-static"><sec:username/></p>
						</div>
					</div>

					<div class="form-group">
						<label for="ultimoPago" class="col-sm-3 control-label">Fecha</label>
						<div class="col-sm-8">
								<input name="fecha" id="fecha"
									class="form-control mayusculas" 
									type="text"
									value="${fecha.format('dd/MM/yyyy')}">
						</div>
					</div>
					
				</div>	
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:submitButton class="btn btn-primary" name="acepta"
							value="Ejecutar" />
				</div>
			</g:form>

		</div>
		<!-- moda-content -->
	</div>
	<!-- modal-di -->
</div>
<script type="text/javascript">
	$("#fecha").datepicker({
		     
		 		});
</script>
