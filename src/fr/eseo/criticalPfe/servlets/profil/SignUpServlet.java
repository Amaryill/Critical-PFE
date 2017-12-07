package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.bdd.BddBo;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;
import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.dao.utilisateur.UtilisateurDAO;
import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		
		//Recuperation des informations du formulaire signup.jsp
		String login = (String) request.getParameter("login");
		String pseudo = (String) request.getParameter("pseudo");
		String email = (String) request.getParameter("email");
	    String mdp = (String) request.getParameter("mdp");
	    String mdpconfirme = request.getParameter("mdpconfirme");
	    
	    if(mdp.contentEquals(mdpconfirme)){
	    	utilisateur = new Utilisateur(pseudo,login,mdp,email,null,null,null,null);
	    	boUtilisateur = new UtilisateurBOImpl(new UtilisateurDAO());
	    	response.sendRedirect("/Critical-PFE/site/login.jsp");
	    }
	    
	    boUtilisateur.creerUtilisateur(utilisateur);
	    doGet(request,response);
	      
	    
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		BddBo bddBo = new BddBo();
//		Boolean erreur = false;
//		String msgErreur = "";
//		
//		HttpSession session = request.getSession();
//		
//		//R�cup�ration des informations du formulaire signup.jsp
//		String login = (String) request.getParameter("login");
//		String pseudo = (String) request.getParameter("pseudo");
//		String email = (String) request.getParameter("email");
//	    String mdp = (String) request.getParameter("mdp");
//	    String mdpconfirme = request.getParameter("mdpconfirme");
//		
//	    
//		if (mdp.contentEquals(mdpconfirme)){
//			bddBo.signUp(pseudo,login, mdp, email);
//			response.sendRedirect("/Critical-PFE/site/login.jsp");
//		}
//		
//		bddBo.close();
//		doGet(request,response);
//		
//	}

}