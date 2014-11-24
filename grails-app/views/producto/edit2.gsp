<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Producto</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<g:if test="${flash.message}">
                    	<span class="label label-warning">${flash.message}</span>
             </g:if>
			<div class="col-md-12">

				<div class="panel panel-primary">
					<!-- Default panel contents -->
  					<div class="panel-heading">
  						${productoInstance}  
  					</div>
  					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<ul class="nav nav-tabs " role="tablist">
								  <li class="active"><a href="#productoPanel" role="tab" data-toggle="tab">Producto</a></li>
								  
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="tab-content">
								  <div class="tab-pane active" id="productoPanel"><g:render template="editForm"/></div>
								  
								</div>
							</div>
						</div>
  					</div>
  					<div class="panel-footer">
  						<div class="btn-group">
  							<g:link class="btn btn-default btn-sm" action='index'> 
  								<span class="glyphicon glyphicon-arrow-left"> Catálogo
  							</g:link>
  							
  							%{-- <g:link class="btn btn-danger btn-sm" action='delete' onclick="return confirm('Seguro que desea eliminar este producto');"> 
  								<span class="glyphicon glyphicon-trash"> Eliminar
  							</g:link> --}%
  							
  						</div>
						
					</div>
				</div>

			</div>

		</div><!-- end .row -->
		


		
	</div>
	<script type="text/javascript">
		$(function(){
			$("#tipo").change(function(){
				var selected=$( "#tipo option:selected" ).text();
				console.log('Detectando cambio de tipo de producto: '+selected);
				if("MEMBRESIA"===selected){
					$('#periodicidad').prop('disabled', false);
					//$('#duracion').prop('disabled', false);
					
				}else{
					$('#periodicidad').prop('disabled', true)
					.val(null);
					//$('#periodicidad').val(null);
					//$('#duracion').prop('disabled', true);
					//$('#duracion').val(null);
				}
			});
			$("#periodicidad").change(function(){
				var selected=$( "#periodicidad option:selected" ).text();
				if("ESPECIAL"===selected){
					$('#duracion').prop('disabled', false);
				}else{
					$('#duracion').prop('disabled', true)
					.val('0');
				}
			});
			//Inicializamos estado
			$("#periodicidad").prop('disabled',${productoInstance?.tipo?.clave!='MEMBRESIA'});
			$("#duracion").prop('disabled',${productoInstance?.periodicidad!='ESPECIAL'});
		});
	</script>
	
	
</body>
</html>