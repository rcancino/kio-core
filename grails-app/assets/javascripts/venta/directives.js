
var module=angular.module("ngVentaNueva");

module.directive('autoComplete',function(){
	
	var linker=function(scope,elem,attr,ctrl){
				elem.autocomplete({
					source:'/kio-core/socio/getSociosJSON',
                	minLength: 2,
                	select:function(e,ui){
						//console.log('Socio seleccionado: '+ui.item.value);
						//console.log('Cliente: '+ui.item.cliente.nombre);
						//console.log('Scope: '+scope.venta.cliente.nombre);
						scope.setCliente(ui.item.cliente);
						scope.$apply();
						// scope.addPartida(
						// 	{clave:'PRODUCTO 1',descripcion:'Descripcion de producto 1',unidad:'NA'
						// 		,cantidad:0.0
						// 		,precio:0.0
						// 		,importeBruto:0.0
						// 		,descuentoTasa:0.0
						// 		,descuento:0.0
						// 		,importeNeto:0.0
						// 		,impuestoTasa:.16
						// 		,impuesto:0.0
						// 		,servicioPorSocio:null
						// 	});
					}
				});
		};
	var controller=function($scope){
		//console.log('Directiva operando...'+$scope.ventaNueva.cliente);
	};

	return{
		restrict:'A',
		controller:controller,
		link:linker
	};
});

module.directive('autocompletProducto',function(){
	
	var linker=function(scope,elem,attr,ctrl){
				elem.autocomplete({
					source:'/kio-core/producto/getProductosAsJSON',
                	minLength: 2,
                	select:function(e,ui){
						//console.log('Producto seleccionado: '+ui.item.value);
						//scope.setProducto(ui.item);
						//scope.$apply();
					}
				});
		};
	var controller=function($scope){
		//console.log('Directiva operando...'+$scope.ventaNueva.cliente);
	};

	return{
		restrict:'A',
		controller:controller,
		link:linker
	};
});
/*
module.directive('autocompletProducto', ['', function(){
	// Runs during compile
	var linker=function(scope,elem,attr,ctrl){
				elem.autocomplete({
					source:'/kio-core/socio/getSociosJSON',
                	minLength: 2,
                	select:function(e,ui){
						console.log('Producto seleccionado: '+ui.item.value);
						//scope.setCliente(ui.item.cliente);
						//scope.$apply();
					}
				});
		};
	return {
		link: linker
	};
}]);
*/

//Directive para presentar las partidas
/*
module.directive('ventasDetGrid', ['', function(){
	// Runs during compile
	return {
		// name: '',
		// priority: 1,
		// terminal: true,
		// scope: {}, // {} = isolate, true = child, false/undefined = no change
		// controller: function($scope, $element, $attrs, $transclude) {},
		// require: 'ngModel', // Array = multiple requires, ? = optional, ^ = check parent elements
		// restrict: 'A', // E = Element, A = Attribute, C = Class, M = Comment
		// template: '',
		// templateUrl: '',
		// replace: true,
		// transclude: true,
		// compile: function(tElement, tAttrs, function transclude(function(scope, cloneLinkingFn){ return function linking(scope, elm, attrs){}})),
		link: function($scope, iElm, iAttrs, controller) {
			
		}
	};
}]);
*/