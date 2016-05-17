package co.zoom.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.zoom.dao.SubtemaDao;
import co.zoom.modelo.Subtema;

/**
 * Servlet implementation class SubtemaServlet
 */
@WebServlet("/SubtemaServlet")
public class SubtemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubtemaDao subtemaDao;
       
    public SubtemaServlet() {
        super();
        subtemaDao =  new SubtemaDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subtema> subtemas = subtemaDao.obtenerSubtemas();
		request.setAttribute("subtemas", subtemas);
		request.getRequestDispatcher("/formularioSubtemas.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		String tema = request.getParameter("tema");
		
		switch (accion) {
			case "modificar":
				modificarSubtema(nombre, id);
				break;
			case "borrar":
				eliminarSubtema(id);
				break;
	
			case "guardar":
				guardarSubtema(nombre, tema);
				break;
	
			default:
				break;
		}
	}


	private void guardarSubtema(String nombre, String tema) {
		subtemaDao.guardarSubtema(nombre, Integer.parseInt(tema));
		
	}


	private void eliminarSubtema(String id) {
		subtemaDao.eliminarSubtema(Integer.parseInt(id));
		
	}


	private void modificarSubtema(String nombre, String id) {
		subtemaDao.modificarSubtema(nombre, Integer.parseInt(id));
		
	}

}
