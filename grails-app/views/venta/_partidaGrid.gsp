
			<g:hiddenField name="partidas[${i}].servicioPorSocio.id" value="${row?.servicioPorSocio?.id}"/>
			<g:hiddenField name="partidas[${i}].producto.id" value="${row?.producto?.id}"/>
			<tr>
				<td>
					
					${row.producto.clave}
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
			</tr>
		
