<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	
	<div class="row">

		<div class="col-md-6">
			<f:field property="membresia.alta" 
				input-class="form-control"
				
				colsLabel="col-md-4" cols="col-md-8"/>

			<f:field property="membresia.proximoPago" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>

			<f:field property="membresia.servicio" colsLabel="col-md-4" cols="col-md-8">
				
				<g:select id="membresiaServicio" name='cliente.membresia.servicio.id' value="${person?.type?.id}"
				    class="form-control" 
				    noSelection="${['null':'Seleccione el producto']}"
				    value="${membresia?.servicio?.id}"
				    from='${com.luxsoft.kio.Producto.findAll{tipo.clave=='MEMBRESIA'}}'
				    optionKey="id" ></g:select>
			</f:field>

			<f:field property="membresia.comentario" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>

		</div>

		<div class="col-md-6">
			<f:field property="membresia.ultimoPago" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				input-disabled="disabled" 
				/>
			<f:field property="membresia.suspender" label="Suspender en" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>
			<f:field property="membresia.toleranciaEnDias" 
				input-autocomplete="off"
				input-class="form-control" 
				colsLabel="col-md-4" cols="col-md-8"
				/>
		</div>

	</div>
		
	
		
</f:with>


	
	
	
