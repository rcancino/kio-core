<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#mainMenu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<g:link controller="home" action="index" class="navbar-brand">
				<span class="glyphicon glyphicon-home"></span> KIO
			</g:link>
		</div>
<%--		<sec:ifLoggedIn>--%>
		<div class="collapse navbar-collapse" id="mainMenu">
			<nav:menu class="nav navbar-nav" scope="user/" />
			<%--<ul class="nav navbar-nav">
				<li><g:link controller="home" action="catalogos">Catalogos</g:link></li>
				<li><g:link controller="home" action="operaciones">Operaciones</g:link></li>
				<li><g:link controller="home" action="procesos">Procesos</g:link></li>
				<li><g:link controller="home" action="reportes">Reportes</g:link></li>
				
			</ul>
			--%><ul class="nav navbar-nav navbar-right">
<%--				<g:render template="/_menu/user"/>--%>
				<form class="navbar-form navbar-left" role="search">
  					<div class="form-group">
    					<input type="text" class="form-control" placeholder="Buscar">
  					</div>
  					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
				</form>
				<buttn class="btn btn-default navbar-btn">
					Configuración <span class="glyphicon glyphicon-cog"></span>
				</button>
			</ul>
			
		</div>
		
<%--		</sec:ifLoggedIn>--%>
	</div>
	
</nav>