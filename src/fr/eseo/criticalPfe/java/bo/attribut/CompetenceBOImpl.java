package fr.eseo.criticalPfe.java.bo.attribut;

import fr.eseo.criticalPfe.java.dao.attribut.CompetenceDAO;
import fr.eseo.criticalPfe.java.dao.attribut.CompetenceDAOImpl;
import fr.eseo.criticalPfe.java.model.attributs.Competence;

public class CompetenceBOImpl implements CompetenceBO {

    private static CompetenceBO compBO;
    private static CompetenceDAO compDAO;

    private CompetenceBOImpl() {
    }

    public synchronized CompetenceDAO getInstance () {
        if (compBO == null) {
            compBO = new CompetenceBOImpl();
        }
        if (compBO == null) {
            compDAO = CompetenceDAOImpl.getDAO();
        }
        return CompetenceBOImpl.compDAO;
    }

    @Override
    public Competence creationCompetence (String nomCompetence, String nomCaracteristique, String formationNecessaire,
            String competenceDeClasse, String malusArmure, String niveauDeCompetence, String description) {
        return compDAO.creer(nomCompetence, nomCaracteristique, formationNecessaire, competenceDeClasse, malusArmure,
                niveauDeCompetence, description);
    }

    @Override
    public Competence creationCompetence (Competence comp) {
        return compDAO.creer(comp);
    }

    @Override
    public Competence updateCompetence (String nomCompetence, String nomCaracteristique, String formationNecessaire,
            String competenceDeClasse, String malusArmure, String niveauDeCompetence, String description) {
        return compDAO.modifier(nomCompetence, nomCaracteristique, formationNecessaire, competenceDeClasse, malusArmure,
                niveauDeCompetence, description);
    }

    @Override
    public Competence updateCompetence (Competence comp) {
        return compDAO.modifier(comp);
    }

    @Override
    public Competence getCompetence (String nomCompetence) {
        return compDAO.trouver(nomCompetence);
    }

    @Override
    public Competence getCompetence (Competence comp) {
        return compDAO.trouver(comp);
    }

    @Override
    public boolean deleteCompetence (String nomCompetence) {
        return compDAO.supprimer(nomCompetence);
    }

    @Override
    public boolean deleteCompetence (Competence comp) {
        return compDAO.supprimer(comp);
    }

}
