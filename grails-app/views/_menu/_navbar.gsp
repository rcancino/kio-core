<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#mainMenu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<g:link controller="home" action="index" class="navbar-brand">
				<span class="glyphicon glyphicon-home"></span> KYO
			</g:link>
		</div>
		<sec:ifLoggedIn>
		
		<div class="collapse navbar-collapse" id="mainMenu">
			
			<%-- Catalogos --%>
			<ul class="nav navbar-nav">
				<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">Catálogos <span class="caret"></span></a>
				      <nav:menu class="dropdown-menu" scope="user/catalogos" /> 
	        	</li>
	        	<%-- Operaciones --%>
	        	<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          			Operaciones <span class="caret"></span></a>
				      <nav:menu class="dropdown-menu" scope="user/operaciones" /> 
	        	</li>
	        	<%-- Procesos --%>
	        	<li>
				    <g:link controller='home' action='procesos'>
				    	<span class="glyphicon glyphicon-cog"></span> Procesos
				 	</g:link>
	        	</li>
	        	
	        	<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          			<span class="glyphicon glyphicon-dashboard"></span> Consultas <span class="caret"></span>
				      <nav:menu class="dropdown-menu" scope="user/consulta" /> 
	        	</li>

	        	<li>
				    <g:link controller='report' >
				    	<i class="fa fa-line-chart"></i> Reportes
				 	</g:link>
	        	</li>

        	</ul>

        	

        	

        	

			
			<ul class="nav navbar-nav navbar-right">
				<g:render template="/_menu/user"/> 
			</ul>
			
		</div>
		
		</sec:ifLoggedIn>
	</div>
	
</nav>