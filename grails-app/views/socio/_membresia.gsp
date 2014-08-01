<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	
	<div class="row">

		<div class="col-md-6">
			<f:field property="cliente.id" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
		</div>

		<div class="col-md-6">
			<f:field property="cfdiEmail" 
				input-autocomplete="off"
				input-class="form-control uppercase-field" 
				colsLabel="col-md-4" cols="col-md-8"
				/>
		</div>

	</div>
		
	
		
</f:with>


	
	
	
