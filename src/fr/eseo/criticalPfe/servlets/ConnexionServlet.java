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

		
	}

}
