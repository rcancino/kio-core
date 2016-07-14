<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<title>Cobro (${ventaInstance.id})</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-success">
					<h3> 
						<i class="fa fa-shopping-cart  fa-2x"></i> 
						Venta ${ventaInstance.id} - ${ventaInstance.cliente} 
					</h3>
					<h4>F. Pago: ${ventaInstance.formaDePago}</h4>
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

        			<g:link action="pendientes" class="list-group-item">
        				<i class="fa fa-tasks fa-fw fa-2x"></i>&nbsp;  Ventas por cobrar
        			</g:link>
					
					<g:link  action="regresarAPedido" class="list-group-item" id="${ventaInstance.id}"
        				onclick="return confirm('Regresar a pedidos');">
        				<i class="fa fa-reply"></i>&nbsp;  Regresar Pedido
        			</g:link>

        			<g:link  action="deleteVenta" class="list-group-item" id="${ventaInstance.id}"
        				onclick="return confirm('Eliminar la venta');">
        				<i class="fa fa-tasks fa-trash fa-2x"></i>&nbsp;  Eliminar
        			</g:link>
        		</div>
			</div>
			
			<div class="col-md-6 ">
				
				<g:form class="form-horizontal " action="cobrar" name="pagoForm">
					<g:hiddenField name="ventaId" value="${ventaInstance.id}"/>

					<div class="form-group">
						<label class="col-sm-3 control-label">Fecha venta</label>
					    <div class="col-sm-9">
					      <p class="form-control-static"><g:formatDate date="${ventaInstance?.fecha}" format="dd/MM/yyyy"/></p>
					    </div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Tipo</label>
					    <div class="col-sm-9">
					      <p class="form-control-static">${ventaInstance.tipo}</p>
					    </div>
					</div>
					<f:with bean="${cobroInstance}">
						<f:field property="formaDePago" value="${cobroInstance.formaDePago}"
							input-class="form-control" cols="col-sm-9" colsLabel="col-sm-3" />
						<f:field property="referencia" 
							input-class="form-control" cols="col-sm-9" colsLabel="col-sm-3" input-disabled="disabled"/>
						<f:field property="importe" input-type="text" 
							input-class="form-control" cols="col-sm-9" colsLabel="col-sm-3" />
						
					</f:with>
					<div class="form-group">
						<div class="buttons  col-md-offset-9  col-md-3">
							<g:submitButton name="Cobrar" class="btn btn-primary btn-lg btn-block" value="Cobrar"/>
							%{-- <button id="cobrarBtn" class="btn btn-primary btn-lg btn-block">Cobrar</button>	 --}%
						</div>
					</div>
				</g:form>
				
			</div>

			<div class="col-md-3 well">

				

				<form class="form-horizontal totales-form text-right">
					<div class="form-group">
					    <label class="col-sm-4 control-label">Importe</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.importe}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Descuento</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.descuento}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Sub Total</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.subTotal}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Impuesto</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.impuesto}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Total</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.total}" type="currency"/>
					    	</p>
					    </div>
					</div>
					<div class="form-group">
					    <label class="col-sm-4 control-label">Pagos</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.pagos}" type="currency"/>
					    	</p>
					    </div>
					</div>

					<div class="form-group">
					    <label class="col-sm-4 control-label">Saldo</label>
					    <div class="col-sm-8">
					    	<p class="form-control-static">
					      		<g:formatNumber number="${ventaInstance.saldo}" type="currency"/>
					    	</p>
					    </div>
					</div>
				</form>
			</div>

		</div><!-- end .row2 -->
		
		
		

	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//$("#precioBruto").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
			// $("#fecha").datepicker({
	     
	 	// 	});

			$('form[name=pagoForm]').submit(function(e){
	    		$(this).children('input[type=submit]').attr('disabled', 'disabled');
	    		console.log("Desablidatndo submit button....");
	    		//$("#Cobrar").attr('disabled','disabled');
	    		var button=$("#Cobrar");
	    		//button.css('display', 'none');
	    		button.attr('disabled','disabled').attr('value','Procesando...');
	    		
	    		// this is just for demonstration
	    		//e.preventDefault(); 
	    		return true;
			});

			$("#formaDePago").change(function(){
				var text = "";
				   $(this).children("option:selected").each(function() {
				      text += $( this ).text() ;
				});
				if(text==='EFECTIVO'){
					$("#referencia").attr('disabled','disabled');
					//$("#referencia").attr('required','required');
				}else{
					$("#referencia").removeAttr('disabled');
					$("#referencia").attr('required','required');
					
				}
			});

		});
	</script>	
	
</body>
</html>