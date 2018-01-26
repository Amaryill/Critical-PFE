package fr.eseo.criticalPfe.servlets.masterisation.personnage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.attribut.CompetenceBOImpl;
import fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.entite.Carac;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

/**
 * Servlet implementation class ChoixCompetencesServlet
 */
@WebServlet("/ChoixCompetences")
public class ChoixCompetencesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoixCompetencesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("---------------- ARRIVEE SERVLET ChoixComptences -----------------");
        HttpSession session = request.getSession();
        if (session.getAttribute("utilisateur") == null) {
            request.getRequestDispatcher("/Index").forward(request, response);
        }
        if (session.getAttribute("personnageCourant") == null) {
            request.getRequestDispatcher("/AccueilProfil").forward(request, response);
        }
        Personnage personnageATrouver = (Personnage) session.getAttribute("personnageCourant");
        Personnage personnageTrouve = new PersonnageBOImpl().trouverPersonnage(personnageATrouver);

        // Compétences Acquises
        
        if(personnageTrouve.getComptence() != null){
            session.setAttribute("competencesAcquises", personnageTrouve.getComptence());
        } else {
            session.setAttribute("competencesAcquises", new ArrayList<Competence>());
        }
        // Compétences Non Acquises     
        List<Competence> competencesNonAcquises = new CompetenceBOImpl()
                .getAllCompetencesBut(personnageTrouve.getComptence());
        if(competencesNonAcquises != null) {
            session.setAttribute("competencesNonAcquises", competencesNonAcquises);
        } else {
            session.setAttribute("competencesNonAcquises", new ArrayList<Competence>());
        }
        
        // Points Compétence restants
        session.setAttribute("pointsCompRestants", personnageTrouve.getPointsCompRestants());
        
        // Modificateurs
        HashMap<String, Integer> modificateurs = personnageTrouve.getAllModificateurs();
        session.setAttribute("modificateurs", modificateurs);
        
        request.getRequestDispatcher("site/Masterisation/choixCompetences.jsp").forward(request, response);

    }

}
