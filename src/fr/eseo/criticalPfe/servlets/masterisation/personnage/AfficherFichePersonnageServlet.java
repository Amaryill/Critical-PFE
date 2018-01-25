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
import fr.eseo.criticalPfe.java.bo.attribut.SortBOImpl;
import fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

/**
 * Servlet implementation class AfficherFichePersonnageServlet
 */
@WebServlet(description = "Affiche l'ensemble des informations d'un personnage sur une page-fiche", urlPatterns = { "/AfficherFichePersonnage" })
public class AfficherFichePersonnageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherFichePersonnageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur user = (Utilisateur) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/Index").forward(request, response);
        }
        if(request.getParameter("id") == null){
            request.getRequestDispatcher("/Index").forward(request, response);
        }
        
        Integer persoId = Integer.parseInt(request.getParameter("id"));
        Personnage personnage = new Personnage();
        personnage.setId(persoId);
        personnage = new PersonnageBOImpl().trouverPersonnage(personnage);
        
        if(personnage == null){
            request.getRequestDispatcher("/Index").forward(request, response);
        } else {
            session.setAttribute("personnageCourant", personnage);
        }
        
        // Obtention Données Compétences
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
        
        
        
        // Obtention Données Sorts du personnage
        	//Sorts Acquis
        
        if(personnage.getSorts() != null){
        	session.setAttribute("sortsAcquis", personnage.getSorts());
        } else {
        	session.setAttribute("sortsAcquis", new ArrayList<Sort>());
        }
        
        	//Sorts Apprenable

        SortBOImpl sortBO = new SortBOImpl();
        session.setAttribute("sortsApprenable", sortBO.trouverSortApprenable(personnage));
        
        request.getRequestDispatcher("site/Masterisation/fichePersonnage.jsp").forward(request, response);
        
    }


}
