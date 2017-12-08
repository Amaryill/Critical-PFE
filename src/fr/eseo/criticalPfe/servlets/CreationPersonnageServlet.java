package fr.eseo.criticalPfe.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.java.bo.entite.PersonnageBO;
import fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.entite.Race;

@WebServlet("/CreationPersonnageServlet")
public class CreationPersonnageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationPersonnageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomPersonnage = (String) request.getParameter("nom");
		String nomRace = (String) request.getParameter("race");
		String nomClasse = (String) request.getParameter("classe");
		String alignement = (String) request.getParameter("alignement");
		String dieu = (String) request.getParameter("dieu");
		String sexe = (String) request.getParameter("sexe");
		int age = Integer.parseInt((String) request.getParameter("age"));
		int taille = Integer.parseInt((String) request.getParameter("taille"));
		int poids = Integer.parseInt((String) request.getParameter("poids"));
		String couleurYeux = (String) request.getParameter("couleurYeux");
		String couleurCheveux = (String) request.getParameter("couleurCheveux");
		int force = Integer.parseInt((String) request.getParameter("for"));
		int dexterite = Integer.parseInt((String) request.getParameter("dex"));
		int constitution = Integer.parseInt((String) request.getParameter("con"));
		int intelligence = Integer.parseInt((String) request.getParameter("int"));
		int sagesse = Integer.parseInt((String) request.getParameter("sag"));
		int charisme = Integer.parseInt((String) request.getParameter("cha"));

		PersonnageBO personnageBO = new PersonnageBOImpl();
		Personnage personnage = new Personnage();
		Caracteristique caracteristique = new Caracteristique();
		HashMap<String, Integer> caracs = new HashMap<String, Integer>();
		Race race = new Race();
		Classe classe = new Classe();

		caracs.put("for", force);
		caracs.put("dex", dexterite);
		caracs.put("con", constitution);
		caracs.put("int", intelligence);
		caracs.put("sag", sagesse);
		caracs.put("cha", charisme);
		caracteristique.setCaracs(caracs);
		caracteristique.setPointDeVieMax(20);
		personnage.setCaracteristique(caracteristique);

		race.setNom(nomRace);
		personnage.setRace(race);

		classe.setNom(nomClasse);
		classe.setNiveau(1);
		personnage.ajouterClasse(classe);

		personnage.setNiveauPersonnage(1);
		personnage.setAge(age);
		personnage.setNom(nomPersonnage);
		personnage.setAlignement(alignement);
		personnage.setLangues("Commun");
		personnage.setTaille(taille);
		personnage.setPoids(poids);
		personnage.setCouleurCheveux(couleurCheveux);
		personnage.setCouleurYeux(couleurYeux);
		personnage.setSexe(sexe);
		personnage.setDieu(dieu);

		personnageBO.creerPersonnage(personnage);
		
		response.sendRedirect("/Critical-PFE/site/index.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
