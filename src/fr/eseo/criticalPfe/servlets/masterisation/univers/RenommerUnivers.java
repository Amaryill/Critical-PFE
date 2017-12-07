package fr.eseo.criticalPfe.servlets.masterisation.univers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.java.bo.scenario.UniversBOImpl;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/RenommerUnivers")
public class RenommerUnivers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenommerUnivers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UniversBOImpl universBO = new UniversBOImpl();
		int idUnivers = Integer.parseInt(request.getParameter("idUnivers"));
		String nouveauNomUnivers = request.getParameter("nomUnivers");
		universBO.renommerUnivers(idUnivers,nouveauNomUnivers);

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
