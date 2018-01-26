package fr.eseo.criticalPfe.servlets.masterisation.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.SessionBOImpl;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Session;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/AjoutParticipant")
public class AjoutParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutParticipant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession = request.getSession();
		SessionBOImpl sessionBO = new SessionBOImpl();
		Campagne campagne = (Campagne)httpSession.getAttribute("campagne");
		Session session = new Session();
		session.setId(Integer.parseInt(request.getParameter("idSession")));
		session = sessionBO.trouverSession(session);
		System.out.println(session.getNomSession());
		System.out.println(session.getId());
		session.setCampagne(campagne);
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(request.getParameter("pseudo"));
		sessionBO.ajouterParticipants(session, utilisateur);
		//httpSession.setAttribute("session", session);
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
