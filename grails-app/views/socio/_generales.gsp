<div class="col-md-6">
	<div class="panel-header"><h2>Generales</h2></div>
	<form class="form-horizontal" role="form">
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Apellido paterno</label>
			<div class="col-sm-8">
      			<p class="form-control-static">${socioInstance.apellidoPaterno}</p>
    		</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Apellido materno</label>
			<div class="col-sm-8">
	      		<p class="form-control-static">${socioInstance.apellidoMaterno}</p>
	    	</div>
		</div>
	<div class="form-group">
		<label class="col-sm-4 control-label">Nombres</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.nombres}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Sexo</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.sexo}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Fecha nacimiento</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.fechaDeNacimiento?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Estado civil</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.estadoCivil}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Hijos</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.hijos?:'0'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Telefono casa</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.telefonoCasa?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Telefono trabajo</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.telefonoTrabajo?:'Pendiente'}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Celular</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.celular?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">email</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.email?:'Pendiente'}</p>
    	</div>
	</div>
		

	</form>
</div>
<div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="http://lorempixel.com/g/300/300/people" alt="...">
      <div class="caption">
        <h3>${socioInstance.nombres}</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi delectus reiciendis aut quibusdam placeat perferendis, nobis expedita nam nesciunt eos dolor. Recusandae quod atque ipsam, quasi excepturi magnam dignissimos nostrum.
        </p>
        <p>
        	<a href="#" class="btn btn-primary" role="button">Button</a> 
        	<a href="#" class="btn btn-default" role="button">Button</a>
        </p>
      </div>
    </div>
  </div>

%{-- 

<form class="form-horizontal" role="form">
	
	<fieldset>
	<legend> </legend>
	<div class="form-group">
		<label class="col-sm-4 control-label">Apellido paterno</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.apellidoPaterno}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Apellido materno</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.apellidoMaterno}</p>
    	</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label">Nombres</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.nombres}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Sexo</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance.sexo}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Fecha nacimiento</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.fechaDeNacimiento?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Estado civil</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.estadoCivil}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Hijos</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.hijos?:'0'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Telefono casa</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.telefonoCasa?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">Telefono trabajo</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.telefonoTrabajo?:'Pendiente'}</p>
    	</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label">Celular</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.celular?:'Pendiente'}</p>
    	</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label">email</label>
		<div class="col-sm-8">
      		<p class="form-control-static">${socioInstance?.email?:'Pendiente'}</p>
    	</div>
	</div>


	</fieldset>

</form>
 --}%