package fr.eseo.criticalPfe.servlets.profil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.bdd.BddBo;

/**
 * Servlet implementation class ModifMdp
 */
@WebServlet("/ModifMdp")
public class ModifMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifMdp() {
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
		BddBo bddBo = new BddBo();
		Boolean erreur = false;
		String msgErreur = "";

		HttpSession session = request.getSession();	


		/* Ici, nous placerons nos requ�tes vers la BDD */
		/* Cr�ation de l'objet g�rant les requ�tes */
		String mdp_ancien = (String) request.getParameter("mdp_ancien");
		String mdp_nouveau = (String) request.getParameter("mdp_nouveau");
		String confirmer =(String) request.getParameter("confirmer");
		String utilisateur1 =(String)request.getSession().getAttribute("utilisateur");
		
		String mdpBdd="";
		try {
			mdpBdd = bddBo.getMdp(utilisateur1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//Requete sql
		if (confirmer.contentEquals(mdp_ancien) && mdp_ancien.contentEquals(mdpBdd)){
			bddBo.modifMdp(utilisateur1, mdp_nouveau);
			response.sendRedirect("/Critical-PFE/site/options.jsp");
		} else {
			response.sendRedirect("/Critical-PFE/site/options.jsp");
		}



		doGet(request, response);
	}

}
