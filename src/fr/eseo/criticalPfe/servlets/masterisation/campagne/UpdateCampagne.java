package fr.eseo.criticalPfe.servlets.masterisation.campagne;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.CampagneBO;
import fr.eseo.criticalPfe.java.bo.scenario.CampagneBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;

/**
 * Servlet implementation class UpdateCampagne
 */
@WebServlet("/UpdateCampagne")
public class UpdateCampagne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCampagne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CampagneBO boCampagne = new CampagneBOImpl();
		HttpSession session = request.getSession();
		Campagne campagne = (Campagne) session.getAttribute("campagne");
		String nomCampagne = request.getParameter("nomCampagne");
		String descriptionCampagne = request.getParameter("descriptionCampagne");

		System.out.println("request : " + nomCampagne);
		System.out.println("Campagne : " + campagne.getNomCampagne());

		if (nomCampagne != null && !nomCampagne.equals("") && !nomCampagne.isEmpty()) {
			campagne.setNomCampagne(nomCampagne);
		}
		if (descriptionCampagne != null && !descriptionCampagne.equals("") && !descriptionCampagne.isEmpty()) {
			campagne.setDescription(descriptionCampagne);
		} else if (campagne.getDescription() == null) {
			campagne.setDescription("*Insérer une description*");
		}
		boCampagne.modifierCampagne(campagne);
		session.setAttribute("campagne", campagne);
		response.sendRedirect("/Critical-PFE/AfficherCampagne");

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
