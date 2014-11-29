<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<title>Cobro (${cobroInstance.id})</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-success">
					<h2> 
						<i class="fa fa-shopping-cart  fa-2x"></i> Venta ${cobroInstance.venta.id} : ${cobroInstance.cliente}
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
			<g:hasErrors bean="${cobroInstance}">
				<div class="alert alert-danger">
					<g:renderErrors bean="${cobroInstance}" as="list" />
				</div>
			</g:hasErrors>
		</div><!-- end .row -->
		
		<div class="row">
			<div class="col-md-3">
        		<div class="list-group">

        			<g:link action="index" class="list-group-item">
        				<i class="fa fa-tasks fa-fw fa-2x"></i>&nbsp;  Cobros
        			</g:link>
        			
        			<g:if test="${!cobroInstance.venta.cfdi}">
        				<g:link action="delete" class="list-group-item" onclick="return confirm('Eliminar el cobro?');"
        					id="${cobroInstance.id}">
        					<i class="fa fa-trash fa-fw fa-2x"></i>&nbsp;  Eliminar
        				</g:link>
        				<g:link action="facturar" class="list-group-item" onclick="return confirm('Facturar la venta ventaInstance.id?');"
        					id="${cobroInstance.venta.id}">
        					<i class="fa fa-file-pdf-o fa-fw fa-2x"></i>&nbsp;  Facturar
        				</g:link>
        			</g:if>
        			
        		</div>
			</div>
			
			<div class="col-md-6 ">
				<fieldset disabled>
					
				
				<g:form class="form-horizontal pull-left center-block text-right"  name="pagoForm">
					<div class="form-group">
						<label class="col-sm-4 control-label">Fecha venta</label>
					    <div class="col-sm-8">
					      <p class="form-control-static"><g:formatDate date="${cobroInstance.fecha}" format="dd/MM/yyyy"/></p>
					    </div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Tipo</label>
					    <div class="col-sm-8">
					      <p class="form-control-static">${cobroInstance.venta.tipo}</p>
					    </div>
					</div>
					<f:with bean="${cobroInstance}">
						<f:field property="formaDePago" value="${cobroInstance.formaDePago}"
							input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" />
						<f:field property="referencia" 
							input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" input-disabled="disabled"/>
						<f:field property="importe" input-type="text" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" />
						<div class="form-group">
							<label class="col-sm-4 control-label">Saldo </label>
							<div class="col-sm-8">
								<strong>
									<p class="form-control-static ">
										<g:formatNumber number="${cobroInstance.venta.saldo}" type="currency"/>
									</p>
								</strong>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">CFDI </label>
							<div class="col-sm-8">
								<strong>
									<p class="form-control-static ">
										<g:link controller="cfdi" action="show">
											${cobroInstance.venta?.cfdi?.uuid}
										</g:link>
									</p>
								</strong>
							</div>
						</div>
					</f:with>
				</g:form>
				</fieldset>
			</div>

			<div class="col-md-3 well">

				<form class="form-horizontal totales-form text-right">
					<div class="form-group">
					    <label class="col-sm-4 control-label">Importe</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${cobroInstance.venta.importe}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Descuento</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${cobroInstance.venta.descuento}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Sub Total</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${cobroInstance.venta.subTotal}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Impuesto</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${cobroInstance.venta.impuesto}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Total</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${cobroInstance.venta.total}" type="currency"/>
					    	</p>
					    </div>
					</div>
					
				</form>
			</div>

		</div><!-- end .row2 -->

	</div>
	
	
</body>
</html>