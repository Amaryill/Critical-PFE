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

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
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
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/criticalpfe";  //à changer en fonction du nom de votre bdd
		
		/*informations de connexion à la bdd*/
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";
		
		//Récupération des informations du formulaire signup.jsp
		String pseudo = (String) request.getParameter("pseudo");
	    String mdp = (String) request.getParameter("mdp");
		
		Connection connexion = null;
		boolean confirmation = false;
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

		    /* Ici, nous placerons nos requêtes vers la BDD */
		    /* Création de l'objet gérant les requêtes */
		    Statement statement = connexion.createStatement();
		    
		    //Requete sql
			ResultSet resultat = statement.executeQuery( "select u.password from utilisateur u where u.login='test';");
			
			/* Récupération des données du résulat de la requête de lecture*/
			String mdpconfirme="";
			
			while (resultat.next()) {
				System.out.println("I'm in while");
				mdpconfirme = resultat.getString("password");
			}
			
			/*traitement des données*/
			if (mdpconfirme == mdp){
				confirmation = true;
			} else {
				confirmation = false;
			}
			

		} catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */

			System.out.println(e.toString());
		} finally {
		    if ( connexion != null )
		        try {
		            /* Fermeture de la connexion */
		        	System.out.println("connexion établie");
		        	
		            connexion.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
		
		if (confirmation == true){
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		doGet(request, response);
	}

}
