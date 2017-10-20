package fr.eseo.criticalPfe.servlets;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/ModifPseudo")
public class ModifPseudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifPseudo() {
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
		}
		/* Connexion � la base de donn�es */
		String url = "jdbc:mysql://localhost:3306/criticalpfe";  //� changer en fonction du nom de votre bdd
		
		/*informations de connexion � la bdd*/
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";
		Connection connexion = null;

		String pseudo_ancien = (String) request.getParameter("pseudo_ancien");
		String pseudo_nouveau = (String) request.getParameter("pseudo_nouveau");
		String pseudo_session = "";
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    /* Ici, nous placerons nos requ�tes vers la BDD */
		    /* Cr�ation de l'objet g�rant les requ�tes */
		    Statement statement = connexion.createStatement();
		    pseudo_session=(String)request.getSession().getAttribute("utilisateur");
		    //Requete sql
		    if (pseudo_session.contentEquals(pseudo_ancien)){
				int resultat = statement.executeUpdate( "update utilisateur set login='"+pseudo_nouveau+"' where login='"+pseudo_ancien+"';");
				HttpSession session = request.getSession();
				session.setAttribute(ATT_SESSION_USER, pseudo_nouveau);
				session.setAttribute(ATT_USER, pseudo_nouveau);
		    } else {
		    	response.sendRedirect("profil.jsp");
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
		
		response.sendRedirect("profil.jsp");
		
		
		
		doGet(request, response);
	}

}
