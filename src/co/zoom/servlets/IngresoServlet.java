package co.zoom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.zoom.dao.RegistroDao;

/**
 * Servlet implementation class IngresoServlet
 */
@WebServlet("/IngresoServlet")
public class IngresoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistroDao registroDao;	
    public IngresoServlet() {
        super();
       
        registroDao = new RegistroDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/formularioPrincipal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String passwordBd = registroDao.validarLogin(usuario);
		
		if(password.equals(passwordBd)){
			if(registroDao.validarAdministrador(usuario)){
				//redirigir a la pagina principal del admin
				response.sendRedirect("administradorServlet");
			}else{
				//redirigir a la pagina principal del usuario
				response.sendRedirect("usuarioServlet");
			}
			
		}else{
			request.getRequestDispatcher("/errorIngreso.jsp").forward(request, response);
		}
		
		
	}

}
