package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBO;
import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class ModifPresentation
 */
@WebServlet("/ModifPresentation")
public class ModifPresentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_PRES         = "presentation";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifPresentation() {
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
		HttpSession session = request.getSession();
		UtilisateurBO boUtilisateur = new UtilisateurBOImpl();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		
		String presentation = (String) request.getParameter("presentation");
		
		utilisateur.setPresentation(presentation);
		boUtilisateur.modifUtilisateur(utilisateur);
		
		session.setAttribute("user", utilisateur);
		
		response.sendRedirect("/Critical-PFE/site/Profil/profil.jsp");
		
		
		doGet(request, response);
	}

}
