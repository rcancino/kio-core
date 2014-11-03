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
					<h2>Catálogo de socios</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning text-center">${flash.message}</span>
					</g:if>
				</div>
			</div>
		</div><!-- end .row 1 Header -->

		<div class="row">
			<div class="col-md-6">
				<g:form class="form-horizontal" action="show">
					<g:hiddenField name="id" />
		      		<div class="input-group">
		      		    <span class="input-group-addon">Buscar</span>
		      		    <input id="nombreField" name="term" type="text" 
				    	    class="form-control " placeholder="Nombre"
				    		autofocus="autofocus" autocomplete="off">
	      		    	<span class="input-group-btn">
	      		       		<button type="submit" class="btn btn-default">
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
					    <li>
					    	<a href="#filtrarDialog" data-toggle="modal" >
					    		<span class="glyphicon glyphicon-filter"></span> Filtrar
					    	</a>
					    </li>
					    <li>
					    	<a href="#searchDialog" data-toggle="modal" >
					    		<span class="glyphicon glyphicon-find"></span> Busqueda avanzada
					    	</a>
					    </li>
					    <li>
					    	<g:link action="importar" onclick="return confirm('Importar socios de SIIPAP');">
								<span class="glyphicon glyphicon-import"></span> Importar
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
						<li><a href="#">Pendiente 1</a></li>
					    <li><a href="#">Pendiente 2</a></li>
					    <li class="divider"></li>
					    <li><a href="#">Pendiente 3</a></li>
					</ul>
				</div>
				</div>
			</div>
					
			<g:render template="filterDialog"/>	
			<g:render template="searchDialog"/>	
		</div> <!-- end .row 2 toolbar -->

		<div class="row">
			<div class="col-md-12">
				<div class="grid-panel">
					<g:render template="grid"/>
				</div>
			</div>
		</div>
	

	</div><!-- End .container-->
	<script type="text/javascript">
		$(function(){
			$("#nombreField").autocomplete({
				source:'/kio-core/socio/getSociosJSON',
				minLength:3,
				select:function(e,ui){
					console.log('Valor seleccionado: '+ui.item.id);
					$("#nombreField").val(ui.item.id);
					$("#id").val(ui.item.id);
				}
			});
			
		});
	</script>
</body>
</html>