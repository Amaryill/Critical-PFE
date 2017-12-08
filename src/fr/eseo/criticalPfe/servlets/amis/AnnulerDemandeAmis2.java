package fr.eseo.criticalPfe.servlets.amis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.bdd.BddBoAmi;

/**
 * Servlet implementation class ModifPseudo
 */
@WebServlet("/AnnulerDemandeAmis2")
public class AnnulerDemandeAmis2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnulerDemandeAmis2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BddBoAmi bddBo = new BddBoAmi();

		String pseudoDemande = (String) request.getParameter("pseudo");

		String pseudo_session = "";
		pseudo_session = (String) request.getSession().getAttribute("utilisateur");
		
		bddBo.annulerDemandeAmi(pseudo_session,pseudoDemande);

		response.sendRedirect("AfficherAmis");
		doGet(request, response);
	}

}
