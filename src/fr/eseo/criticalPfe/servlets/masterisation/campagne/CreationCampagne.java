package fr.eseo.criticalPfe.servlets.masterisation.campagne;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.CampagneBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/CreationCampagne")
public class CreationCampagne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCampagne() {
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
		Univers univers = (Univers)session.getAttribute("univers");
		
		Campagne campagne = new Campagne();
		campagne.setContenu(univers.getContenu());
		campagne.setRegle(univers.getRegle());
		campagne.setJoueurs(new ArrayList<>());
		campagne.setDescription("- Vide -");
		campagne.setNomCampagne("Nouvelle Campagne");
		campagne.setUnivers(univers);
		
		campagneBO.creerCampagne(campagne);
		
		session.setAttribute("campagne", campagne);
			
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
