package fr.eseo.criticalPfe.servlets.masterisation.univers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.java.bo.scenario.UniversBO;
import fr.eseo.criticalPfe.java.bo.scenario.UniversBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

/**
 * Servlet implementation class UpdateUnivers
 */
@WebServlet("/UpdateUnivers")
public class UpdateUnivers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUnivers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UniversBO boUnivers = new UniversBOImpl();
		Univers univers = (Univers) request.getSession().getAttribute("univers");
		String nomUnivers = request.getParameter("nomUnivers");
		String descriptionUnivers = request.getParameter("descriptionUnivers");

		if (nomUnivers != null && !nomUnivers.equals("") && !nomUnivers.isEmpty()) {
			univers.setNomUnivers(nomUnivers);
		}
		if (descriptionUnivers != null && !descriptionUnivers.equals("") && !descriptionUnivers.isEmpty()) {
			univers.setDescription(descriptionUnivers);
		} else if(univers.getDescription() == null){
			univers.setDescription("*Insérer une description*");
		}
		boUnivers.modifierUnivers(univers);
		response.sendRedirect("/Critical-PFE/AfficherUnivers");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
