package servlets;

import java.io.IOException;

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
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
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
		Personaje per = ctrlAdmin.getPersonaje(p);
		if(per!=null){
		
		
		request.getSession().setAttribute("error2", "");
		request.getSession().setAttribute("nombre", per.getNombre().toString());
		request.getSession().setAttribute("energia", per.getEnergia());
		request.getSession().setAttribute("ataque", per.getAtaque());
		request.getSession().setAttribute("defensa", per.getDefensa());
		request.getSession().setAttribute("evasion", per.getEvasion());
		request.getSession().setAttribute("totales", per.getPuntosTotales());
		
		request.getRequestDispatcher("/BuscarPersonaje.jsp").forward(request, response);	
		}else{
			request.getSession().setAttribute("error2", "Personaje no encontrado");
			request.getRequestDispatcher("/BuscarPersonaje.jsp").forward(request, response);	
		}
		
		
		
	}

}