<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Ventas</title>
</head>
<body>
	<div class="container">

		<!-- end .row 1 Header -->
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2>Ventas</h2>
					<g:if test="${flash.message}">
	                    <div class="">
	                        <span class="label label-warning">${flash.message}</span>
	                    </div>
                	</g:if> 
				</div>
				 
				<g:render template="toolbar"/>
			</div>
		</div>
		<div class="row">
			
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<g:render template="grid"/>
			</div>
		</div>

	</div>
	
</body>
</html>