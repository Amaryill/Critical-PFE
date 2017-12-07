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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		CampagneBOImpl campagnesBO = new CampagneBOImpl();
		Campagne campagne = null;
		if(request.getParameter("idCampagne")!=null){
			int idCampagne = Integer.parseInt(request.getParameter("idCampagne"));
			ArrayList<Campagne> listeCampagne = (ArrayList<Campagne>)session.getAttribute("listeCampagne");
			for (Campagne campagne2 : listeCampagne) {
				if (campagne2.getId()==idCampagne){
					campagne = campagne2;
				}
			}
		}else{
			campagne = (Campagne)session.getAttribute("campagne");
		}
		
		if(campagne!=null){
			session.setAttribute("campagne", campagne);
			response.sendRedirect("/Critical-PFE/site/Masterisation/modificationCampagne.jsp");
		}else{
			response.sendRedirect("/Critical-PFE/AfficherUnivers");
		}
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
