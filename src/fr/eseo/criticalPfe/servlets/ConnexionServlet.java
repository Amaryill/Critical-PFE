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
		    /* G�rer les �ventuelles erreurs ici. */
			System.out.println(e.toString());
		}
		
		/* Connexion � la base de donn�es */
		String url = "jdbc:mysql://localhost:3306/criticalpfe";  //� changer en fonction du nom de votre bdd
		
		/*informations de connexion � la bdd*/
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";
		
		//R�cup�ration des informations du formulaire signup.jsp
		String pseudo = (String) request.getParameter("pseudo");
	    String mdp = (String) request.getParameter("mdp");
		
	    
		Connection connexion = null;
		boolean confirmation = false;
		String mdpconfirme="";
		
		
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

		    /* Ici, nous placerons nos requ�tes vers la BDD */
		    /* Cr�ation de l'objet g�rant les requ�tes */
		    Statement statement = connexion.createStatement();
		    
		    //Requete sql
			ResultSet resultat = statement.executeQuery( "select u.password from utilisateur u where u.login='"+pseudo+"';");
		
			/* R�cup�ration des donn�es du r�sulat de la requ�te de lecture*/
			
			
			while (resultat.next()) {
				mdpconfirme = resultat.getString(1);				
			}
			
			/*traitement des donn�es*/
			
			if (mdp.contentEquals(mdpconfirme)){
				confirmation = true;
			} else {
				confirmation = false;
			}
			

		} catch ( SQLException e ) {
		    /* G�rer les �ventuelles erreurs ici */

			System.out.println(e.toString());
		} finally {
		    if ( connexion != null )
		        try {
		            /* Fermeture de la connexion */
		        	
		            connexion.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
		
		if (confirmation == true){
			HttpSession session = request.getSession();
			session.setAttribute(ATT_SESSION_USER, pseudo);
			session.setAttribute(ATT_USER, pseudo);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		doGet(request, response);
	}

}
