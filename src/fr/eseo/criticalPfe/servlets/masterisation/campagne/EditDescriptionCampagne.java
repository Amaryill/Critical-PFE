package fr.eseo.criticalPfe.servlets.masterisation.campagne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.CampagneBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/EditDescriptionCampagne")
public class EditDescriptionCampagne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDescriptionCampagne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CampagneBOImpl campagneBO = new CampagneBOImpl();
		Campagne campagne = (Campagne)session.getAttribute("campagne");
		String nouvelleDescriptionCampagne = request.getParameter("my-textarea");
		campagne.setDescription(nouvelleDescriptionCampagne);
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
