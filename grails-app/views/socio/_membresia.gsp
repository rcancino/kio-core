<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	
	<div class="row">

		<div class="col-md-6">
			

			<f:field property="membresia.proximoPago" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>

			<f:field property="membresia.servicio" colsLabel="col-md-4" cols="col-md-8">
				
				%{-- <g:select id="membresiaServicio" name='cliente.membresia.servicio.id' 
					value="${socioInstance.membresia?.servicio?.id}"
				    class="form-control" 
				    noSelection="${['null':'Seleccione el producto']}"
				    value="${membresia?.servicio?.id}"
				    from='${}'
				    optionKey="id" ></g:select> --}%

				<g:select class="form-control"  
					name="membresia.servicio" 
					value="${socioInstance.membresia?.servicio?.id}"
					from="${com.luxsoft.kio.Producto.findAll{tipo.clave=='MEMBRESIA' && suspendido==false}}" 
					noSelection="${['null':'Seleccione una membresia']}"
					optionKey="id" 
					optionValue="descripcion"
					/>
			</f:field>

			<f:field property="membresia.comentario" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>

		</div>

		<div class="col-md-6">
			<f:field property="membresia.inscripcion" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				input-disabled="disabled" 
				/>
			<f:field property="membresia.ultimoPago" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				input-disabled="disabled" 
				/>
			%{-- <f:field property="membresia.suspender" label="Suspender en" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/> --}%
			<f:field property="membresia.diaDeCorte" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>

			<f:field property="membresia.ultimoPago" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				input-disabled="disabled" 
				/>
		</div>

	</div>
		
	
		
</f:with>


	
	
	
