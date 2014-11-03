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
					<h2> 
						<i class="fa fa-shopping-cart  fa-2x"></i> Venta ${ventaInstance.id} - ${ventaInstance.cliente}
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
        				<i class="fa fa-tasks fa-fw fa-2x"></i>&nbsp;  Ventas por cobrar
        			</g:link>
        			<g:link action="abonos" class="list-group-item">
        				&nbsp;  Abonos
        			</g:link>
        			<g:link action="abonos" class="list-group-item">
        				&nbsp;  Saldo
        			</g:link>
        		  
        		  %{-- <a class="list-group-item" href="#"><i class="fa fa-book fa-fw fa-2x"></i>&nbsp; Library</a>
        		  <a class="list-group-item" href="#"><i class="fa fa-pencil fa-fw fa-2x"></i>&nbsp; Applications</a>
        		  <a class="list-group-item" href="#"><i class="fa fa-cog fa-fw fa-2x"></i>&nbsp; Settings</a> --}%
        		</div>
			</div>
			
			<div class="col-md-6 ">
				<g:form class="form-horizontal pull-left center-block" action="cobrar" name="pagoForm">
					<g:hiddenField name="ventaId" value="${ventaInstance.id}"/>

					<div class="form-group">
						<label class="col-sm-4 control-label">Fecha venta</label>
					    <div class="col-sm-8">
					      <p class="form-control-static"><g:formatDate date="${ventaInstance?.fecha}" format="dd/MM/yyyy"/></p>
					    </div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Tipo</label>
					    <div class="col-sm-8">
					      <p class="form-control-static">${ventaInstance.tipo}</p>
					    </div>
					</div>
					<f:with bean="${cobroInstance}">
						<f:field property="formaDePago" value="${cobroInstance.formaDePago}"
							input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" />
						<f:field property="referencia" 
							input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" input-disabled="disabled"/>
						<f:field property="importe" input-type="text" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" />
						<div class="form-group">
							<label class="col-sm-4 control-label">Tipo</label>
							<div class="col-sm-8">
								<input id="fecha" name="fecha" type="text"  
								value="${g.formatDate(date:ventaInstance?.fecha,format:'dd/MM/yyyy') }"
								class="form-control" autocomplete="off">
							</div>
						</div>
					</f:with>
					<div class="form-group">
						<div class="buttons  col-md-offset-4  col-md-8">
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
					
				</form>
			</div>

		</div><!-- end .row2 -->
		
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<div class="buttons  col-md-offset-5  col-md-4">
						%{-- <g:submitButton name="Cobrar" class="btn btn-primary btn-lg btn-block" value="Cobrar"/> --}%
						%{-- <button id="cobrarBtn" class="btn btn-primary btn-lg btn-block">Cobrar</button>	 --}%
					</div>
				</div>
			</div>
		</div>
		

	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//$("#precioBruto").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
			$("#fecha").datepicker({
	     
	 		});

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