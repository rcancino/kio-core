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
				<div class="row">
					
				
				<div class="col-md-6">
					<f:field property="apellidoPaterno" 
						input-required input-autocomplete="off"
						input-class="form-control uppercase-field" 
						colsLabel="col-sm-4" cols="col-sm-8"/>
					<f:field property="apellidoMaterno" input-required input-autocomplete="off"
						input-class="form-control uppercase-field" 
						colsLabel="col-sm-4" cols="col-sm-8"/>	
					
				</div>
				<div class="col-md-6">
					<f:field property="nombres" input-required input-autocomplete="off"
						input-class="form-control uppercase-field" 
						colsLabel="col-sm-4" cols="col-sm-8"/>
					<f:field property="sexo" input-required input-class="form-control" 
					colsLabel="col-sm-4" cols="col-sm-8"/>
				</div>
				</div>
				
				
				<g:render template="/_common/direccionForm" />
				<fieldset>
					<legend>Teléfonos y Correos</legend>
					<div class="col-md-6">
						<f:field property="telefonoCasa" input-class="form-control" label="Casa" colsLabel="col-sm-4" cols="col-sm-8"/>
						<f:field property="celular" input-class="form-control" label="Celular" colsLabel="col-sm-4" cols="col-sm-8"/>
					</div>
					<div class="col-md-6">
						<f:field property="telefonoTrabajo" input-class="form-control" label="Trabajo" colsLabel="col-sm-4" cols="col-sm-8"/>
						<f:field property="email" input-class="form-control " colsLabel="col-sm-4" cols="col-sm-8"/>
						<f:field property="email2" input-class="form-control " colsLabel="col-sm-4" cols="col-sm-8"/>
					</div>
				</fieldset>
				
				<fieldset>
					<div class="col-md-6">
						<legend>Perfil</legend>
						<f:field property="perfil.tipoDeSocio" 
						input-class="form-control"
						input-type="text"
						colsLabel="col-md-4" cols="col-md-8"/>

					<f:field property="perfil.tipoDeCorporativo" 
						input-class="form-control"
						colsLabel="col-md-4" cols="col-md-8" label="Corporativo"/>

					<f:field property="perfil.medioDeContacto" 
						input-class="form-control"
						colsLabel="col-md-4" cols="col-md-8"/>

					</div>
					
					<div class="col-md-6">
						<legend>Membresía</legend>
						<g:select class="form-control"  
							name="membresia.servicio" 
							value="${socioInstance.membresia?.servicio?.id}"
							from="${com.luxsoft.kio.Producto.findAll{tipo.clave=='MEMBRESIA'}}" 
							noSelection="${['null':'Seleccione una membresia']}"
							optionKey="id" 
							optionValue="descripcion"
							/>
					</div>
					
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
					<f:field property="cliente.rfc" input-class="form-control " 
						cols="col-md-4" 
						default="XAXX010101000" 
						required="required" />
					<f:field property="cfdiEmail" input-class="form-control " cols="col-md-4"/>
					<div class="form-group">
						<div class="col-md-2 col-md-offset-2">
							<button  id="copiarDireccionDelSocio" class="btn btn-default">Copiar domicilio</button>
						</div>
						
					</div>
					
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

				$("#copiarDireccionDelSocio").click(function(event){
					copiarDireccion();
					event.preventDefault();
					
				});

				var copiarDireccion=function(){

					console.log('Copiando datos de direcci')
				 	
				 	$("[name='cliente.direccion.calle']").val($("[name='direccion.calle']").val());
				   	$("[name='cliente.direccion.numeroExterior']").val($("[name='direccion.numeroExterior']").val());
				   	$("[name='cliente.direccion.numeroInterior']").val($("[name='direccion.numeroInterior']").val());
				   	$("[name='cliente.direccion.colonia']").val($("[name='direccion.colonia']").val());
				   	$("[name='cliente.direccion.delegacion']").val($("[name='direccion.delegacion']").val());
				   	$("[name='cliente.direccion.municipio']").val($("[name='direccion.municipio']").val());
				   	$("[name='cliente.direccion.estado']").val($("[name='direccion.estado']").val());
				   	$("[name='cliente.direccion.pais']").val($("[name='direccion.pais']").val());
				   	$("[name='cliente.direccion.codigoPostal']").val($("[name='direccion.codigoPostal']").val());

				 };

			});
		</script>
	</content>

</body>
</html>