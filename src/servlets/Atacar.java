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


/**
 * Servlet implementation class start
 */
@WebServlet("/Atacar")
public class Atacar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atacar() {
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
		
		ServletContext context = getServletContext();
		String resultado;
		/*String ctrlId = request.getParameter("ctrl");
		ABMCPersonaje ctrl = (ABMCPersonaje) request.getSession().getAttribute(ctrlId);		
		request.getSession().removeAttribute(ctrlId);*/
		
		ABMCPersonaje ctrl = (ABMCPersonaje)context.getAttribute("CTRL");
		
		
		if(ctrl.getTurnoActual().getEnergia() >= Integer.parseInt(request.getParameter("tEnergia"))){
			ctrl.atacar(Integer.parseInt(request.getParameter("tEnergia")));
			
			request.getSession().setAttribute("error", "");
		}else{
			request.getSession().setAttribute("error", "Energia insuficiente");
			ctrl.getTurno();
		}
		if(ctrl.getP1().getAtaque()<=0||ctrl.getP2().getAtaque()<=0){
			if(ctrl.getP1().getAtaque()<=0){
				notifyUser("FIN DEL JUEGO " + ctrl.getP2().getNombre() + " es el ganador \n Se acreditaron 10 puntos para gastar");
				resultado= "FIN DEL JUEGO " + ctrl.getP2().getNombre() + " es el ganador \n Se acreditaron 10 puntos para gastar";
				ctrl.acreditarPuntos(ctrl.getP2());
				ctrl.clearPersonajes();
			}else{
				notifyUser("FIN DEL JUEGO\n " + ctrl.getP1().getNombre() + " es el ganador \n Se acreditaron 10 puntos para gastar");
				resultado= "FIN DEL JUEGO\n " + ctrl.getP1().getNombre() + " es el ganador \n Se acreditaron 10 puntos para gastar";
				ctrl.acreditarPuntos(ctrl.getP1());
				ctrl.clearPersonajes();
			}
			
			request.getSession().setAttribute("resultado", resultado);
			RequestDispatcher requestDispatcher; 
			requestDispatcher = request.getRequestDispatcher("/menu.jsp");
			requestDispatcher.forward(request, response);
		}else{	
		
			request.getRequestDispatcher("WEB-INF/war.jsp").forward(request, response);	
		}
		
	}

	private void notifyUser(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}