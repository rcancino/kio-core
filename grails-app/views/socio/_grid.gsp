<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="No Socio"/>
			<g:sortableColumn property="apellidoPaterno" title="Nombre"/>
			<th>Servicio</th>
			<th>Vencimiento</th>
			<th>Corporativo</th>
			<th>Area</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${socioInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="edit" id="${row.id}">
						${fieldValue(bean:row,field:"numeroDeSocio")}
					</g:link>
				</td>
				<td>${row.toString()}</td>
				<td>
					<g:link controller="producto" action="show" id="${row.membresia?.servicio?.id}">
						${fieldValue(bean:row,field:"membresia.servicio")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"membresia.proximoPago")}</td>
				<td>${fieldValue(bean:row,field:"perfil.tipoDeCorporativo")}</td>
				<td>${fieldValue(bean:row,field:"perfil.areaDeInteres")}</td>
				
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${socioInstanceCount ?: 0}"/>
</div>