<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	<div class="row">
		<div class="col-md-6">

			<f:field property="perfil.tipoDeSocio" 
				input-class="form-control"
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>

			<f:field property="perfil.tipoDeCorporativo" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8" label="Corporativo"/>
			
			<f:field property="perfil.estadoCivil" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>
			
			<f:field property="perfil.fechaDeNacimiento" 
				input-class="form-control"
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
			
			<f:field property="perfil.medioDeContacto" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>
			
			<f:field property="perfil.areaDeInteres" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>
			
			<f:field property="perfil.hijos" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>

			<f:field property="perfil.instructor" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>

			<f:field property="perfil.peso" 
				input-class="form-control"
				colsLabel="col-md-4" cols="col-md-8"/>


				<fieldset>
					<legend>Redes sociales</legend>

					<f:field property="perfil.faceBook" 
					input-class="form-control"
					colsLabel="col-md-4" cols="col-md-8"/>

					<f:field property="perfil.twitter" 
					input-class="form-control"
					colsLabel="col-md-4" cols="col-md-8"/>

					<f:field property="perfil.whatsApp" 
					input-class="form-control"
					colsLabel="col-md-4" cols="col-md-8"/>

					<f:field property="perfil.skype" 
					input-class="form-control"
					colsLabel="col-md-4" cols="col-md-8"/>
				</fieldset>
			
			
		</div>
		
		<div class="col-md-6">

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
		        	<p><a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#myModal">Cambiar</a> 
		        	</p>
		      	</div>
			 </div>
			
		</div>
	</div>

	
</f:with>


	
