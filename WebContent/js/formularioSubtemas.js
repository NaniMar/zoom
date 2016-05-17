function actualizar(id){
	var nombre = window.prompt("Ingrese el nuevo nombre");
	var accion = "modificar";
	
	if(nombre != null){
		$.ajax({
			  type: "POST",
			  url: "subtemaServlet",
			  data: {nombre: nombre ,id: id, accion: accion }
			});
		location.reload();
	}
	
}

function borrar(id){
	var accion = "borrar";
	var confirmacion = confirm("¿Esta seguro que desa eliminar el subtema?");
	
	if(confirmacion){
		$.ajax({
			  type: "POST",
			  url: "subtemaServlet",
			  data: {id: id, accion: accion }
			});
		location.reload();
	}
	}

function ingresar(){
	var accion = "guardar";
	var nombre = $('#nombreSubtema').val(); //Selector de JQuery
	var tema = 1;
	
	$.ajax({
		  type: "POST",
		  url: "subtemaServlet",
		  data: {accion: accion, nombre:nombre, tema: tema }
		});
	location.reload();
}