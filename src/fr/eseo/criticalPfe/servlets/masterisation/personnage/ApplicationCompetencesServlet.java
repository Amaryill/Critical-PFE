package fr.eseo.criticalPfe.servlets.masterisation.personnage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplicationCompetencesServlet
 */
@WebServlet(description = "Applique l'attribution des points de compétence", urlPatterns = { "/ApplicationCompetences" })
public class ApplicationCompetencesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationCompetencesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    if (session.getAttribute("utilisateur") == null) {
            request.getRequestDispatcher("Index").forward(request, response);
        }
        if (session.getAttribute("personnageCourant") == null) {
            request.getRequestDispatcher("AccueilProfil").forward(request, response);
        }
        
        String actionType = (String) session.getAttribute("action");
        System.out.println(actionType);
        request.getRequestDispatcher("/ChoixCompetences").forward(request, response);
	}

}
