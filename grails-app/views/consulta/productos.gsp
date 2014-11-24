<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	%{-- <meta name="layout" content="catalogos"/> --}%
	<title>Productos</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h4 class="text-center">Consutla rápida de Productos</h4>
					<g:if test="${flash.message}">
						<span class="label label-warning text-center">${flash.message}</span>
					</g:if>
				</div>
			</div>
		</div><!-- end .row 1 Header -->

		<div class="row">
			<div class="col-md-6">
				<g:form class="form-horizontal" action="showSocio">
					<g:hiddenField name="id" />
		      		<div class="input-group">
		      		    <span class="input-group-addon">Buscar</span>
		      		    <input id="nombreField" name="term" type="text" 
				    	    class="form-control " placeholder="Nombre"
				    		autofocus="autofocus" autocomplete="off">
	      		    	<span class="input-group-btn">
	      		       		<button id="buscarBtn" type="submit" class="btn btn-default" disabled="disabled">
	      						<span class="glyphicon glyphicon-search"></span>
	      					</button> 
	      		      	</span>
		      		</div><!-- /input-group -->
	      		</g:form>
			</div>	<!-- end .col-md-6-->
			

			<div class="col-md-6">
				<div class="btn-toolbar">
					
				
				<div class="btn-group">
					<g:link action="index" class="btn btn-default">
						<span class="glyphicon glyphicon-repeat"></span> Refrescar
					</g:link>
					
					
				</div>
				
				<div class="btn-group">
					<button type="button" name="reportes"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							role="menu">
							Reportes <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">General</a></li>
						<li><a href="#">Bitácora</a></li>
					</ul>
				</div>
				</div>
			</div>
					
			%{-- <g:render template="filterDialog"/>	
			<g:render template="searchDialog"/>	 --}%
		</div> <!-- end .row 2 toolbar -->

		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<g:sortableColumn property="id" title="Id"/>
							<g:sortableColumn property="clave" title="Clave"/>
							<g:sortableColumn property="descripcion" title="Descripcion"/>
							<th>Tipo</th>
							<th>Estatus</th>
							<th>Modificado</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${productoInstanceList}" var="row">
							<tr class="${ row.suspendido?'danger':'' }">
								<td>
									<g:link action="showProducto" id="${row.id}">
										${fieldValue(bean:row,field:"id")}
									</g:link>
								</td>
								<td>${fieldValue(bean:row,field:"clave")}</td>
								<td>${fieldValue(bean:row,field:"descripcion")}</td>
								<td>${fieldValue(bean:row,field:"tipo.clave")}</td>
								<td>${row.suspendido?'SUSPENDIDO':'ACTIVO'}</td>
								<td><g:formatDate date="${row.lastUpdated}"/></td>
							</tr>
						</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${productoInstanceCount ?: 0}"/>
				</div>
				
			</div>
		</div>
	

	</div><!-- End .container-->
	<script type="text/javascript">
		$(function(){
			$("#nombreField").autocomplete({
				source:'<g:createLink controller="producto" action="getProductosAsJSON"/>',
				minLength:3,
				select:function(e,ui){
					console.log('Valor seleccionado: '+ui.item.id);
					$("#nombreField").val(ui.item.id);
					$("#id").val(ui.item.id);
					var button=$("#buscarBtn");
	    			button.removeAttr('disabled');
				}
			});
			
			
		});
	</script>
</body>
</html>