<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Empresa ${empresaInstance.nombre}</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2> 
						${empresaInstance.nombre} 
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			<div class="col-md-12">
				<g:hasErrors bean="${empresaInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${empresaInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="save" name="empresaForm" >
					<div class="form-group">
						<label for="fecha" class="col-sm-3 control-label">Última modificación</label>
						<div class="col-sm-9">
							<p class="form-control-static">
								<strong>
									<g:formatDate date="${empresaInstance.lastUpdated}" format="dd/MM/yyyy HH:mm"/>
								</strong>
							</p>
							<g:hiddenField  name="lastUpdated" 
							  value="${empresaInstance?.lastUpdated?.format('dd/MM/yyyy HH:mm')}"/>
						</div>
					</div>

					%{-- <div class="form-group">
						<label for="cajero" class="col-sm-2 control-label">Cajero</label>
						<div class="col-sm-8">
							<p class="form-control-static">
								<strong>
									<g:fieldValue bean="${empresaInstance}" field="cajero"/>
								</strong>
							</p>
							<g:hiddenField  name="cajero" value="${empresaInstance.cajero}"/>
						</div>
					</div> --}%
			  		

					
				</g:form>
			</div>

		</div><!-- end .row2 -->

	</div>

	<script type="text/javascript">
		
	</script>	
	
</body>
</html>