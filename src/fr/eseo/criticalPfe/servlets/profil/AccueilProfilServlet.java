package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccueilProfilServlet
 */
@WebServlet("/AccueilProfil")
public class AccueilProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
        RequestDispatcher dispat = null;
        
        if (session.getAttribute("user") == null){
            dispat = request.getRequestDispatcher("Index");
            dispat.forward(request, response);
        }
        
        dispat = request.getRequestDispatcher("site/index.jsp");
        dispat.forward(request, response);
	}

}
