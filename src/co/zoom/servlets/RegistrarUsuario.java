package co.zoom.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.zoom.dao.RegistroDao;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RegistroDao registroDao;

	public RegistrarUsuario() {
		super();
		registroDao = new RegistroDao();

	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/formularioRegistro.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/paginaPresentacion.jsp").forward(request, response);
		
		String usuario = request.getParameter("usuario");
		String contrasenia = request.getParameter("contrasenia");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String fechaNacimiento = request.getParameter("nacimiento");
		String correo = request.getParameter("correo");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	    Date parsed = new Date();
		try {
			parsed = format.parse(fechaNacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    
		
		int idUsuario = registroDao.registrarUsuario(usuario, contrasenia);
		registroDao.registrarAprendiz(idUsuario, nombre, apellido, sql, correo );
		
	}

}
