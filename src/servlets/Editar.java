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
@WebServlet("/Editar")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar() {
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
		Personaje p1 = new Personaje();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		
		p1 = ctrlAdmin.getPersonaje(p);
		
		p.setNombre(request.getParameter("nombre").toString());
		p.setEnergia(Integer.parseInt(request.getParameter("energia")));
		p.setDefensa(Integer.parseInt(request.getParameter("defensa")));
		p.setAtaque(Integer.parseInt(request.getParameter("vida")));
		p.setEvasion(Integer.parseInt(request.getParameter("evasion")));
		p.setPuntosTotales((int) (p1.getPuntosTotales()+p1.getAtaque()+p1.getEnergia()+p1.getEvasion()+p1.getDefensa()-p.getAtaque()-p.getDefensa()-p.getEnergia()-p.getEvasion()));
		if((p1.getPuntosTotales()+p1.getAtaque()+p1.getEnergia()+p1.getEvasion()+p1.getDefensa()-p.getAtaque()-p.getDefensa()-p.getEnergia()-p.getEvasion())>= 0){
			ctrlAdmin.update(p);
			RequestDispatcher requestDispatcher; 
			requestDispatcher = request.getRequestDispatcher("menu.jsp");
			requestDispatcher.forward(request, response);
		}else{ 
			request.getSession().setAttribute("error3", "no tienes suficientes puntos");
			request.getRequestDispatcher("/EditarPersonaje.jsp").forward(request, response);
		}
		
		
	
		

		
		
		
	}

}