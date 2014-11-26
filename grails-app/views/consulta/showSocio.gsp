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
			
			<div class="col-md-6">
				<div class="ro">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Generales  <span id="direccionInfo"></span></h3>
					  </div>
					  <div class="panel-body">
					  		<div class="row">
					  			<div class="col-sm-12">
					  				<g:form name="direccionForm" 
					  					action="actualizarDireccion" 
					  					class="form-horizontal"
					  					id="${socioInstance.id}">
					  				<fieldset>
					  					<legend>Dirección </legend>
					  					<div class="form-group">
					  						<label for="calle" class="col-sm-2 control-label">Calle </label>
					  						<div class="col-sm-10">
					  							<input name="direccion.calle" 
					  								value="${socioInstance?.direccion?.calle}"
					  								class="form-control mayusculas" 
					  								placeholder="Calle">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  						<label for="numeroExterior" class="col-sm-2 control-label"># Ext</label>
					  						<div class="col-sm-4">
					  							<input name="direccion.numeroExterior"
					  								class="form-control mayusculas"  
					  								value="${socioInstance?.direccion?.numeroExterior}"
					  								placeholder="# exterior">
					  						</div>
					  						<label for="numeroInterior" class="col-sm-2 control-label"># Int</label>
					  						<div class="col-sm-4">
					  							<input name="direccion.numeroInterior"  
					  								class="form-control mayusculas" 
					  								value="${socioInstance?.direccion?.numeroInterior}" 
					  								placeholder="# interior">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  						<label for="colonia" class="col-sm-2 control-label">Colonia</label>
					  						<div class="col-sm-10">
					  								<input name="direccion.colonia" class="form-control mayusculas" 
					  								value="${socioInstance?.direccion?.colonia}" 
					  								placeholder="Colonia">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  						<label for="colonia" class="col-sm-2 control-label">Delegación</label>
					  						<div class="col-sm-10">
					  								<input name="direccion.municipio" class="form-control mayusculas" 
					  								value="${socioInstance?.direccion?.municipio}" 
					  								placeholder="Delegación/Municipio">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  					<label for="estado" class="col-sm-2 control-label">Estado</label>
					  						<div class="col-sm-4">
					  								<input name="direccion.estado" class="form-control mayusculas"  
					  								value="${socioInstance?.direccion?.estado}" 
					  								placeholder="Estado">
					  						</div>
					  						<label for="pais" class="col-sm-2 control-label">País</label>
					  						<div class="col-sm-4">
					  								<input name="direccion.pais" class="form-control mayusculas" 
					  								value="${socioInstance?.direccion?.pais}" 
					  								placeholder="pais">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  						<label for="codigoPostal" class="col-sm-2 control-label">C.P.</label>
					  						<div class="col-sm-4">
					  								<input name="direccion.codigoPostal" class="form-control mayusculas"  
					  								value="${socioInstance?.direccion?.codigoPostal}" 
					  								placeholder="# Código postal">
					  						</div>
					  					</div>
					  					<div class="form-group">
					  						<div class="buttons  col-md-offset-9  col-md-3">
					  							<g:submitButton id="actualizarDireccion"
					  								name="Actualizar" 
					  								class="btn btn-primary  btn-block" 
					  								value="Actualizar"/>
					  						</div>
					  					</div>
					  				</fieldset>
					  				</g:form>
					  			</div>
					  			
					  		</div>
					  </div>
					</div>
				</div>
				<div class="ro">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Contacto <span id="contactoInfo"></span></h3>
					  </div>
					  <div class="panel-body">
					    <g:form class="form-horizontal" 
					    	name="contactoForm" action="actualizarContacto" id="${socioInstance.id}">
					    	<div class="form-group">
					    		<label for="telefonoCasa" class="col-sm-3 control-label">Telfono (Casa)</label>
					    		<div class="col-sm-8">
					    				<input name="telefonoCasa" id="telefonoCasa"
					    					class="form-control" 
					    					type="text"
					    					value="${socioInstance?.telefonoCasa}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<label for="telefonoTrabajo" class="col-sm-3 control-label">Telfono (Trabajo)</label>
					    		<div class="col-sm-8">
					    				<input name="telefonoTrabajo" id="telefonoTrabajo"
					    					class="form-control" 
					    					type="text"
					    					value="${socioInstance?.telefonoTrabajo}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<label for="celular" class="col-sm-3 control-label">Celular</label>
					    		<div class="col-sm-8">
					    				<input name="celular" id="celular"
					    					class="form-control" 
					    					type="text"
					    					value="${socioInstance?.celular}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<label for="email" class="col-sm-3 control-label">Email</label>
					    		<div class="col-sm-8">
					    				<input name="email" id="email"
					    					class="form-control" 
					    					type="email"
					    					value="${socioInstance?.email}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<label for="email2" class="col-sm-3 control-label">Email 2</label>
					    		<div class="col-sm-8">
					    				<input name="email" id="email2"
					    					class="form-control" 
					    					type="email"
					    					value="${socioInstance?.email2}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<label for="tarjet" class="col-sm-3 control-label">Tarjeta</label>
					    		<div class="col-sm-8">
					    				<input name="tarjeta" id="email2"
					    					class="form-control" 
					    					type="string"
					    					value="${socioInstance?.tarjeta}">
					    		</div>
					    	</div>
					    	<div class="form-group">
					    		<div class="buttons  col-md-offset-9  col-md-3">
					    			<g:submitButton id="actualizarContacto"
					    				name="Actualizar" 
					    				class="btn btn-primary  btn-block" 
					    				value="Actualizar"/>
					    		</div>
					    	</div>
					    </g:form>
					  </div>
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="panel panel-primary">
				  <div class="panel-heading">
				    <h3 class="panel-title">Membresia</h3>
				    <span id="membresiaInfo"></span>
				  </div>
				  <div class="panel-body">
				  	<div class="row">
				  			<div class="thumbnail">
				  			      %{-- <img src="http://lorempixel.com/g/300/300/people" alt="..."> --}%
				  			     %{--  <img src="holder.js/200x200"> --}%
				  			      %{-- <img src="http://placehold.it/300x300"> --}%
				  			    <g:if test="${socioInstance.foto}">
				  			    	<img src="${createLink(controller:'socio',action:'renderFoto',id:socioInstance.id)}" 
				  			    	width="350" height="400"/>
				  			  	</g:if>
				  			    <g:else>
				  			    	<img src="holder.js/350x300">
				  			    </g:else>
				  		      	<div class="caption">
				  		        	<h3>Foto</h3>
				  		        	<p><a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#cambiarFoto">Cambiar</a> 
				  		        	</p>
				  		      	</div>
				  			 </div>
				  	</div>
				  	<div class="row">
				  		<g:form class="form-horizontal" name="membresiaForm" action="actualizarMembresia" 
				  			id="${socioInstance.id}">

				  			<div class="form-group">
				  			    <label class="col-sm-3 control-label">Inscripción</label>
				  			    <div class="col-sm-8">
				  			      <p class="form-control-static">
				  			      	<g:formatDate date="${socioInstance?.membresia?.inscripcion}" 
				  			      		format="dd/MM/yyyy"/>
				  			      </p>
				  			    </div>
				  			</div>

					  		<div class="form-group">
					  			<label for="ultimoPago" class="col-sm-3 control-label">Último pago</label>
					  			<div class="col-sm-8">
					  					<input name="ultimoPago" id="ultimoPago"
					  						class="form-control mayusculas" 
					  						type="text"
					  						value="${socioInstance?.membresia?.ultimoPago?.format('dd/MM/yyyy')}">
					  			</div>
					  		</div>
					  		<div class="form-group">
					  			<label for="proximoPago" class="col-sm-3 control-label">Próximo pago</label>
					  			<div class="col-sm-8">
					  					<input name="proximoPago" id="proximoPago"
					  						class="form-control mayusculas" 
					  						type="text"
					  						value="${socioInstance?.membresia?.proximoPago?.format('dd/MM/yyyy')}">
					  			</div>
					  		</div>
					  		<div class="form-group">
					  			<label for="tolerancia" class="col-sm-3 control-label">Tolerancia</label>
					  			<div class="col-sm-8">
					  					<input name="tolerancia" 
					  						class="form-control mayusculas" 
					  						type="number"
					  						value="${socioInstance?.membresia?.toleranciaEnDias}">
					  			</div>
					  		</div>
					  		<div class="form-group">
					  		    <label class="col-sm-3 control-label">Suspender</label>
					  		    <div class="col-sm-8">
					  		      <p class="form-control-static">${socioInstance?.membresia?.suspender}</p>
					  		    </div>
					  		</div>
					  		
					  		<div class="form-group">
					  			<label for="servicio" class="col-sm-3 control-label">Servicio</label>
					  			<g:hiddenField id="productoId" 
					  				name="servicio" value="${socioInstance?.membresia?.servicio?.id}"/>
					  			<div class="col-sm-8">
					  					<input id="servicioField"
					  						class="form-control mayusculas" 
					  						type="text"
					  						value="${socioInstance?.membresia?.servicio?.descripcion}">
					  			</div>
					  		</div>

					  		<div class="form-group">
					  			<label for="corporativo" class="col-sm-3 control-label">Corporativo</label>
					  			<div class="col-sm-8">
					  				<g:select class="form-control"  
					  					name="tipoDeCorporativo" 
					  					value="${socioInstance?.perfil?.tipoDeCorporativo?.id}"
					  					from="${com.luxsoft.kio.TipoDeCorporativo.findAll()}" 
					  					optionKey="id" 
					  					optionValue="clave"
					  					noSelection="[null:'No aplica']"/>
					  			</div>
					  			
					  		</div>
					  		<div class="form-group">
					  			<div class="buttons  col-md-offset-8  col-md-3">
					  				<g:submitButton id="actualizarMembresia"
					  					name="Actualizar" 
					  					class="btn btn-primary  btn-block" 
					  					value="Actualizar"/>
					  			</div>
					  		</div>
						</g:form>
				  	</div>
				    	

				  </div>
				  
				</div>
			</div>

		</div>

		
		<div class="modal fade" id="cambiarFoto" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>
		        <h4 class="modal-title">Selección de foto</h4>
		      </div>
		       <g:uploadForm action="cargarFoto" class="form form-horizontal">
		       		<div class="modal-body">
		       			<div class="form-group">
		       				<g:hiddenField name="socioId" value="${socioInstance.id}"/>
		       				<label for="fotoFile" class="col-sm-2 control-lable">Imagen </label>
		       				<div class="col-sm-10">
		       					<input type="file" id="fotoFile" 
		       						name="foto" 
		       						accept=".gif,.jpg,.jpeg,.png" 
		       						class="form-control">
		       					
		       				</div>
		       				
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

		<script type="text/javascript">
				$("#proximoPago").datepicker({
		     
		 		});
		 		$("#ultimoPago").datepicker({
		     
		 		});
		 		

		 		
		 		$("#direccionForm").submit(function(e){
		 			e.preventDefault(); //Stop default action
		 			var postData=$(this).serializeArray();
		 			var formUrl=$(this).attr('action');
		 			var button=$("#actualizarDireccion");
		 			var info=$("#direccionInfo");
		 			$.ajax({
		 				url:formUrl,
		 				type:'POST',
		 				data:postData,
		 				beforeSend:function(jqXHR,settings){
		 					button.attr('disabled','disabled')
	    					.attr('value','Procesando');
		 				},
		 				success:function(data,textStatus,jqXHR){
		 					console.log("Ok data: "+data);
		 					info.attr('class','label label-success').text("Actualizada");
		 				},
		 				error:function(jqXHR,textStatus,errorThrown){
		 					console.log("Error : "+errorThrown);
		 				},
		 				complete:function(jqXHR,textStatus){
		 					console.log("Complete execution: "+textStatus);
		 				}
		 			}).done(function(data){
		 				console.log('Done funcion:'+data);
		 				
	    				button.removeAttr('disabled')
	    				.attr('value','Actualizar');
	    				
		 			});
		 			
		 			//e.unbind(); //to stop multiple form submits
		 		});

				$("#membresiaForm").submit(function(e){
		 			e.preventDefault(); //Stop default action
		 			var postData=$(this).serializeArray();
		 			var formUrl=$(this).attr('action');
		 			var button=$("#actualizarMembresia");
		 			var info=$("#membresiaInfo");
		 			$.ajax({
		 				url:formUrl,
		 				type:'POST',
		 				data:postData,
		 				beforeSend:function(jqXHR,settings){
		 					button.attr('disabled','disabled')
	    					.attr('value','Procesando');
		 				},
		 				success:function(data,textStatus,jqXHR){
		 					console.log("Ok data: "+data);
		 					info.attr('class','label label-success').text("Actualizada");
		 				},
		 				error:function(jqXHR,textStatus,errorThrown){
		 					console.log("Error : "+errorThrown);
		 				},
		 				complete:function(jqXHR,textStatus){
		 					console.log("Complete execution: "+textStatus);
		 					button.removeAttr('disabled')
	    					.attr('value','Actualizar');
	    					
		 				}
		 			}).done(function(data){
		 				console.log('Done funcion:'+data);
		 				
	    				
		 			});
		 			
		 			//e.unbind(); //to stop multiple form submits
		 		});

			$("#contactoForm").submit(function(e){
	 			e.preventDefault(); //Stop default action
	 			var postData=$(this).serializeArray();
	 			var formUrl=$(this).attr('action');
	 			var button=$("#actualizarContacto");
	 			var info=$("#contactoInfo");
	 			$.ajax({
	 				url:formUrl,
	 				type:'POST',
	 				data:postData,
	 				beforeSend:function(jqXHR,settings){
	 					button.attr('disabled','disabled')
    					.attr('value','Procesando');
	 				},
	 				success:function(data,textStatus,jqXHR){
	 					console.log("Ok data: "+data);
	 					info.attr('class','label label-success').text("Actualizada");
	 				},
	 				error:function(jqXHR,textStatus,errorThrown){
	 					console.log("Error : "+errorThrown);
	 				},
	 				complete:function(jqXHR,textStatus){
	 					console.log("Complete execution: "+textStatus);
	 					button.removeAttr('disabled')
    					.attr('value','Actualizar');
    					
	 				}
	 			}).done(function(data){
	 				console.log('Done funcion:'+data);
	 				
    				
	 			});
	 			
	 			//e.unbind(); //to stop multiple form submits
	 		});

			$("#servicioField").autocomplete({
				source:'<g:createLink controller="producto" action="geMembresiasAsJSON"/>',
				minLength:3,
				select:function(e,ui){
					console.log('Producto seleccionado: '+ui.item.value);
					$("#productoId").val(ui.item.id);
				}
			});
		
		</script>
	
	</div><!-- .end container -->
	

</body>
</html>