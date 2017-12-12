package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.entite.PersonnageBO;
import fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl;
import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_PRES         = "presentation";
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		UtilisateurBOImpl boUtilisateur = null;
		Utilisateur utilisateur = null;
		//initilisation des variables pour la session
		String userLogin = null;
		String userPassword = null;
		String presentation = null;
		//Recuperation des informations du formulaire signup.jsp
		userLogin = (String) request.getParameter("login");
	    userPassword = (String) request.getParameter("mdp");
	    
	    
	    utilisateur = new Utilisateur(null,userLogin,userPassword,null,null,null,null,null);
	    boUtilisateur = new UtilisateurBOImpl();
	    PersonnageBO boPersonnage = new PersonnageBOImpl();
	    
	    utilisateur = boUtilisateur.pullUtilisateur(utilisateur);
	    utilisateur.setPersonnages(boPersonnage.trouverPersonnageParUtilisateur(utilisateur.getPseudo()));
	    if (utilisateur.getPassword().contentEquals(userPassword)){
	    	//attribution des variables session	
	    
	    	session.setAttribute("user", utilisateur);
			session.setAttribute(ATT_SESSION_USER, utilisateur.getPseudo());
			session.setAttribute(ATT_USER, utilisateur.getPseudo());
			session.setAttribute(ATT_PRES, presentation);
	    	response.sendRedirect("site/index.jsp");
	    } else {
	    	response.sendRedirect("site/login.jsp");
	    }
	    
	    
	}

}
