package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.attributs.Competence;

public interface CompetenceDAO extends DAO<Competence>{
    
    
    
    /**
     * Insère une compétence en BDD selon les paramètres donnés.
     * @param nomCompetence le nom de la compétence
     * @param nomCaracteristique le nom de la caractéristique de la compétence
     * @return la compétence insérée le cas échéant
     */
    public Competence creer(String nomCompetence, String nomCaracteristique, String formationNecessaire, String competenceDeClasse, String malusArmure , String niveauDeCompetence, String description);
    
    public Competence creer(Competence comp);
    
    /**
     * Met à jour une Competence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @param nomCaracteristique le nom de la caractéristique de la compétence
     * @return la compétence à mettre à jour le cas échéant
     */
    public Competence modifier(String nomCompetence, String nomCaracteristique, String formationNecessaire, String competenceDeClasse, String malusArmure , String niveauDeCompetence, String description);
    
    public Competence modifier(Competence comp);
    
    /**
     * Récupère une Compétence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @return la compétence à récupérer le cas échéant
     */
    public Competence trouver(String nomCompetence);
    
    public Competence trouver(Competence comp);
    
    /**
     * Supprime une Compétence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @return la compétence à supprimer, le cas échéant
     */
    public boolean supprimer(String nomCompetence);
    
    /**
     * Transforme un ResultSet en Competence.
     * @param result le resultSet à transformer
     * @return la compétence à récupérer le cas échéant.
     */
	@Override
	public Competence map(ResultSet result) throws SQLException;
}