package fr.eseo.criticalPfe.servlets.masterisation.campagne;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/AfficherCampagne")
public class AfficherCampagne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherCampagne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		CampagneBO boCampagne = new CampagneBOImpl();
		Campagne campagne = new Campagne();
		if (request.getParameter("idCampagne") != null) {
			campagne.setId(Integer.parseInt(request.getParameter("idCampagne")));
		} else {
			campagne = (Campagne) session.getAttribute("campagne");
		}

		campagne = boCampagne.trouverCampagne(campagne);
		
		if (campagne != null) {
			System.out.println("Liste Session : " + campagne.getSessions());
			session.setAttribute("campagne", campagne);
			session.setAttribute("listeSession", campagne.getSessions());
			response.sendRedirect("/Critical-PFE/site/Masterisation/modificationCampagne.jsp");
		} else {
			response.sendRedirect("/Critical-PFE/AfficherUnivers");
		}
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
