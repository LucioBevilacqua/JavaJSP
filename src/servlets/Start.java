package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Personaje;
import ctrl.ABMCPersonaje;

/**
 * Servlet implementation class start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
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
		
		ABMCPersonaje ctrl = new ABMCPersonaje();
		Personaje p1= new Personaje();
		p1.setId(Integer.parseInt(request.getParameter("Personaje1")));
		Personaje p2= new Personaje();
		p2.setId(Integer.parseInt(request.getParameter("Personaje2")));
		p1=ctrl.getPersonaje(p1);
		p2=ctrl.getPersonaje(p2);
	
		//response.getWriter().append("P1: ").append(p1.getNombre()+" "+p1.getApellido());
		//response.getWriter().append("P2: ").append(p2.getNombre()+" "+p2.getApellido());
		ctrl.setPersonajes(p1, p2);
		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		ServletContext context = getServletContext();
		context.setAttribute("CTRL", ctrl);
		//request.getSession().setAttribute("CTRL", ctrl);
		
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("WEB-INF/war.jsp").forward(request, response);
		
		
		
	}

}