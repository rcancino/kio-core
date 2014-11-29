<!DOCTYPE html>
<html>
	<head>
		
		<title>Sesiones</title>
		<asset:stylesheet src="datatables/datatables.css"/>
		<asset:javascript src="datatables/datatables.js"/>
		<asset:stylesheet src="jquery-ui.css"/>
		<asset:javascript src="jquery-ui/autocomplete.js"/>
	</head>
	
	<body>
		<div class="container">
			
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-warning">
						<h2>Usuarios conectados</h2>
						<g:if test="${flash.message}">
							<span class="label label-warning text-center">${flash.message}</span>
						</g:if>
					</div>

				</div>
				

			</div><!-- end .row 1 -->
			
			<div class="row">
				<div class="col-md-12">
					<div class="toolbar-panel">
						<div class="btn-group">
							<input type='text' id="nombre" placeholder="Buscar" class="form-control">
						</div>
						
						
						<div class="btn-group">
							<g:link action="index" class="btn btn-default">
								<span class="glyphicon glyphicon-repeat"></span> Refrescar
							</g:link>
							
							
							
						</div>
						<div class="btn-group">
							<button type="button" name="operaciones"
									class="btn btn-default dropdown-toggle" data-toggle="dropdown"
									role="menu">
									Operaciones <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								
							</ul>
						</div>
						<div class="btn-group">
							<button type="button" name="reportes"
									class="btn btn-default dropdown-toggle" data-toggle="dropdown"
									role="menu">
									Reportes <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><g:link controller="reporte" action="usuariosDelSistema"> Bitácora</g:link></li>
							    
							</ul>
						</div>
						
					</div>
					
				</div>
			</div><!-- end .row 2 button panel -->

			<div class="row">
				<div class="col-md-12">
					
					<table id="usuariosGrid" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>Usuario</th>
								<th>Login</th>
								<th>Tipo</th>
								<th>IP</th>
								<th>Http Session</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${luxorSessionList}" var="row">
								<tr>
									<td>${row.usuario}</td>
									<td><g:formatDate date="${row.login}" format="dd-MM HH:mm"/></td>
									<td>${row.tipo}</td>
									<td>${row.ip}</td>
									<td>${row.session}</td>
									<td><g:formatDate date="${row.dateCreated}" format="dd-MM HH:mm"/></td>
									
									
								</tr>
							</g:each>
						</tbody>
					</table>
					<div class="pagination">
						<g:paginate total="${cfdiInstanceCount ?: 0}" />
					</div>


				</div>
			</div>

			
			
		</div>
	
	<script type="text/javascript">
		$(function(){
			var table=$("#cfdiGrid").dataTable({
		        "paging":   false,
		        "ordering": false,
		        "info":     false,
		         "dom":'t'
				});
				
				$("#nombre").keyup(function(){
  					table.DataTable().search( $(this).val() ).draw();
				});
				
				
		});

	</script>
		
	</body>
	
</html>
