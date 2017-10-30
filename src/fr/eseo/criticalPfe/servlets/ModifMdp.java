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
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/criticalpfe";  //à changer en fonction du nom de votre bdd
		
		/*informations de connexion à la bdd*/
		String utilisateur_Bdd = "Critical";
		String motDePasseBdd = "19950921";
		Connection connexion = null;
		try {
		    connexion = DriverManager.getConnection( url, utilisateur_Bdd, motDePasseBdd );
		    /* Ici, nous placerons nos requêtes vers la BDD */
		    /* Création de l'objet gérant les requêtes */
		    Statement statement = connexion.createStatement();
		    String mdp_ancien = (String) request.getParameter("mdp_ancien");
		    String mdp_nouveau = (String) request.getParameter("mdp_nouveau");
		    String confirmer =(String) request.getParameter("confirmer");
		    String utilisateur1 =(String)request.getSession().getAttribute("utilisateur");
		    String mdpBdd = "";
		    
		    //Récupération mdp BDD
		    Statement statementMdp = connexion.createStatement();
		    ResultSet resultatMdpBdd = statementMdp.executeQuery("select password from utilisateur where login='"+utilisateur1+"';");
		    try{
		    	while(resultatMdpBdd.next()){
		    		mdpBdd = resultatMdpBdd.getString("password");
		    	}
		    } catch (SQLException e){
		    	
		    }
		    
		    //Requete sql
		    if (confirmer.contentEquals(mdp_ancien) && mdp_ancien.contentEquals(mdpBdd)){
				int resultat = statement.executeUpdate( "update utilisateur set password='"+mdp_nouveau+"' where password='"+mdp_ancien+"';");
				
		    } else {
		    	System.out.println("Je suis dans le else");
		    	response.sendRedirect("profil.jsp");
		    }
			
			
			
		} catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
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
		
		response.sendRedirect("profil.jsp");
		
		
		
		doGet(request, response);
	}

}
