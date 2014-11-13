<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="holder/holder.js"/>
	<title>Socio ${socioInstance.numeroDeSocio}</title>
</head>
<body>

	<div class="container">
		
		<div class="row">
			<div class="col-md-12">
				<div class="well">
					<h3>${socioInstance} (${socioInstance.numeroDeSocio})  ${socioInstance.activo?'Activo':''}
						<g:if test="${!socioInstance.activo}">
                    		<span class="label label-danger"><strong>SUSPENDIDO</strong></span>
                		</g:if> 
					</h3>
					
					<g:if test="${flash.message}">
                    	<span class="label label-warning">${flash.message}</span>
                	</g:if> 
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				
				<ul class="nav nav-tabs ">
					<li class="active"><a href="#generales" role="tab" data-toggle="tab">Generales</a></li>
					<li><a href="#facturacion" role="tab" data-toggle="tab">Facturación</a></li>
					<li><a href="#perfil" role="tab" data-toggle="tab">Perfil</a></li>
					<li><a href="#membresia" role="tab" data-toggle="tab">Membresia</a></li>
				</ul>
				
				<g:form class="form-horizontal" action="update" >
					
					<g:hiddenField name="id" value="${socioInstance.id}"/>
					<g:hiddenField name="version" value="${socioInstance.version}"/>

					<g:hasErrors bean="${socioInstance}">
						<div class="alert alert-danger">
							<g:renderErrors bean="${socioInstance}" as="list" />
						</div>
					</g:hasErrors>
					
					<div class="tab-content">
						<div class="tab-pane active" id="generales">
					 		<g:render template="datosGeneralesForm" model="['socioInstance':socioInstance]"/>
					 	</div>
					 	<div class="tab-pane" id="facturacion">
					 		%{-- <g:render template="datosDeFacturacionForm" /> --}%
					 	</div>
					 	<div class="tab-pane" id="perfil">
					 		<g:render template="perfilForm" />
					 	</div>
					 	<div class="tab-pane" id="membresia">
					 		<g:render template="membresia" />
					 	</div>
					</div>

					<div class="form-group">
						<div class="buttons col-md-offset-2 col-md-6">
							
							<g:link class="btn btn-default " action="index" >
								<span class="glyphicon glyphicon-arrow-left"></span> 
								Catálogo
							</g:link>

							<g:submitButton name="Salvar" class="btn btn-primary " />
							
							
							<g:link class="btn btn-danger " 
								action="delete" id="${socioInstance.id}" 
								onclick="return confirm('Eliminar el socio');">
								<span class="glyphicon glyphicon-trash"></span> Eliminar
							</g:link>
							<g:if test="${socioInstance.activo}">
								<g:link class="btn btn-warning " 
									action="suspender" id="${socioInstance.id}" 
									onclick="return confirm('Suspender el socio ?');">
								<span class="glyphicon glyphicon-ban-circle"></span> Suspender
								</g:link>
							</g:if>
							<g:else>
								<g:link class="btn btn-success " 
									action="activar" id="${socioInstance.id}" 
									onclick="return confirm('Activar socio?');">
								<span class="glyphicon glyphicon-thumbs-up"></span> Activar
								</g:link>
							</g:else>
							
						</div>
						
					</div>

				</g:form>
				
			</div>
			
			<div class="modal fade" id="myModal" >
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>
			        <h4 class="modal-title">Selección de foto</h4>
			      </div>
			       <g:uploadForm action="cargarFoto" class="form">
			       		<div class="modal-body">
			       			<div class="form-group">
			       				<g:hiddenField name="socioId" value="${socioInstance.id}"/>
			       				<label for="fotoFile">Imagen </label>
			       				<input type="file" id="fotoFile" name="foto" accept=".gif,.jpg,.jpeg,.png">
			       				<p class="help-block">Seleccione una imagen del sistema operativo.</p>
			       			</div>
			       		</div>
			       		<div class="modal-footer">
			       		  <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			       		  <button type="submit" class="btn btn-primary">Aceptar</button>
			       		</div>
					</g:uploadForm>
			      
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			

			<g:render template="tarjetaDialog"/>	

			
		</div>
	
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('#copiarDireccion').on('click', function(event) {
			event.preventDefault();
		  	console.log('Copiando direccion del socio al cliente');
		  	$("[name='cliente.direccion.calle']").val($("[name='direccion.calle']").val());
		  	$("[name='cliente.direccion.numeroExterior']").val($("[name='direccion.numeroExterior']").val());
		  	$("[name='cliente.direccion.numeroInterior']").val($("[name='direccion.numeroInterior']").val());
		  	$("[name='cliente.direccion.colonia']").val($("[name='direccion.colonia']").val());
		  	$("[name='cliente.direccion.delegacion']").val($("[name='direccion.delegacion']").val());
		  	$("[name='cliente.direccion.municipio']").val($("[name='direccion.municipio']").val());
		  	$("[name='cliente.direccion.estado']").val($("[name='direccion.estado']").val());
		  	$("[name='cliente.direccion.pais']").val($("[name='direccion.pais']").val());
		  	$("[name='cliente.direccion.codigoPostal']").val($("[name='direccion.codigoPostal']").val());
		});

		var copiarDireccion=function(direccion){
			$("[name='cliente.direccion.calle']").val(direccion.calle);
		  	$("[name='cliente.direccion.numeroExterior']").val(direccion.numeroExterior);
		  	$("[name='cliente.direccion.numeroInterior']").val(direccion.numeroInterior);
		  	$("[name='cliente.direccion.colonia']").val(direccion.colonia);
		  	$("[name='cliente.direccion.delegacion']").val(direccion.delegacion);
		  	$("[name='cliente.direccion.municipio']").val(direccion.municipio);
		  	$("[name='cliente.direccion.estado']").val(direccion.estado);
		  	$("[name='cliente.direccion.pais']").val(direccion.pais);
		  	$("[name='cliente.direccion.codigoPostal']").val(direccion.codigoPostal);
		};

		var desactivarDireccion=function(valor){

		};

		$("[name='cliente.nombre']").autocomplete({
			source:'/kio-core/cliente/getClientesJSON',
			minLength:3,
			select:function(e,ui){
				console.log('Cliente seleccionado: '+ui.item.value);
				
				$("[name='cliente.nombre']").val(ui.item.nombre);
				$("#clienteId").val(ui.item.id);
				$("[name='cliente.id']").val(ui.item.id);
				//copiarDireccion(ui.item.direccion);
			}
		});

		$('.mayusculas').keyup(function(){
    		this.value = this.value.toUpperCase();
		});
	});
</script>	

</body>
</html>