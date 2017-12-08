package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBO;
import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/ValiderAmis")
public class ValiderAmis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderAmis() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurBO utilisateurBO = new UtilisateurBOImpl();

		String pseudoValide = (String) request.getParameter("pseudo");
		String pseudo_session = (String) request.getSession().getAttribute("utilisateur");
		Utilisateur user = new Utilisateur();
		user.setPseudo(pseudo_session);
		
		utilisateurBO.validerAmi(user, pseudoValide);

		response.sendRedirect("AfficherAmis");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
