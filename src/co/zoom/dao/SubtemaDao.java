package co.zoom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.zoom.modelo.Subtema;
import co.zoom.util.Coneccion;

public class SubtemaDao {
	
	private static final String INSERTAR_SUBTEMA = "INSERT INTO zoom.subtemas (nombre_tema, temas) VALUES (?, ?)";
	private static final String MODIFICAR_SUBTEMA ="UPDATE zoom.subtemas set nombre_tema = ? where id =?";
	private static final String ELIMINAR_SUBTEMA ="DELETE FROM zoom.subtemas where id = ?";
	private static final String BUSCAR_SUBTEMA ="SELECT id, nombre_tema FROM subtemas";
	Connection conn = null;
	
	public int guardarSubtema(String nombre, int tema)
	{
	   	int resultado;
	   	
	   	try{
	   		conn = Coneccion.obtenerConeccion();
	   		PreparedStatement preparedStatement = conn.prepareStatement(INSERTAR_SUBTEMA);
	   		preparedStatement.setString(1, nombre);
	   		preparedStatement.setInt(2, tema);
	   		resultado = preparedStatement.executeUpdate();
	   		}catch(SQLException e){
				e.printStackTrace();
				resultado = 0;
	   		}
	   	
	   	return resultado;
	}

	public int modificarSubtema(String nombre, int id)
	{
	   	int resultado;
	   	
	   	try{
	   		conn = Coneccion.obtenerConeccion();
	   		PreparedStatement preparedStatement = conn.prepareStatement(MODIFICAR_SUBTEMA);
	   		preparedStatement.setString(1, nombre);
	   		preparedStatement.setInt(2, id);
	   		resultado = preparedStatement.executeUpdate();
	   		}catch(SQLException e){
				e.printStackTrace();
				resultado = 0;
	   		}
	   	return resultado;
	}
	
	public int eliminarSubtema(int id)
	{
	   	int resultado;
	   	
	   	try{
	   		conn = Coneccion.obtenerConeccion();
	   		PreparedStatement preparedStatement = conn.prepareStatement(ELIMINAR_SUBTEMA);
	   		preparedStatement.setInt(1, id);
	   		resultado = preparedStatement.executeUpdate();
	   		}catch(SQLException e){
				e.printStackTrace();
				resultado = 0;
	   		}
	   	return resultado;
	}
	
	public List<Subtema> obtenerSubtemas(){
		List<Subtema> subtema = new ArrayList<Subtema>();
		try{
			conn = Coneccion.obtenerConeccion();
			PreparedStatement preparedStatement = conn.prepareStatement(BUSCAR_SUBTEMA);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()){
				Subtema subtemas = new Subtema();
				subtemas.setId(resultado.getInt("id"));
				subtemas.setNombre(resultado.getString("nombre_tema"));
				subtema.add(subtemas);
			}
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return subtema;
	}
}
