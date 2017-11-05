package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/AfficherAmis")
public class AfficherAmis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherAmis() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

		String pseudo_session = "";
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			/* Ici, nous placerons nos requêtes vers la BDD */
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			pseudo_session = (String) request.getSession().getAttribute("utilisateur");
			// Requete sql

			// select des "anciens" amis
			ResultSet resultat = statement.executeQuery("select * from ami where Login= '" + pseudo_session
					+ "' or Login_Utilisateur = '" + pseudo_session + "'");

			HttpSession session = request.getSession();
			ArrayList<String> ami = new ArrayList<>();

			while (resultat.next()) {
				if ((resultat.getString(1)).equals(pseudo_session)) {
					ami.add(resultat.getString(2));
				} else {
					ami.add(resultat.getString(1));
				}
			}
			session.setAttribute("amis", ami);

			// select des demandes envoyées
			resultat = statement.executeQuery("select Login_Utilisateur from demandeAmi where Login= '" + pseudo_session
					+ "' and etat = 'En_Attente'");

			ArrayList<String> demandesEnvoyees = new ArrayList<>();

			while (resultat.next()) {
				demandesEnvoyees.add(resultat.getString(1));
			}
			session.setAttribute("demandesEnvoyees", demandesEnvoyees);

			// select des demandes reçues
			resultat = statement.executeQuery("select Login from demandeAmi where Login_Utilisateur= '" + pseudo_session
					+ "' and etat = 'En_Attente'");

			ArrayList<String> demandesRecues = new ArrayList<>();

			while (resultat.next()) {
				demandesRecues.add(resultat.getString(1));
			}
			session.setAttribute("demandesRecues", demandesRecues);

			// select des demandes envoyées validées
			resultat = statement.executeQuery("select Login_Utilisateur from demandeAmi where Login= '" + pseudo_session
					+ "' and etat = 'Valide'");

			ArrayList<String> demandesValidees = new ArrayList<>();

			while (resultat.next()) {
				demandesValidees.add(resultat.getString(1));
			}
			session.setAttribute("demandesValidees", demandesValidees);

			// select personnes pas amis
			resultat = statement.executeQuery("SELECT `Login` FROM `utilisateur` WHERE Login not in "
					+ "(SELECT `Login` FROM `ami` WHERE `Login_Utilisateur` ='" + pseudo_session + "')"
					+ " and login not in (SELECT `Login_Utilisateur` FROM `ami` WHERE `Login` "
					+ "='" + pseudo_session + "') and login not in (SELECT `Login_Utilisateur` FROM `demandeAmi`"
					+ " WHERE `Login` ='" + pseudo_session + "') and login not in (SELECT `Login` FROM `demandeAmi"
					+ "` WHERE `Login_Utilisateur` ='" + pseudo_session + "') and login!='" + pseudo_session + "'");

			ArrayList<String> listeNonAmis = new ArrayList<>();

			while (resultat.next()) {
				listeNonAmis.add(resultat.getString(1));
			}
			session.setAttribute("listeNonAmis", listeNonAmis);

			for (String login : demandesValidees) {
				statement.executeUpdate("DELETE FROM `demandeami` WHERE `Login` = '" + pseudo_session
						+ "' and `Login_Utilisateur` = '" + login + "'");
			}
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
