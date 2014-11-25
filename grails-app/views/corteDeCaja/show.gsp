<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Corte ${corteDeCajaInstance.id}</title>
	
	<asset:javascript src="forms/autoNumeric.js"/>
	<meta name="layout" content="application"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2> 
						${corteDeCajaInstance.id} 
						<g:formatDate date="${corteDeCajaInstance.fechaHora}" format="dd/MM/yyyy HH:mm"/>
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			
			<div class="col-md-3">
				<div class="list-group">
					<g:link class="list-group-item" action='index'> 
						<i class="fa fa-bars"></i>&nbsp;Cortes</g:link>
				</div>
			</div>

			<div class="col-md-9">
				<g:hasErrors bean="${corteDeCajaInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${corteDeCajaInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="save" name="corteForm" >

					
					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-8">
							<p class="form-control-static">
								<strong>
									<g:formatDate date="${corteDeCajaInstance.fechaHora}" format="dd/MM/yyyy HH:mm"/>
								</strong>
							</p>
							<g:hiddenField  name="fechaHora" 
							  value="${corteDeCajaInstance?.fechaHora?.format('dd/MM/yyyy HH:mm')}"/>
						</div>
					</div>

					<div class="form-group">
						<label for="cajero" class="col-sm-2 control-label">Cajero</label>
						<div class="col-sm-8">
							<p class="form-control-static">
								<strong>
									<g:fieldValue bean="${corteDeCajaInstance}" field="cajero"/>
								</strong>
							</p>
							<g:hiddenField  name="cajero" value="${corteDeCajaInstance.cajero}"/>
						</div>
					</div>
			  		<div class="form-panel">
				  		<table class="table table-striped table-bordered table-condensed">
				  			<thead>
				  				<tr>
				  					<th>Tipo</th>
				  					<th>Acumulado</th>
				  					<th>Corte</th>
				  					<th>Cobrado</th>
				  					<th>Aplicar</th>
				  				</tr>
				  			</thead>
				  			<tbody>
				  				<g:each in="${partidas}" var="row" status="i">
				  					<tr>
				  						<td>
				  							${row.formaDePago}
				  						</td>
				  						<td>${row.acumulado}</td>
				  						<td>${row.importeCorte}</td>
				  						<td>${row.cobrado}</td>
				  						<td><g:checkBox name="registros" value="${row.formaDePago}" checked="true"/></td>
				  					</tr>
				  				</g:each>
				  			</tbody>
				  		</table>
			  		</div>
					

					<div class="form-group">
						<label for="cajero" class="col-sm-2 control-label">Total</label>
						<div class="col-sm-8">
							<p class="form-control-static">
								<strong>
									<g:formatNumber number="${corteDeCajaInstance.total}" type="currency"/>
								</strong>
							</p>
							<g:hiddenField  name="total" value="${corteDeCajaInstance.total}"/>
						</div>
					</div>
					
			  		

					
				</g:form>
			</div>

		</div><!-- end .row2 -->

	</div>

	<script type="text/javascript">
		
	</script>	
	
</body>
</html>