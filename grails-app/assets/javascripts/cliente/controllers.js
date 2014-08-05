/**
 * Controladores para el mantenimiento de clientes
 */

 angular.module('ClentesApp')
 		.controller('ClientesCtrl', ['$scope','$window','$http', function($scope,$window,$http){

 	$scope.cliente={};

 	$scope.tipos=['PARTICULAR','EMPRESARIAL'];

 	$scope.salvar=function(cliente){
 		console.log('Salvando cliente nuevo..');
 		console.log(cliente);
 		$http.post('save/',cliente)
 			.success(function(data,status){
 				console.log('Alta exitosa..');
 			})
 			.error(function(data,status){
 				console.log('Error en alta...');
 			})
 		//$window.location.href="index"
 	};
 	
 	
 }]);