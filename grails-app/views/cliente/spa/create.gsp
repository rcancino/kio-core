<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nueva venta</title>
	<asset:javascript src="cliente/spa.js"/>
</head>
<body>
	<div class="container" ng-app="ClentesApp">

		<div class="row" ng-controller="ClientesCtrl">
			
			<div class="col-md-12">
				<div class="well">
					<h3 ng-if="cliente.nombre" >{{cliente.nombre | uppercase }}</h3>
					<h3 ng-if="!cliente.nombre" >{{'Alta de cliente'}}</h3>
				</div>
			</div>
			
			<div class="col-md-12">
				<form name="clienteForm" novalidate class="form-horizontal" ng-submit="salvar(cliente)">
					
					<div class="form-group">
						<label for="nombreField" class="control-label col-sm-2">Nombre</label>
            <div class="col-sm-4">
                <input id="nombreField" name="socio" 
                       ng-model="cliente.nombre" value="{{cliente.nombre}}"
                       class="form-control" 
                       type="text" 
                       required 
                       ng-minlength="2">
            </div>
            <label for="rfcField" class="control-label col-sm-2">Rfc</label>
            <div class="col-sm-4">
                <input id="rfcField" 
                       name="rfc" 
                       ng-model="cliente.rfc" ng-minlength="12" ng-maxlength="13"
                       class="form-control" type="text" 
                       required>
                <span class="help-block" 
                      ng-show="clienteForm.rfc.$dirty && clienteForm.rfc.$invalid">
                    RFC debe ser de 12 o 13 caracteres
                </span>
                
            </div>
					</div>

					<div class="form-group">
                        <label for="emailField" class="control-label col-sm-2">Email</label>
                        <div class="col-sm-4">
                            <input id="emailField" name="email" ng-model="cliente.cfdiMail"
                                   class="form-control" type="email" required>
                            <span class="help-block" 
                                  ng-show="clienteForm.email.$dirty && clienteForm.email.$invalid">
                                Email vaido para recibir CFDIs
                            </span>
                        </div>
                        <label for="tipoField" class="control-label col-sm-2">Tipo</label>
                        <div class="col-sm-4">
                            <select id="tipoField"  name="tipo" ng-model="cliente.tipo"
                                    ng-options="t for t in tipos" 
                                    class="form-control" 
                                    required>
                            </select>
                        </div>
                    </div>

                    <fieldset>
                        <legend>Domicilio fiscal</legend>
                        <g:render template="spa/direccion"/>
                    </fieldset>

                    <fieldset>
                        <legend></legend>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button class="btn btn-default" name="cancelar" > Cancelar</button>
                            <button class="btn btn-primary" name="salvar" 
                                    type="submit" ng-disabled="clienteForm.$invalid"> 
                                Salvar
                            </button>

                        </div>
                    </div>
                    </fieldset>

				</form>
			</div>
			

		</div><%-- end .row 1 header --%>



	</div>



</body>
</html>