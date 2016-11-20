package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ctrl.ABMCPersonaje;
import entidades.Personaje;


/**
 * Servlet implementation class start
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/*String ctrlId = request.getParameter("ctrl");
		ABMCPersonaje ctrl = (ABMCPersonaje) request.getSession().getAttribute(ctrlId);		
		request.getSession().removeAttribute(ctrlId);*/
		
		ABMCPersonaje ctrlAdmin = new ABMCPersonaje();
		ServletContext context = getServletContext();
		context.setAttribute("ctrlAdmin", ctrlAdmin);
		
		Personaje p = new Personaje();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		
		ctrlAdmin.delete(p);
		
	
		RequestDispatcher requestDispatcher; 
		requestDispatcher = request.getRequestDispatcher("menu.jsp");
		requestDispatcher.forward(request, response);

		
		
		
	}

}