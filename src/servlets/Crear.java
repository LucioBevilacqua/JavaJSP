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
@WebServlet("/Crear")
public class Crear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crear() {
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
		
		int total = Integer.parseInt(request.getParameter("energia"))+Integer.parseInt(request.getParameter("defensa"))+Integer.parseInt(request.getParameter("vida"))+Integer.parseInt(request.getParameter("evasion"));
		
		if(total<=200){
		
		Personaje p = new Personaje();
		
		p.setNombre(request.getParameter("nombre").toString());
		p.setEnergia(Integer.parseInt(request.getParameter("energia")));
		p.setDefensa(Integer.parseInt(request.getParameter("defensa")));
		p.setAtaque(Integer.parseInt(request.getParameter("vida")));
		p.setEvasion(Integer.parseInt(request.getParameter("evasion")));
		
		
		p.setPuntosTotales((int) (200-p.getAtaque()-p.getDefensa()-p.getEnergia()-p.getEvasion()));
		ctrlAdmin.add(p);
		request.getSession().setAttribute("error1", "");
	
		RequestDispatcher requestDispatcher; 
		requestDispatcher = request.getRequestDispatcher("menu.jsp");
		requestDispatcher.forward(request, response);
		}else{
			request.getSession().setAttribute("error1", "El puntaje total debe ser menor a 200");
			request.getRequestDispatcher("/CrearPersonaje.jsp").forward(request, response);	
		}
		
		
		
	}

}