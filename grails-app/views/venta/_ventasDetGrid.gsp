<table id="partidasTable" class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>Socio</th>
			<th>Producto</th>
			<th>Descripcion</th>
			<th>Unidad</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Importe</th>
			<th>Descuento</th>
			<th>Sub Total</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	<tbody>

		<g:each in="${ventaInstance.partidas}" var="row" status="i">
			<tr>
				<td>
					<g:link controller="ventaDet" action="edit" id="${row.id}">${row?.servicioPorSocio?.socio?.id}</g:link>
				</td>
				<td>
					<g:link controller="ventaDet" action="edit" id="${row.id}">${row.producto.clave}</g:link>
				</td>
				<td>${row.producto.descripcion}</td>
				<td>${row.producto.unidad}</td>
				<td>${row.cantidad}</td>
				<td >
					<g:formatNumber number="${row.precio}" type="currency"/>
				</td>
				<td>
					<g:formatNumber number="${row.importe}" type="currency"/>
				</td>
				<td>
					<g:formatNumber number="${row.descuento}" type="percent"/>
				</td>
				<td>
					<g:formatNumber number="${row.subTotal}" type="currency"/>
				</td>
				<td>
					<g:link controller="ventaDet" action="delete" id="${row.id}" onclick="return confirm('Eliminar producto');">
						<span class="glyphicon glyphicon-trash"></span>
					</g:link>
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
