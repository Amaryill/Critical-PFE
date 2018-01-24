package fr.eseo.criticalPfe.servlets.masterisation.personnage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.attribut.CompetenceBOImpl;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
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
        Personnage personnage = (Personnage) session.getAttribute("personnageCourant");

        // Compétences Acquises
        
        if(personnage.getComptence() != null){
            session.setAttribute("competencesAcquises", personnage.getComptence());
        } else {
            session.setAttribute("competencesAcquises", new ArrayList<Competence>());
        }
        // Compétences Non Acquises     
        List<Competence> competencesNonAcquises = new CompetenceBOImpl()
                .getAllCompetencesBut(personnage.getComptence());
        if(competencesNonAcquises != null) {
            session.setAttribute("competencesNonAcquises", competencesNonAcquises);
        } else {
            session.setAttribute("competencesNonAcquises", new ArrayList<Competence>());
        }
        
        // Points Compétence restants
        session.setAttribute("pointsCompRestants", personnage.getPointsCompRestants());
        
        request.getRequestDispatcher("site/Masterisation/choixCompetences.jsp").forward(request, response);

    }

}
