<%@page expressionCodec="none"%>
<div class="modal fade" id="cobranzaDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Cobranza</h4>
			</div>

			%{-- <div class="modal-body">

				<g:jasperReport
	          		jasper="Cobranza"
	          		format="PDF"
	          		name="Cobranza del dia">
	    			Fecha: <input type="text" name="fecha" value="${(new Date()).format('dd/MM/yyyy')}"/>
				  </g:jasperReport>
				
				
			</div>	 --}%

			

			<g:form class="form-horizontal" controller="report" action="cobranza" >
				<g:hiddenField name="reportName" value="Cobranza"/>
				<div class="modal-body">

					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-10">
							<g:field  type="text" name="fecha" class="form-control dateField"  
							value="${(new Date()).format('dd/MM/yyyy')}"/>
						</div>
					</div>
					
					
				</div>	
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:submitButton class="btn btn-primary" name="aceptar"
							value="Ejecutar" />
				</div>
			</g:form>

		</div>
		<!-- moda-content -->
	</div>
	<!-- modal-di -->

</div>

