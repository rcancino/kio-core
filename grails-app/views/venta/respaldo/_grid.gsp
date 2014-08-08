<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<th>Cliente</th>
			<th>Rfc</th>
			<th>Status</th>
			<th>Tipo</th>
			<th>Fecha</th>
			
			<th>Importe</th>
			<th>Impuesto</th>
			<th>Total</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${ventaInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"cliente.nombre")}</td>
				<td>${fieldValue(bean:row,field:"cliente.rfc")}</td>
				<td>${fieldValue(bean:row,field:"status")}</td>
				<td>${fieldValue(bean:row,field:"tipo")}</td>
				<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
				<td><g:formatNumber number="${row.subTotal}" type="currency"/></td>
				<td><g:formatNumber number="${row.descuento}" type="currency"/></td>
				<td><g:formatNumber number="${row.subTotal}" type="currency"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${ventaInstanceCount ?: 0}"/>
</div>