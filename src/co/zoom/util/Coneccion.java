package co.zoom.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Coneccion {
	
	private static Connection CONN;
	
	private static void conectar(){
		
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/zoom");
			
			CONN = ds.getConnection();
	
		}catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection obtenerConeccion(){
		
		if(CONN == null){
			conectar();
		}
		
		return CONN;
	}

}
