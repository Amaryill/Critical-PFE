package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/ModifPseudo")
public class ModifPseudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifPseudo() {
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
		UtilisateurBOImpl boUtilisateur = null;
		Utilisateur utilisateur = null;
		
		String pseudo_ancien = (String) request.getParameter("pseudo_ancien");
		String pseudo_nouveau = (String) request.getParameter("pseudo_nouveau");
		String pseudo_session = (String) request.getSession().getAttribute("utilisateur");
		
		if (pseudo_session.contentEquals(pseudo_ancien)){
			boUtilisateur = new UtilisateurBOImpl();
			utilisateur = new Utilisateur();
			utilisateur.setLogin((String) session.getAttribute("utilisateur"));
			utilisateur = boUtilisateur.pullUtilisateur(utilisateur);
			
			utilisateur.setPseudo(pseudo_nouveau);
			
			boUtilisateur.modifUtilisateur(utilisateur);
			
			session.setAttribute(ATT_SESSION_USER, pseudo_nouveau);
			session.setAttribute(ATT_USER, pseudo_nouveau);
			
			response.sendRedirect("/Critical-PFE/site/options.jsp");
		} else {
			response.sendRedirect("/Critical-PFE/site/options.jsp");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		BddBo bddBo = new BddBo();
//		Boolean erreur = false;
//		String msgErreur = "";
//		
//		HttpSession session = request.getSession();
//
//		String pseudo_ancien = (String) request.getParameter("pseudo_ancien");
//		String pseudo_nouveau = (String) request.getParameter("pseudo_nouveau");
//		String pseudo_session = (String)request.getSession().getAttribute("utilisateur");
//		
//		if (pseudo_session.contentEquals(pseudo_ancien)){
//			bddBo.modifPseudo(pseudo_ancien, pseudo_nouveau);
//			session.setAttribute(ATT_SESSION_USER, pseudo_nouveau);
//			session.setAttribute(ATT_USER, pseudo_nouveau);
//			response.sendRedirect("/Critical-PFE/site/options.jsp");
//		} else {
//			response.sendRedirect("/Critical-PFE/site/options.jsp");
//		}
//		
//		doGet(request, response);
//	}

}
