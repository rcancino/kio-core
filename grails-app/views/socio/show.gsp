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
				
				<g:form class="form-horizontal" action="" >
					
					<div class="tab-content">

						<div class="tab-pane active" id="generales">
							<fieldset disabled>
								<g:render template="datosGeneralesForm" model="['socioInstance':socioInstance]"/>
							</fieldset>
					 	</div>
					 	<div class="tab-pane" id="facturacion">
					 		
					 		<fieldset disabled>
								<g:render template="datosDeFacturacionForm" />
							</fieldset>
					 	</div>
					 	<div class="tab-pane" id="perfil">
					 		<fieldset disabled>
								<g:render template="perfilForm" />
							</fieldset>
					 	</div>
					 	<div class="tab-pane" id="membresia">
					 		<fieldset disabled>
								<g:render template="membresia" />
							</fieldset>
					 		
					 	</div>
					</div>

					<div class="form-group">
						<div class="buttons col-md-offset-2 col-md-6">
							
							<g:link class="btn btn-default " action="index" >
								<span class="glyphicon glyphicon-arrow-left"></span> 
								Catálogo
							</g:link>
							
							<g:if test="${socioInstance.activo}">
								<g:link class="btn btn-primary" 
									action="edit" id="${socioInstance.id}">
									<span class="glyphicon glyphicon-penciel"></span> Editar
								</g:link>
							</g:if>
							
							
						</div>
						
					</div>

				</g:form>
				
			</div>
			
			
			
		</div>
	
	</div>
	

</body>
</html>