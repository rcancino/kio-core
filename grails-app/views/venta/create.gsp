<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nueva venta</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>

<content tag="header">
	Alta de pedido nuevo
</content>

<content tag="info">
	
</content>

<content tag="body">
	
	<g:hasErrors bean="${ventaInstance}">
		<div class="aler alert-danger">
			<g:renderErrors bean="${ventaInstance}" as="list" />
		</div>
	</g:hasErrors>

	<div class="row">
		<div class="col-md-12">
			
	<g:form name="createForm" action="save" class="form-horizontal">
		
		<div class="form-group ">
			<label for="socio" class="col-sm-2 control-label">Socio</label>
			<div class="col-sm-8 ">
				<g:hiddenField id="socioId" name="socio.id"/>
				<input id="socio" name="socio.nombre" type="text" 
					class="form-control" placeholder="Seleccione un socio" autofocus="on" autocomplete="off">
			</div>
		</div>
		
		<div class="form-group ${hasErrors(bean:ventaInstance,field:'cliente', 'has-error')}">
			<label for="cliente" class="col-sm-2 control-label">Cliente</label>
			<div class="col-sm-8">
				<g:hiddenField id="clienteId" name="cliente.id" value="${ventaInstance?.cliente?.id}"/>
				<input id="cliente" name="cliente.nombre" type="text" class="form-control"
				 autocomplete="off">
			</div>
		</div>

		<div class="form-group">
			<label for="tipo" class="col-sm-2 control-label">Tipo</label>
			<div class="col-sm-4">
				<f:input bean="${ventaInstance}" property="tipo" class="form-control" input-readonly="readonly"/>
			</div>

		</div>

		<div class="form-group">
			<label for="fecha" class="col-sm-2 control-label">Fecha</label>
			<div class="col-sm-4">
				<input id="fecha" 
					type="text"  
					value="${g.formatDate(date:ventaInstance.fecha,format:'dd/MM/yyyy') }"
					class="form-control" 
					disabled>
			</div>
		</div>

		%{-- <div class="form-group">
			<label for="fecha" class="col-sm-2 control-label">Comentario</label>
			<div class="col-sm-4">
				<input id="comentario" name="comentario" type="text"  
					value="${ventaInstance.comentario}"
					class="form-control" >
			</div>
		</div> --}%

		%{-- <div class="form-group">
			<div class="col-sm-offset-8 col-sm-4">
				<g:submitButton name="Salvar" class="btn btn-primary " />
			</div>
		</div> --}%
	
	</g:form>
	
		</div>
	</div>	

</content>

<content tag="footer">
	<div class="btn-group">
  							
		<g:link class="btn btn-default btn-sm" action="index" params="[tipo:'PEDIDO']">
			Cancelar
		</g:link>

		<button id="next" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-arrow-right"></span> Siguiente
		</button>
  	</div>
</content>

<content tag="js">

<script type="text/javascript">
$(document).ready(function(){
	// $("#fecha").datepicker({
	     
	//  });

	$("#socio").autocomplete({
		source:'<g:createLink controller="socio" action="getSociosJSON"/>',
		minLength:3,
		select:function(e,ui){
			console.log('Socio seleccionado: '+ui.item.value);
			$("#socioId").val(ui.item.id);
			$("#cliente").val(ui.item.cliente.nombre);
			$("#clienteId").val(ui.item.cliente.id);
			
		}
	});
	
	$("#cliente").autocomplete({
		source:'/kio-core/cliente/getClientesJSON',
		minLength:3,
		select:function(e,ui){
			console.log('Cliente seleccionado: '+ui.item.value);
			$("#clienteId").val(ui.item.id);
			$("#cliente").val(ui.item.cliente.nombre);
			$("#socioId").val(null);
			$("#socio").val(null);
			
		}
	});
	$("#next").click(function(){
		console.log('Siguiete paso');
		$("#createForm").submit();
	});
	
});
</script>

</content>	

	

</body>
</html>