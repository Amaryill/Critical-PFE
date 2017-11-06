package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/SupprimerAmis")
public class SupprimerAmis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerAmis() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			/* Gérer les éventuelles erreurs ici. */
		}
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/criticalpfe";

		/* informations de connexion à la bdd */
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";
		Connection connexion = null;

		String pseudoDemande = (String) request.getParameter("pseudo");

		String pseudo_session = "";
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			/* Ici, nous placerons nos requêtes vers la BDD */
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			pseudo_session = (String) request.getSession().getAttribute("utilisateur");
			// Requete sql

			statement.executeUpdate("DELETE FROM `ami` WHERE (`Login`='" + pseudo_session
					+ "' AND `Login_Utilisateur` = '" + pseudoDemande + "') OR (`Login`='" + pseudoDemande
					+ "' AND `Login_Utilisateur` = '" + pseudo_session + "')");

		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(e.toString());
		} finally {
			if (connexion != null) {
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException ignore) {
				}
			}

		}

		response.sendRedirect("AfficherAmis");
		doGet(request, response);
	}

}
