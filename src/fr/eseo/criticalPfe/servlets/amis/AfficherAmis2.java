package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.bdd.BddBoAmi;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/AfficherAmis2")
public class AfficherAmis2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherAmis2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BddBoAmi bddBo = new BddBoAmi();
		String pseudo_session = "";
		try {
			pseudo_session = (String) request.getSession().getAttribute("utilisateur");

			HttpSession session = request.getSession();

			ArrayList<String> ami = bddBo.getListeAmi(pseudo_session);
			session.setAttribute("amis", ami);

			ArrayList<String> demandesEnvoyees = bddBo.getDemandesEnvoyees(pseudo_session);
			session.setAttribute("demandesEnvoyees", demandesEnvoyees);

			ArrayList<String> demandesRecues = bddBo.getDemandesRecues(pseudo_session);
			session.setAttribute("demandesRecues", demandesRecues);

			ArrayList<String> demandesValidees = bddBo.getDemandesValidees(pseudo_session);
			session.setAttribute("demandesValidees", demandesValidees);

			ArrayList<String> listeNonAmis = bddBo.getNonAmi(pseudo_session);
			session.setAttribute("listeNonAmis", listeNonAmis);

			
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(e.toString());

		}

		response.sendRedirect("ami.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
