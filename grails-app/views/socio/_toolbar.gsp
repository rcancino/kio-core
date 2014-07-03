<div class="row">

	<div class="col-lg-4">
		<div class="btn-group ">
			<g:link action="index" class="btn btn-default btn-sm" >
				<span class="glyphicon glyphicon-repeat"></span> Refrescar
			</g:link>
			<g:link action="create" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-floppy-saved"></span> Alta
			</g:link>
			
			<g:link action="importar" class="btn btn-default btn-sm" onclick="return confirm('¿Importar socio?');">
				<span class="glyphicon glyphicon-import"></span> Importar
			</g:link>
		</div>
		
	</div><!-- /.col-lg-6 -->
			
	<div class="col-lg-8">
		<g:form action="search" class="form-inline">
			<div class="form-group ">
				<input name="term" type="text" class="form-control input-sm col-xs-4" placeholder="Buscar"  autofocus="autofocus">
			</div>
			<button type="submit" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-search"></span> Buscar
			</button>
		</g:form>
	</div>

</div>