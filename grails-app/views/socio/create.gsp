<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<title>Socio nuevo</title>
</head>
<body>

	<content tag="header">
		<h3>Nuevo  socio</h3>
	</content>
	<content tag="form">
		
		<div class="row">
		
		
		<ul class="nav nav-tabs ">
			<li class="active"><a href="#generales" role="tab" data-toggle="tab">Generales</a></li>
			<li><a href="#facturacion" role="tab" data-toggle="tab">Facturación</a></li>
		</ul>
		<br/>
		<g:form class="form-horizontal" action="save" >
			
			<g:hasErrors bean="${socioInstance}">
				<div class="alert alert-danger">
					<g:renderErrors bean="${socioInstance}" as="list" />
				</div>
			</g:hasErrors>
			
			<div class="tab-content">
			
				<div class="tab-pane active" id="generales">
					 <fieldset>

			<f:with bean="${socioInstance}">
				<f:field property="apellidoPaterno" input-required input-autocomplete="off"
				input-class="form-control uppercase-field" cols="col-md-8"/>
				<f:field property="apellidoMaterno" input-required input-autocomplete="off"
				input-class="form-control uppercase-field" cols="col-md-8"/>
				<f:field property="nombres" input-required input-autocomplete="off"
				input-class="form-control uppercase-field" cols="col-md-8"/>
				<f:field property="sexo" input-required input-class="form-control" cols="col-md-5"/>
				<g:render template="/_common/direccionForm" />
				<fieldset>
					<legend>Teléfonos y Correos</legend>
					<f:field property="telefonoCasa" input-class="form-control" label="Casa" cols="col-md-6"/>
					<f:field property="telefonoTrabajo" input-class="form-control" label="Trabajo" cols="col-md-6"/>
					<f:field property="celular" input-class="form-control" label="Celular" cols="col-md-6"/>
					<f:field property="email" input-class="form-control " cols="col-md-6"/>
					<f:field property="email2" input-class="form-control " cols="col-md-6"/>
				</fieldset>
			</f:with>
				</div>
				<div class="tab-pane" id="facturacion">
					 <fieldset>
					
					<div class="form-group">
						<label for="cliente" class="col-sm-2 control-label">Cliente existente</label>
						<g:hiddenField id="clienteId" name="socio.cliente.id" />
						<div class="col-sm-6">
							<input id="cliente" name="cliente.nombre"  
							autocomplete="off" type="text" class="form-control" 
							placeholder="Seleccionar cliente"
							disabled>

						</div>
						<input id="seleccionarCliente" type="checkbox" name="clienteExistente" autocomplete="off" > Seleccionar
					</div>
					<f:field property="cliente.rfc" input-class="form-control " cols="col-md-6"/>
					<f:field property="cfdiEmail" input-class="form-control " cols="col-md-6"/>
					
					</fieldset>
					<g:render template="domicilioFiscal"/>
				</div>
					
			</div>
			
			
			
			</fieldset>
			
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:submitButton name="Salvar" class="btn btn-primary " />
				</div>
			</div>
			
		</g:form>

		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#seleccionarCliente').on('change', function() {

				  	if ($(this).is(':checked') == true){
				  	    $('#cliente')
				  	    .prop('disabled', false)
				  	    .attr('required','required');
				  	    
				  	     console.log('checked');
				  	} else {
				  	    $('#cliente')
				  	    .val(null)
				  	    .prop('disabled', true)
				  	    .removeAttr('required','required');
				  	     console.log('unchecked');
				  	     $('#clienteId')
				  	    .val(null);
				  	}
				});
				$("[name='cliente.nombre']").autocomplete({
					source:'/kio-core/cliente/getClientesJSON',
					minLength:3,
					select:function(e,ui){
						console.log('Cliente seleccionado: '+ui.item.value);
						$("[name='cliente.id']").val(ui.item.id);
						$("[name='cliente.nombre']").val(ui.item.nombre);
						//copiarDireccion(ui.item.direccion);
					}
				});

				// var copiarDireccion=function(direccion){
				// 	console.log('Copiando datos de direcci')
				// 	$("[name='direccion.calle']").val(direccion.calle);
				//   	$("[name='direccion.numeroExterior']").val(direccion.numeroExterior);
				//   	$("[name='direccion.numeroInterior']").val(direccion.numeroInterior);
				//   	$("[name='direccion.colonia']").val(direccion.colonia);
				//   	$("[name='direccion.delegacion']").val(direccion.delegacion);
				//   	$("[name='direccion.municipio']").val(direccion.municipio);
				//   	$("[name='direccion.estado']").val(direccion.estado);
				//   	$("[name='direccion.pais']").val(direccion.pais);
				//   	$("[name='direccion.codigoPostal']").val(direccion.codigoPostal);
				// };
			});
		</script>
	</content>

</body>
</html>