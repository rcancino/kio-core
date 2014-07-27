// This is a manifest file that'll be compiled into spa.js.
//
// 
//
//= require angular/angular.min.js
//= require_self
$(document).ready(function(){
	
	$("#socio2").autocomplete({
		source:'/kio-core/socio/getSociosJSON',
		minLength:3,
		select:function(e,ui){
			console.log('Socio seleccionado: '+ui.item.value);
			$("#socioId").val(ui.item.id);
			$("#cliente").val(ui.item.cliente.nombre);
			$("#clienteId").val(ui.item.cliente.id);
			//setCliente(ui.item.cliente.nombre);
		}
	});
	
	$("#fecha").datepicker({
	     
	});
});



var module=angular.module("ngVentaNueva",[]);

module.controller('MainCtrl', ['$scope','ventaModel', function($scope,ventaModel){
	
	$scope.title="Alta de venta nueva";

	$scope.socio='';

	$scope.currentPartida={};
	$scope.partidaNueva={};

	$scope.setCliente=function(cliente){
		if(typeof $scope.venta!=='undefined'){
			$scope.venta.cliente=cliente;
			localizarServicios();
		}
	};
	
	$scope.venta=ventaModel.venta;

	$scope.addPartida=function(partida){
		console.log('Agregando nueva partida:'+partida);
	};
	
	$scope.addProducto=function(producto){
		console.log('Agregando producto: '+producto);
	};

	$scope.setProducto=function(producto){
		if(typeof $scope.partidaNueva!=='undefined'){
			$scope.partidaNueva.clave=producto.clave;
			$scope.partidaNueva.descripcion=producto.descripcion;
			$scope.partidaNueva.precioBruto=producto.precioBruto
			console.log('Agregando producto: '+producto.clave);
		}
	};

	var localizarServicios= function(){
		ventaModel.getServiciosPorCliente($scope.venta.cliente);
	};

	$scope.partidas=ventaModel.getPartidas();

	$scope.$watchCollection('partidas',function(newValue,oldValue){
		//console.log('Cambiaron las partidas.....');
		ventaModel.actualizarTotales();

	});

	$scope.agregarPartida=function(partida){
		console.log('Agregando partida: '+partida);
		$scope.partidas.push(partida);
	};

	$scope.removePartida=function(partida){
		console.log('Eliminando partida');
		var index=$scope.partidas.indexOf(partida);
		console.log('Eliminando index: '+index);
		$scope.partidas.splice(index,1);
	}
	
	$scope.salvar=function(venta){
		console.log('Salvando venta: '+venta);
	};

	$scope.test=function(){
		console.log('Probando boton desde test');
	};


}]);




