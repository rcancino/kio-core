<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos"/>
	<title>Clientes</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>
	<content tag="header">
		<h3>Catálogo de Clientes</h3>
	</content>
	<content tag="toolbar">

	<div class="col-md-12 toolbar-panel">
		
		<div class="btn-group">
			<g:link action="index" class="btn btn-default ">
				<span class="glyphicon glyphicon-repeat"></span> Refrescar
			</g:link>
			<g:link action="create" class="btn btn-default">
				<span class="glyphicon glyphicon-floppy-saved"></span> Alta
			</g:link>
			<g:link action="importar" class="btn btn-default">
				<span class="glyphicon glyphicon-import"></span> Importar
			</g:link>
		</div>

		<div class="btn-group">
			<g:form class="form-inline" action="edit" >
				<div class="form-group">
					<div class="input-group ">
						<div class="input-group-addon"><span class="glyphicon glyphicon-search"></span></div>
						<g:hiddenField id="clienteId" name="id"/>
						<input id="cliente" name="term" type="text" class="form-control" placeholder="Buscar" 
						autofocus="autofocus" autocomplete="off">
					</div>
					
				</div>
				
			</g:form>
		</div>
	
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#cliente").autocomplete({
				source:'/kio-core/cliente/getClientesJSON',
				minLength:3,
				select:function(e,ui){
					console.log('Valor seleccionado: '+ui.item.id);
					$("#clienteId").val(ui.item.id);
				}
			});
		});
	</script>

	</content>
</body>
</html>