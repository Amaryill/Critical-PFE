package fr.eseo.criticalPfe.servlets.masterisation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.CampagneBOImpl;
import fr.eseo.criticalPfe.java.bo.scenario.UniversBO;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/RenommerCampagne")
public class RenommerCampagne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenommerCampagne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CampagneBOImpl campagneBO = new CampagneBOImpl();
		String nouveauNomCampagne = request.getParameter("nomCampagne");
		Campagne campagne = (Campagne)session.getAttribute("campagne");
		campagne.setNomCampagne(nouveauNomCampagne);
		campagneBO.modifierCampagne(campagne);

		response.sendRedirect("/Critical-PFE/AfficherCampagne");
		
		
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
