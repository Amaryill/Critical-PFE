package fr.eseo.criticalPfe.java.bo.attribut;

import fr.eseo.criticalPfe.java.model.attributs.Competence;

public interface CompetenceBO {
    /**
     * Appelle la DAO pour créer une compétence.
     * @param nomCompetence le nom de la compétence
     * @param nomCaracteristique le nom de la caractéristique de la compétence
     * @return la compétence insérée le cas échéant
     */
    public Competence creationCompetence(String nomCompetence, String nomCaracteristique, String formationNecessaire, String competenceDeClasse, String malusArmure , String niveauDeCompetence, String description);
    
    public Competence creationCompetence(Competence comp);
    
    /**
     * Appelle la DAO pour mettre à jour une Competence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @param nomCaracteristique le nom de la caractéristique de la compétence
     * @return la compétence à mettre à jour le cas échéant
     */
    public Competence updateCompetence(String nomCompetence, String nomCaracteristique, String formationNecessaire, String competenceDeClasse, String malusArmure , String niveauDeCompetence, String description);
    
    public Competence updateCompetence(Competence comp);
    
    /**
     * Appelle la DAO pour récupèrer une Compétence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @return la compétence à récupérer le cas échéant
     */
    public Competence getCompetence(String nomCompetence);
    
    public Competence getCompetence(Competence comp);
    
    /**
     * Appelle la DAO pour supprimer une Compétence en BDD (recherche par nom)
     * @param nomCompetence le nom de la compétence
     * @return la compétence à supprimer, le cas échéant
     */
    public boolean deleteCompetence(String nomCompetence);
    
    public boolean deleteCompetence(Competence comp);
}
