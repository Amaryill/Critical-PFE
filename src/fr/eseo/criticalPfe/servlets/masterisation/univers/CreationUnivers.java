package fr.eseo.criticalPfe.servlets.masterisation.univers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.UniversBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/CreationUnivers")
public class CreationUnivers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUnivers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		UniversBOImpl universBO = new UniversBOImpl();
		String utilisateur = (String)session.getAttribute("utilisateur");
		Univers univers = universBO.creationUnivers(utilisateur);
		session.setAttribute("univers", univers);
			
		response.sendRedirect("/Critical-PFE/AfficherUnivers");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
