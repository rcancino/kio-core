<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	%{-- <meta name="layout" content="catalogos"/> --}%
	<title>Socios</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h4 class="text-center">Consulta rápida de Socios</h4>
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
					<button type="button" name="operaciones"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							role="menu">
							Operaciones <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
					    	<g:link action="create" class="">
								<span class="glyphicon glyphicon-plus"></span> Nuevo socio
							</g:link>
						</li>
					</ul>
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
				<div class="grid-panel">
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<g:sortableColumn property="id" title="No Socio"/>
								<g:sortableColumn property="apellidoPaterno" title="Nombre"/>
								<th>Servicio</th>
								<th>Vencimiento</th>
								<th>Corporativo</th>
								<th>Area</th>
								<th>Activo</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${socioInstanceList}" var="row">
								<tr class="${row.activo?'':'danger'}">
									
									<td>
										<g:link action="showSocio" id="${row.id}">
											${fieldValue(bean:row,field:"numeroDeSocio")}
										</g:link>
									</td>
									<td>
										<g:link action="showSocio" id="${row.id}">
											${row.toString()}
										</g:link>
										
									</td>
									<td>
										<g:link controller="producto" action="show" id="${row.membresia?.servicio?.id}">
											${org.apache.commons.lang.StringUtils.substring(row.membresia?.servicio?.descripcion,0,50)}
											
										</g:link>
									</td>
									<td>${fieldValue(bean:row,field:"membresia.proximoPago")}</td>
									<td>${fieldValue(bean:row,field:"perfil.tipoDeCorporativo")}</td>
									<td>${fieldValue(bean:row,field:"perfil.areaDeInteres")}</td>
									<td class="text-center">
										<g:checkBox name="myCheckbox" value="${row.activo}" disabled="true"/>
									</td>
									
								</tr>
							</g:each>
						</tbody>
					</table>
					<div class="pagination">
						<g:paginate total="${socioInstanceCount ?: 0}"/>
					</div>
				</div>
			</div>
		</div>
	

	</div><!-- End .container-->
	<script type="text/javascript">
		$(function(){
			$("#nombreField").autocomplete({
				source:'<g:createLink controller="socio" action="getSociosJSON"/>',
				minLength:3,
				select:function(e,ui){
					console.log('Valor seleccionado: '+ui.item.id);
					$("#nombreField").val(ui.item.id);
					$("#id").val(ui.item.id);
					var button=$("#buscarBtn");
	    			button.removeAttr('disabled');
				}
			});
			$("#id").change(function(e){
				console.log('Detectando id...');
			});
			
		});
	</script>
</body>
</html>