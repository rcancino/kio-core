<div class="col-md-6">
	<div class="panel-header"><h3>Comercial</h3></div>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="col-sm-4 control-label">Medio de contacto</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.medioDeContacto?:'Pendiente'}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Tipo de socio</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.tipoDeSocio?:'Pendiente'}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Área de interes</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.areaDeInteres?:'Pendiente'}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Instructor</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.instructor?:'Pendiente'}</p>
			</div>
		</div>
	</form>	
</div>

<div class="col-md-6">
	<div class="panel-header"><h3>Redes sociales</h3></div>
	<form class="form-horizontal" role="form">
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Twitter</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.twitter?:'@'}</p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Facebook</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.faceBook?:'@'}</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">WhatsApp</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.whatsApp?:'@'}</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Skype</label>
			<div class="col-sm-8">
				<p class="form-control-static">${socioInstance.skype?:'@'}</p>
			</div>
		</div>



	</form>	
</div>