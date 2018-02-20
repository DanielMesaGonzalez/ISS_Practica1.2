package Practica1_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cookie1
 */
@WebServlet("/cookie1")
public class cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookie1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);//Devuelve el objeto sesi�n si ya existe, O LO CREA NUEVO
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.print("<strong>");
		Date date = (Date)sesion.getAttribute("date");
		if(date != null) {
			
		            html.print("�ltimo acceso de la sesi�n: " + date + "<br>");
		}
		
		else {
			
		            html.print("Este es el primer acceso de la sesi�n <br>");
		            
		}
		      date = new Date();   //Este objeto devuelve la fecha 
		      sesion.setAttribute("date", date);
		      html.print("Fecha actual: " + date);
		      html.print("</strong>");
		      sesion.setMaxInactiveInterval(3); // Tiempo m�ximo de inactividad por parte del cliente  
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
