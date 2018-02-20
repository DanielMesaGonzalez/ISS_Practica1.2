package Practica2_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookie2
 */
@WebServlet("/cookie2")
public class cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookie2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Servlet Test</title></head>");
		out.println("<body ><center><h1> THIS IS A SERVLET TEST </h1>");
		String pregunta = request.getParameter("username"); //este nombre es el que hay que cambiar en el html
		Cookie permanente= new Cookie("userIdCookie",pregunta);
		response.addCookie(permanente);
		out.println("<h2> The username is: " + permanente.getValue() + "</h2>");// usamos permanente.getvalue() para coger el valor de la cookie directamente
		out.println("</center></body></html>");
		out.close();
		
		permanente.setMaxAge(0); //Eliminamos la cookie indicando el tiempo a cero
		response.addCookie(permanente);
		
		doGet(request, response);
	}

}
