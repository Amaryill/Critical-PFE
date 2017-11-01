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

import fr.eseo.criticalPfe.bdd.BddBo;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
	  
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
		
		BddBo bddBo = new BddBo();
		Boolean erreur = false;
		String msgErreur = "";
		
		HttpSession session = request.getSession();
		
		//initilisation des variables
		String userLogin = null;
		String userPassword = null;
		String mail = null;
		
		userLogin = (String)request.getParameter("pseudo");
		userPassword = (String) request.getParameter("mdp");
		
		String[] result = bddBo.getUser(userLogin, userPassword);
		
		if (result[0] != null){
			userLogin = result[0];
			userPassword = result[1];
			mail = result[2];
			//attribution des variables session
			session.setAttribute(ATT_SESSION_USER, userLogin);
			session.setAttribute(ATT_USER, userLogin);

			response.sendRedirect("index.jsp");
		
		} else {//si l'utilisateur n'est pas valide
			session.invalidate();
			erreur = true;
			msgErreur ="Utilisateur invalide";
			response.sendRedirect("login.jsp");
		}
		
		bddBo.close();
		doGet(request, response);
		
		
		
//		try {
//		    Class.forName( "com.mysql.jdbc.Driver" );
//		} catch ( ClassNotFoundException e ) {
//		    /* Gérer les éventuelles erreurs ici. */
//			System.out.println(e.toString());
//		}
//		
//		/* Connexion à la base de données */
//		String url = "jdbc:mysql://localhost:3306/criticalpfe";  //à changer en fonction du nom de votre bdd
//		
//		/*informations de connexion à la bdd*/
//		String utilisateur = "Critical";
//		String motDePasse = "19950921";
//		
//		//Récupération des informations du formulaire signup.jsp
//		String pseudo = (String) request.getParameter("pseudo");
//	    String mdp = (String) request.getParameter("mdp");
//		
//	    
//		Connection connexion = null;
//		boolean confirmation = false;
//		String mdpconfirme="";
//		
//		
//		try {
//		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
//
//		    /* Ici, nous placerons nos requêtes vers la BDD */
//		    /* Création de l'objet gérant les requêtes */
//		    Statement statement = connexion.createStatement();
//		    
//		    //Requete sql
//			ResultSet resultat = statement.executeQuery( "select u.password from utilisateur u where u.login='"+pseudo+"';");
//		
//			/* Récupération des données du résulat de la requête de lecture*/
//			
//			
//			while (resultat.next()) {
//				mdpconfirme = resultat.getString(1);				
//			}
//			
//			/*traitement des données*/
//			
//			if (mdp.contentEquals(mdpconfirme)){
//				confirmation = true;
//			} else {
//				confirmation = false;
//			}
//			
//
//		} catch ( SQLException e ) {
//		    /* Gérer les éventuelles erreurs ici */
//
//			System.out.println(e.toString());
//		} finally {
//		    if ( connexion != null )
//		        try {
//		            /* Fermeture de la connexion */
//		        	
//		            connexion.close();
//		        } catch ( SQLException ignore ) {
//		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
//		        }
//		}
//		
//		if (confirmation == true){
//			HttpSession session = request.getSession();
//			session.setAttribute(ATT_SESSION_USER, pseudo);
//			session.setAttribute(ATT_USER, pseudo);
//			response.sendRedirect("index.jsp");
//		} else {
//			response.sendRedirect("login.jsp");
//		}
		
	}

}
