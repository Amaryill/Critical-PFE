package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.utils.Log;

public class CompetenceDAOImpl implements CompetenceDAO {

    public String nullToString (String s) {
        if (s == null) {
            return "";
        } else {
            return s;
        }
    }

    public String nullStringToInt (String i) {
        if (i == null) {
            return "0";
        } else {
            return i;
        }
    }

    @Override
    public Competence creer (String nomCompetence, String nomCaracteristique, String formationNecessaire,
            String competenceDeClasse, String malusArmure, String niveauDeCompetence, String description) {

        ConnexionBDD.getConnexion().requestToDataBase(
                "INSERT INTO `competence`(`Nom`, `CaracAssocie`, `FormationNecessaire`, `CompetenceClasse`, `MalusArmure`, `niveauComp`, `Description`) "
                        + "VALUES ('" + nomCompetence + "','" + nomCaracteristique + "', " + formationNecessaire + ", "
                        + competenceDeClasse + ", " + malusArmure + ", '" + niveauDeCompetence + "', '" + description
                        + "') ;");

        return trouver(nomCompetence);
    }

    @Override
    public Competence creer (Competence comp) {
        return creer(comp.getNom(), comp.getCaracAssociee(), String.valueOf(comp.isFormationNecessaire()),
                String.valueOf(comp.isCompetenceDeClasse()), String.valueOf(comp.isMalusArmure()),
                String.valueOf(comp.getNiveauCompetence()), comp.getDescription());
    }

    @Override
    public Competence modifier (String nomCompetence, String nomCaracteristique, String formationNecessaire,
            String competenceDeClasse, String malusArmure, String niveauDeCompetence, String description) {
        boolean elementPrecedent = false;
        String query = "UPDATE `competence` " + "SET ";
        if(nomCaracteristique != null){
            query += "`CaracAssocie` = '" + nomCaracteristique + "' ";
            elementPrecedent = true;
        }
        if(formationNecessaire != null){
            if(elementPrecedent){
                query += ", ";
            }
            elementPrecedent = true;
            query += "`FormationNecessaire` = " + formationNecessaire + " ";
        }
        if(competenceDeClasse != null){
            if(elementPrecedent){
                query += ", ";
            }
            elementPrecedent = true;
            query += "`CompetenceClasse` = " + competenceDeClasse + " ";
        }
        if(malusArmure != null){
            if(elementPrecedent){
                query += ", ";
            }
            elementPrecedent = true;
            query += "`MalusArmure` = " + malusArmure + " ";
        }
        if(niveauDeCompetence != null){
            if(elementPrecedent){
                query += ", ";
            }
            elementPrecedent = true;
            query += "`niveauComp` = '" + niveauDeCompetence + "' ";
        }
        if(description != null){
            if(elementPrecedent){
                query += ", ";
            }
            elementPrecedent = true;
            query += "`Description` = '" + description + "' ";
        }
        query += "WHERE `Nom` = '" + nomCompetence + "' ;" ;
        
        // Execution Requète
        ConnexionBDD.getConnexion().requestToDataBase(query);

        return trouver(nomCompetence);
    }

    @Override
    public Competence modifier (Competence comp) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Competence trouver (String nomCompetence) {

        Competence newCompetence = null;

        ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
                "SELECT `Nom`, `CaracAssocie`, `FormationNecessaire`, `CompetenceClasse`, `MalusArmure`, `niveauComp`, `Description` "
                        + "FROM `competence` WHERE nom = '" + nomCompetence + "';");
        try {
            if (rSet.next()) {
                String nomComp = rSet.getString("Nom");
                String nomCar = rSet.getString("CaracAssocie");
                String formationNec = nullToString(rSet.getString("formationNecessaire"));
                String competenceClasse = nullToString(rSet.getString("competenceClasse"));
                String malusArm = nullToString(rSet.getString("malusArmure"));
                String niveauComp = nullStringToInt(rSet.getString("niveauComp"));
                String descri = nullToString(rSet.getString("description"));

                newCompetence = new Competence(nomComp, nomCar, formationNec, competenceClasse, malusArm, niveauComp,
                        descri);
            }
        } catch (SQLException e) {
            Log.warning(e.toString());
        }

        return newCompetence;
    }

    @Override
    public Competence trouver (Competence comp) {
        return trouver(comp.getNom());
    }

    @Override
    public Competence map (ResultSet result) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Competence supprimer (String nomCompetence) {
        Competence comp = supprimer(nomCompetence);
        String query = "DELETE FROM `competence` "
                + "WHERE nom = '" + nomCompetence + "';";
        
         // Execution Requète
            ConnexionBDD.getConnexion().requestToDataBase(query);
        
        
        return comp;
    }

    @Override
    public boolean supprimer (Competence obj) {
        // TODO Auto-generated method stub
        return false;
    }

}
