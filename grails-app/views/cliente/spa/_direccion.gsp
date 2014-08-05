<div class="form-group">
    <label for="calleField" class="col-sm-2 control-label">Calle </label>
    <div class="col-sm-4">
        <input id="calleField" name="calle" ng-model="cliente.direccion.calle" 
               type="text" 
               class="form-control" 
               placeholder="Calle"
               required>
    </div>
</div>
<div class="form-group">
    <label for="numeroExteriorField" class="col-sm-2 control-label"># Exterior</label>
    <div class="col-sm-4">
        <input id="numeroExteriorField" name="numeroExterior" 
               ng-model="cliente.direccion.numeroExterior" 
               type="text" 
               class="form-control" 
               placeholder="# Exterior"
               required>
    </div>
    <label for="numeroInteriorField" class="col-sm-2 control-label"># Interior</label>
    <div class="col-sm-4">
        <input id="numeroInteriorField" name="numeroInterior" 
               ng-model="cliente.direccion.numeroInterior" 
               type="text" 
               class="form-control" 
               placeholder="# Interior"
               >
    </div>
</div>
<div class="form-group">
    <label for="coloniaField" class="col-sm-2 control-label">Colonia</label>
    <div class="col-sm-4">
        <input id="coloniaField" name="colonia" 
               ng-model="cliente.direccion.colonia" 
               type="text" 
               class="form-control" 
               placeholder="Colonia"
               required>
    </div>
    <label for="municipioField" class="col-sm-2 control-label">Municipio</label>
    <div class="col-sm-4">
        <input id="municipioField" name="municipio" 
               ng-model="cliente.direccion.municipio" 
               type="text" 
               class="form-control" 
               placeholder="Municipio/Delegación"
               required>
    </div>
</div>

<div class="form-group">
    <label for="estadoField" class="col-sm-2 control-label">Estado</label>
    <div class="col-sm-4">
        <input id="estadoField" name="estado" 
               ng-model="cliente.direccion.estado" 
               type="text" 
               class="form-control" 
               placeholder="Estado"
               required>
    </div>
    <label for="paisField" class="col-sm-2 control-label">Pais</label>
    <div class="col-sm-4">
        <input id="paisField" name="pais" 
               ng-model="cliente.direccion.pais" 
               type="text" 
               class="form-control" 
               placeholder="Pais"
               required>
    </div>
</div>
<div class="form-group">
    <label for="codigoPostalField" class="col-sm-2 control-label">C.P</label>
    <div class="col-sm-2">
        <input id="codigoPostalField" name="codigoPostal" 
               ng-model="cliente.direccion.codigoPostal" 
               type="text" 
               class="form-control" 
               placeholder="Código postal"
               required>
    </div>
</div>