<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nota: ${notaDeCreditoInstance.id}</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2> 
						Nota de credito ${notaDeCreditoInstance.id} - ${notaDeCreditoInstance.cliente}
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			
			<div class="col-md-2">
				<div class="list-group">
					<g:link class="list-group-item" action='index'> 
						<i class="fa fa-bars"></i>&nbsp;Notas
					</g:link>
					<g:if test="${!notaDeCreditoInstance.cfdi}">
						
						<g:link class="list-group-item" 
							action="mandarTimbrar" id="${notaDeCreditoInstance.id}" 
							onclick="return confirm('Timbrar nota?');">
							Timbarar
						</g:link>
	
					</g:if>
					<g:link class="list-group-item" action='edit' id="${notaDeCreditoInstance.id}"> 
							<i class="fa fa-bars"></i>&nbsp;Editar
						</g:link>

				</div>
			</div>

			<div class="col-md-6">
				<g:hasErrors bean="${notaDeCreditoInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${notaDeCreditoInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " >
					<fieldset disabled>
					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-10">
							<input  id="fecha" name="fecha" type="text" class="form-control" type="text"
							  autocomplete="off"
							  value="${notaDeCreditoInstance?.fecha?.format('dd/MM/yyyy')}">
						</div>
					</div>
					<f:with bean="${notaDeCreditoInstance}">

						<f:field property="tipo" input-class="form-control" />
						<f:field property="comentario" input-class="form-control" />
					</f:with>
					
					</fieldset>
				</g:form>
			</div><!-- end .col-md-6 -->

			<div class="col-md-4">
				<div class="table-panel">
					<table class="table table-striped table-bordered table-condensed">
						<tbody>
							<tr>
								<td>Importe</td>
								<td>${notaDeCreditoInstance.subTotal}</td>
							</tr>
							<tr>
								<td>Imupesto (tasa)</td>
								<td>${notaDeCreditoInstance.impuestoTasa}</td>
							</tr>
							<tr>
								<td>Impuesto</td>
								<td>${notaDeCreditoInstance.impuesto}</td>
							</tr>
							<tr>
								<td>Total</td>
								<td>${notaDeCreditoInstance.total}</td>
							</tr>

							<tr>
								<td>Aplicado</td>
								<td>${notaDeCreditoInstance.aplicaciones.sum(0.0,{it.importe}) }</td>
							</tr>

							<tr>
								<td>Disponible</td>
								<td>${notaDeCreditoInstance.disponible}</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>

		</div><!-- end .row2 -->

		<div class="row">
			<div class="col-md-12">
					
				<div class="table-panel">
					<legend>Conceptos</legend>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>Concepto</th>
								<th>Descripcion</th>
								<th>Cantidad</th>
								<th>Valor u</th>
								<th>Importe</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${notaDeCreditoInstance.conceptos}" var="row">
								<tr>
									<td>${fieldValue(bean:row,field:"concepto")}</td>
									<td>${fieldValue(bean:row,field:"descripcion")}</td>
									<td>${formatNumber(number:row.cantidad, format:'###.##')}</td>
									<td>${formatNumber(number:row.valorUnitario, format:'###.##')}</td>
									<td>${formatNumber(number:row.importe, format:'###.##')}</td>
								</tr>
							</g:each>
						</tbody>
					</table>
					
				</div>
				
			</div>
		</div>

	</div>

	
	
</body>
</html>