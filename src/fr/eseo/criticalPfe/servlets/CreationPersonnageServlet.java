package fr.eseo.criticalPfe.servlets;

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

@WebServlet("/CreationPersonnageServlet")
public class CreationPersonnageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ATT_FOR = "Force_";
	private static final String ATT_DEX = "Dexterite";
	private static final String ATT_CON = "Constitution";
	private static final String ATT_INT = "Intelligence";
	private static final String ATT_SAG = "Sagesse";
	private static final String ATT_CHA = "Charisme";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationPersonnageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPostCreationPersonnage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			/* Gérer les éventuelles erreurs ici. */
			System.out.println(e.toString());
		}

		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/criticalpfe"; // à changer en
																// fonction du
																// nom de votre
																// bdd

		/* informations de connexion à la bdd */
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";
		Connection connexion = null;

		String nomPersonnage = (String) request.getParameter("nom");
		String race = (String) request.getParameter("race");
		String classe = (String) request.getParameter("classe");
		String alignement = (String) request.getParameter("alignement");
		String dieu = (String) request.getParameter("dieu");
		String sexe = (String) request.getParameter("sexe");
		int age = Integer.parseInt((String) request.getParameter("age"));
		int taille = Integer.parseInt((String) request.getParameter("taille"));
		int poids = Integer.parseInt((String) request.getParameter("poids"));
		String couleurYeux = (String) request.getParameter("couleurYeux");
		String couleurCheveux = (String) request.getParameter("couleurCheveux");
		int force = Integer.parseInt((String) request.getParameter("for"));
		int dexterite = Integer.parseInt((String) request.getParameter("dex"));
		int constitution = Integer.parseInt((String) request.getParameter("con"));
		int intelligence = Integer.parseInt((String) request.getParameter("int"));
		int sagesse = Integer.parseInt((String) request.getParameter("sag"));
		int charisme = Integer.parseInt((String) request.getParameter("cha"));

		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			/* Ici, nous placerons nos requêtes vers la BDD */
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			// Requete sql

			statement.executeUpdate(
					"INSERT INTO Caracteristiques(Force_, Dexterite, Constitution, Intelligence, Sagesse, Charisme) "
							+ "VALUES (" + force + "," + dexterite + "," + constitution + "," + intelligence + ","
							+ sagesse + "," + charisme + ");");

			statement.executeUpdate(
					"INSERT INTO Personnage(Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux, Age, Taille, Poids) "
							+ "VALUES(" + alignement + "," + dieu + "," + sexe + "," + couleurYeux + ","
							+ couleurCheveux + "," + age + "," + taille + "," + poids + ");");

			

		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(e.toString());
		} finally {
			if (connexion != null)
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException ignore) {
					/*
					 * Si une erreur survient lors de la fermeture, il suffit de
					 * l'ignorer.
					 */
				}

		}

		doGet(request, response);
	}

}
