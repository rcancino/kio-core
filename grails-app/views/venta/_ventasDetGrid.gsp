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
			<th>Total</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	<tbody>

		<g:each in="${ventaInstance.partidas}" var="row" status="i"> 
			<tr>
				<td>
					<g:if test="${!row.venta.cfdi}">
						<g:link controller="ventaDet" action="edit" id="${row.id}">
							<g:formatNumber number="${row.id}" format='####'/>
						</g:link>
					</g:if>
					<g:else>
						<g:formatNumber number="${row.id}" format='####'/>
					</g:else>
				</td>
				<td>
					%{-- <g:link controller="ventaDet" action="edit" id="${row.id}">${row.producto.clave}</g:link> --}%
					<g:if test="${!row.venta.cfdi}">
						<g:link controller="ventaDet" action="edit" id="${row.id}">
							${row.producto.clave}
						</g:link>
					</g:if>
					<g:else>
						${row.producto.clave}
					</g:else>
				</td>
				<td>${row.producto.descripcion}</td>
				<td>${row.producto.unidad}</td>
				<td>${row.cantidad}</td>
				<td >
					<g:formatNumber number="${row.precio}" type="currency"/>
				</td>
				<td>
					<g:formatNumber number="${row.importeBruto}" type="currency"/>
				</td>
				<td>
					<g:formatNumber number="${row.descuento}" type="currency"/>
				</td>
				
				<td>
					<g:formatNumber number="${row.importeNeto}" type="currency"/>
				</td>
				<td>
					<g:if test="${!row.venta.cfdi}">
						<g:link controller="ventaDet" action="delete" id="${row.id}" 
							onclick="return confirm('Eliminar producto');">
							<span class="glyphicon glyphicon-trash"></span>
						</g:link>
					</g:if>
					
					
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
