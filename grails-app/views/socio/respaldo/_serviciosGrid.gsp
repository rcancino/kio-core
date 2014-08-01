
<div class="tablePanel">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>Clave</th>
				<th>Descripción</th>
				<th>Precio</th>
				<th>Desc</th>
				<th>Neto</th>
				<th>Próximo pago</th>
				<th>Suspensión</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${servicios}" var="row">
			<tr>
				<td>
					<g:link controller="servicioPorSocio" action="edit" id="${row.id}" >${row.servicio.clave}</g:link>
				</td>
				<td>${row.servicio.descripcion } </td>
				<td><g:formatNumber number="${row.precioBruto}" type="currency"/></td>
				<td><g:formatNumber number="${row.descuento}" type="percent"/></td>
				<td><g:formatNumber number="${row.precioNeto}" type="currency"/></td>
				<td><g:formatDate date="${row.proximoCargo}" format='dd/MM/yyyy'/> </td>
				<td><g:formatDate date="${row.suspension}" format='dd/MM/yyyy'/> </td>
				<td>
					<g:link controller="servicioPorSocio" action="delete" id="${row.id}" onclick="return confirm('Eliminar servicio');">
						<span class="glyphicon glyphicon-trash"></span>
					</g:link>
				</td>
			</tr>
			</g:each>
		</tbody>
	</table>
	

</div>





