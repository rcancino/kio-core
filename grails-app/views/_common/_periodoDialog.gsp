<%@page expressionCodec="none"%>
<r:require module="datepicker"/>
<!-- Modal para el alta de percepciones -->
<div class="modal fade" id="periodoDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Periodo</h4>
			</div>
			<g:form action="cambiarPeriodo" controller="home" class="form-horizontal">
				
				<f:with bean="${session.periodo}">
					<f:field property="fechaInicial" input-class="form-control" colsLabel='col-sm-4' cols='col-sm-8'/>
					<f:field property="fechaFinal" input-class="form-control" colsLabel='col-sm-4' cols='col-sm-8'/>
				</f:with>
				%{-- <div class="modal-body">
					<div class="form-group">
    					<label for="fechaIni" class="col-sm-3">Fecha inicial</label>
    					<div class="col-sm-9">
    						<input type="text" class="form-control datepicker" id="fechaIni" name="fechaInicial" 
    							value="${g.formatDate(date:periodo.fechaInicial,format:'dd/MM/yyyy') }">
    					</div>
  					</div>
  					
  					<div class="form-group">
    					<label for="fechaFin" class="col-sm-3">Fecha final</label>
    					<div class="col-sm-9" >
    						<input type="text" class="form-control datepicker" id="fechaFin" name="fechaFinal" 
    							value="${g.formatDate(date:periodo.fechaFinal,format:'dd/MM/yyyy') }">
    					</div>
  					</div>
  					
				</div> --}%
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<g:submitButton class="btn btn-primary" name="Aceptar"
							value="aceptar" />
				</div>
				
			</g:form>


		</div>
		<!-- moda-content -->
	</div>
	<!-- modal-di -->
</div>
