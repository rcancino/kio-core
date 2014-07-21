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
<%--		<sec:ifLoggedIn>--%>
		<div class="collapse navbar-collapse" id="mainMenu">
			
			<%-- Catalogos --%>
			<ul class="nav navbar-nav">
				<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">Catálogos <span class="caret"></span></a>
				      <nav:menu class="dropdown-menu" scope="user/catalogos" /> 
	        	</li>
        	</ul>

        	<%-- Operaciones --%>
			<ul class="nav navbar-nav">
				<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          			Operaciones <span class="caret"></span></a>
				      <nav:menu class="dropdown-menu" scope="user/operaciones" /> 
	        	</li>
        	</ul>

        	<%-- Procesos --%>
			<ul class="nav navbar-nav">
				<li>
				    <g:link controller='home' action='procesos'>
				    	<span class="glyphicon glyphicon-tasks"></span> Procesos
				 	</g:link>
	        	</li>
        	</ul>

        	<%-- Consultas --%>
			<ul class="nav navbar-nav">
				<li>
				    <g:link controller='home' action='consultas'>
				    	<span class="glyphicon glyphicon-tasks"></span> Consultas
				 	</g:link>
	        	</li>
        	</ul>

			%{-- <nav:menu class="nav navbar-nav" scope="user/" /> --}%
			<ul class="nav navbar-nav navbar-right">
<%--				<g:render template="/_menu/user"/>--%>
				<form class="navbar-form navbar-left" role="search">
  					<div class="form-group">
    					<input type="text" class="form-control input-sm" placeholder="Buscar">
  					</div>
  					<button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-search"></span></button>
				</form>
				<button class="btn btn-default navbar-btn btn-sm">
					Configuración <span class="glyphicon glyphicon-cog"></span>
				</button>
			</ul>
			
		</div>
		
<%--		</sec:ifLoggedIn>--%>
	</div>
	
</nav>