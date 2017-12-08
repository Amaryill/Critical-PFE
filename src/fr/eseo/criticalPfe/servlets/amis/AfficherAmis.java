package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBO;
import fr.eseo.criticalPfe.java.bo.utilisateur.UtilisateurBOImpl;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/AfficherAmis")
public class AfficherAmis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherAmis() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurBO utilisateurBO = new UtilisateurBOImpl();

		HttpSession session = request.getSession();
		String pseudo_session = (String) session.getAttribute("utilisateur");
		Utilisateur user = new Utilisateur();
		user.setPseudo(pseudo_session);

		ArrayList<String> ami = new ArrayList<>();
		ArrayList<String> demandeEnvoye = new ArrayList<>();
		ArrayList<String> demandeRecu = new ArrayList<>();

		user = utilisateurBO.getAmis(user);

		Set<String> cles = user.getAmis().keySet();
		Iterator<String> it = cles.iterator();
		while (it.hasNext()) {
			String pseudo = it.next();
			String etat = user.getAmis().get(pseudo);
			if (etat.equals("VALIDE")) {
				ami.add(pseudo);
			} else if (etat.equals("DEMANDE_RECUE")) {
				demandeRecu.add(pseudo);
			} else {
				demandeEnvoye.add(pseudo);
			}
		}
		
		session.setAttribute("demandesEnvoyees", demandeEnvoye);
		session.setAttribute("demandesRecues", demandeRecu);
		session.setAttribute("amis", ami);
		

		response.sendRedirect("/Critical-PFE/site/amis.jsp");
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
