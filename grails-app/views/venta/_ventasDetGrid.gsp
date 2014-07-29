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

		<g:each in="${partidas}" var="row" status="i">
			<g:hiddenField name="partidas[${i}].servicioPorSocio.id" value="${row?.servicioPorSocio?.id}"/>
			<g:hiddenField name="partidas[${i}].producto.id" value="${row?.producto?.id}"/>
			<tr>
				<td>
					<g:link controller="ventaDet" action="edit" id="${row.id}">${row?.servicioPorSocio?.socio?.id}</g:link>
				</td>
				<td>
					<g:link controller="ventaDet" action="edit" id="${row.id}">${row.producto.clave}</g:link>
				</td>
				<td>${row.producto.descripcion}</td>
				<td>${row.producto.unidad}</td>
				<td>
					<g:hiddenField name="partidas[${i}].cantidad" value="${row?.cantidad}"/>
					${row.cantidad}
				</td>
				<td >
					<g:hiddenField name="partidas[${i}].precioUnitario" value="${row?.precioUnitario}"/>
					<g:formatNumber number="${row.precioUnitario}" type="currency"/>
				</td>
				<td>
					<g:hiddenField name="partidas[${i}].importeBruto" value="${row?.importeBruto}"/>
					<g:formatNumber number="${row.importeBruto}" type="currency"/>
				</td>
				<td>
					<g:formatNumber number="${row.descuentoTasa}" type="percent"/>
				</td>
				<td>
					<g:hiddenField name="partidas[${i}].importeNeto" data-importe-neto="neto" value="${row?.importeNeto}"/>
					<g:formatNumber number="${row.importeNeto}" type="currency"/>
				</td>
				<td>
					<g:link controller="ventaDet" action="delete" id="${row.id}">
						<span class="glyphicon glyphicon-trash"></span>
					</g:link>
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
