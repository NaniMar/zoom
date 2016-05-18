package co.zoom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.zoom.util.Coneccion;

public class RegistroDao {      
	
	private static final String INSERTAR_USUARIO = "INSERT INTO zoom.usuario (login, contrasenia) VALUES (?, ?);";
	private static final String INSERTAR_APRENDIZ = "INSERT INTO zoom.aprendiz(nombre, apellido, fecha_nacimiento, correo, usuario) VALUES (?, ?, ?,?,?);";
	private static final String VALIDAR_LOGIN = "SELECT contrasenia FROM usuario WHERE login = ?";
	private static final String VALIDAR_ADMIN = "SELECT admin FROM usuario WHERE login = ?";
	
	Connection conn = null;
	Statement st = null;
	StringBuffer sb = new StringBuffer();
	
	public int registrarUsuario(String login, String contrasenia){
		
		int id;
		try {
			
			conn = Coneccion.obtenerConeccion();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERTAR_USUARIO, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, contrasenia);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
		    rs.next();
		    id = rs.getInt(1);
			
		}catch(SQLException e){
			e.printStackTrace();
			id = 0;
		}
		
		return id;
	}
	
	public void registrarAprendiz(int idUsuario, String nombre, String apellido, Date fechaNacimiento, String correo) {

		try {

			conn = Coneccion.obtenerConeccion();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERTAR_APRENDIZ);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, apellido);
			preparedStatement.setDate(3, fechaNacimiento);
			preparedStatement.setString(4, correo);
			preparedStatement.setInt(5, idUsuario);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public String validarLogin(String usuario) {

		String password;
		try {
			conn = Coneccion.obtenerConeccion();
			PreparedStatement preparedStatement = conn.prepareStatement(VALIDAR_LOGIN);
			preparedStatement.setString(1, usuario);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.next()){
				password = resultado.getString("contrasenia");
			}
			else{
				password = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			password = null;
		}

		return password;

	}

	public boolean validarAdministrador(String usuario) {

		int administrador;
		try {
			conn = Coneccion.obtenerConeccion();
			PreparedStatement preparedStatement = conn.prepareStatement(VALIDAR_ADMIN);//preparar
			preparedStatement.setString(1, usuario);//reemplaza los ? por mis variables
			ResultSet resultado = preparedStatement.executeQuery();//ejecuta como tal en la BD
			if(resultado.next()){//me indica si hay resultados
				administrador = resultado.getInt("admin");
			}
			else{
				administrador = 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			administrador = 0;
		}
		
		boolean esAdministrador = false;
		if(administrador == 1){
			esAdministrador = true;
		}

		return esAdministrador;

	}

}
