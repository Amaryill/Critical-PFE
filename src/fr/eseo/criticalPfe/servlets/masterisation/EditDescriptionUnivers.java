package fr.eseo.criticalPfe.servlets.masterisation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.UniversBO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/EditDescriptionUnivers")
public class EditDescriptionUnivers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDescriptionUnivers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UniversBO universBO = new UniversBO();
		System.out.println(request.getParameter("idUnivers"));
		int idUnivers = Integer.parseInt(request.getParameter("idUnivers"));
		String nouvelleDescriptionUnivers = request.getParameter("my-textarea");
		universBO.editDescriptionUnivers(idUnivers,nouvelleDescriptionUnivers);

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
