<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

			<link href='css/formularioRegistro.css' rel='stylesheet' type='text/css'>
				<img id="logo" src="img/logo2.png" />
					<title>Formulario</title>
	</head>

			<body>
				<form action="registrarUsuario" method="post">
					<h1> Formulario Registro </h1>
					<input type ="text" maxlength="20" placeholder="Ingrese sus nombres" name="nombre" id="nombre" required/>
					<input type ="text" maxlength="20" placeholder="Ingrese sus apellidos" name="apellido" id"apellido" required/>
					<input type ="text" maxlength="20" placeholder="Ingrese su fecha de nacimiento" name="nacimiento" id="nacimiento" required/>
					<input type ="text" maxlength="20" placeholder="Ingrese su correo electrónico" name="correo" id="correo" required/>
					<input type ="text" maxlength="20" placeholder="Ingrese un usuario para identificarse" name="usuario" id="usuario" required/>
					<input type ="password" maxlength="20" placeholder="Ingrese una contraseña" name="contrasenia" id="contrasenia" required />
					<center><input type="submit" id="enviar"></button></center>
				</form>
			</body>
</html>
