var module=angular.module("ngVentaNueva");

module.factory('ventaModel', ['$http', function($http){

	var getTipos=function(){
		var tempArray=[
			{clave:'NORMAL'},
			{clave:'CREDITO'}
		];

	};

	var getServiciosPorCliente=function(cliente){
		console.log('Localizando los servicios para el cliente: '+cliente.id);
		$http({method:'GET',url:'/kio-core/venta/productosPorCliente',params: {id: cliente.id}}).
			success(function(data, status, headers, config){
				console.log('Ok datos recividos: '+data.length);
				for (var i = 0; i < data.length; i++) {
					//console.log('Servicio: '+data[i].clave);
					//partidas.push(data[i]);
					addPartida(data[i]);
				};
				//partidas.push(data);
			}).
			error(function(data, status, headers, config){
				console.log('Error datos no recividos: '+data);
			});
		;
		//return [{clave:'PROD1',descripcion:'Descripcion de producto AJAX1'}];
		
	};

	var partidas=[];

	var getPartidas=function(){
		return partidas;
	};
	var clearPartidas=function(){
		partidas=[];
	};

	var addPartida=function(partida){
		partidas.push(partida);
		//actualizarTotales();
	};

	var actualizarTotales = function(){
		var importeBruto=0;
		for (var i = 0; i < partidas.length; i++) {
			var iBruto=partidas[i].importeBruto;
			if(typeof iBruto ==='number'){
				importeBruto+=(iBruto*100);
			}
		};
		venta.importe=(importeBruto/100);
		//console.log('Totales actualizados: ');
	};

	var venta={
		cliente:{id:'',nombre:''},
		fecha:'',
		tipo:'',
		importe:0.0,
		descuentos:0.0,
		subTotal:0.0,
		impuestos:0.0,
		total:0.0
	};


	return {
		getTipos:getTipos,
		getServiciosPorCliente:getServiciosPorCliente,
		getPartidas:getPartidas,
		clearPartidas:clearPartidas,
		venta:venta,
		actualizarTotales:actualizarTotales
	};
}]);