<%@page import="co.zoom.modelo.Subtema"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<link href='css/formularioSubtemas.css' rel='stylesheet' type='text/css'></link>
			<script src="js/jquery-2.2.3.min.js"></script>
			<script src="js/formularioSubtemas.js"></script>
				
				<title>Subtemas</title>
	</head>
		<body>
		<img id="logo" src="img/logo2.png" />
					<ul>
					<a href=""></a>
					<a href="">Administrar Ejercicios</a>
					<a href="">Administrar Videos</a>
					<a href="">Administrar Lecturas</a>	</ul>	
			<form>
					<h1> Formulario Subtemas</h1>
					
					<table border="1">
					<%
  						java.util.List<Subtema> subtemas = (java.util.List<Subtema>) request.getAttribute("subtemas"); 
  						for (Subtema subtema: subtemas) {   
					%>
						  <tr>
						  	<td><%=subtema.getId()%></td>
						    <td><%=subtema.getNombre()%></td>
						    <td><button onclick="actualizar(<%=subtema.getId()%>)" type="button" id="modificar">Modificar</button></td>
						    <td><button onclick="borrar(<%=subtema.getId()%>)" type="button" id="eliminar">Eliminar</button></td>
						   </tr>
						<%}%>
						</table>
					
					<input id="nombreSubtema" name="nombreSubtema" type ="text" maxlength="100" placeholder="Ingrese nombre del subtema" required/><br/>
					<button onclick="ingresar()" type="button" id="guardar">Guardar</button>
					<a href="/zoom/"><img id="volver" src="img/color.png"/></a>
			</form>
			
		</body>
</html>