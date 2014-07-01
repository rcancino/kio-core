<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>KIO Catálogos</title>
</head>
<body>
	<content tag="header">
		<div class=" alert alert-info " >
			<h3>Catálogos del sistema</h3>
		</div>
	</content>
	<content tag="taskPanel">
		<div class="panel panel-default">
  			
  			
  			<nav:menu class="nav nav-pills nav-stacked"  scope="user/catalogos" custom="true">
	    		<li class="${active?'active':''}">
	        		<p:callTag tag="g:link"
	                   				attrs="${linkArgs + [class:active ? 'active' : '']}">
	               		<nav:title item="${item}"/>
	        		</p:callTag>
	        	</li>	
			</nav:menu>
			<%--
  			
  			<div class="list-group">
  				<a href="#" class="list-group-item">Cliente</a>
  				<a href="#" class="list-group-item">Instructor</a>
  				<a href="#" class="list-group-item">Medio de contacto</a>
  				<a href="#" class="list-group-item">Membresia</a>
  				<a href="#" class="list-group-item">Producto</a>
			</div>
		--%></div>
	</content>
</body>
</html>