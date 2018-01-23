package fr.eseo.criticalPfe.servlets.masterisation.personnage;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.entite.ClasseBOImpl;
import fr.eseo.criticalPfe.java.bo.entite.RaceBOImpl;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Race;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/CreationPersonnage")
public class CreationPersonnageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationPersonnageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispat = null;
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if(user == null){
		    request.getRequestDispatcher("/Index").forward(request, response);
		}
		List<Race> races = new RaceBOImpl().trouverToutesRaces();
		List<Classe> classes = new ClasseBOImpl().trouverToutesClasses();
		// ATTENTION : dieux pas sur la bdd -> éviter menu déroulant?
		
		session.setAttribute("races", races);
		session.setAttribute("classes", classes);
		
		dispat = request.getRequestDispatcher("site/Masterisation/creationPersonnage.jsp");
		dispat.forward(request, response);
	}


}
