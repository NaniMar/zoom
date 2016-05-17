<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<link href='css/formularioPrincipal.css' rel='stylesheet' type='text/css'>
				<img id="logo" src="img/logo2.png" />
					<title>Formulario</title>
	</head>

			<body>
				<form action="ingresoServlet" method="post">
					<h1> Formulario de ingreso </h1>
					<input type ="text" maxlength="20" id="usuario" name="usuario" placeholder="Ingrese su usuario" required/>
					<input type ="password" maxlength="20" id="password" name="password" placeholder="Ingrese su contraseña" required />
					<button type="submit">Iniciar Sesion</button>
					<center><a href="">Olvide mi contraseña</a></center>
					<a href="/zoom/"><img id="volver" src="img/color.png"/></a>
				</form>
			</body>
</html>
