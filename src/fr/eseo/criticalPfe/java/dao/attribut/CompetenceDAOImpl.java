package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.utils.Log;

public class CompetenceDAOImpl implements CompetenceDAO {
    
    private final String REQUEST_SLT_ALL = "SELECT * FROM Competence";
    
    public CompetenceDAOImpl(){
    }
    
    
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

        ConnexionBDD.getConnexionBDD().requestToDataBase(
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
        if (nomCaracteristique != null) {
            query += "`CaracAssocie` = '" + nomCaracteristique + "' ";
            elementPrecedent = true;
        }
        if (formationNecessaire != null) {
            if (elementPrecedent) {
                query += ", ";
            }
            elementPrecedent = true;
            query += "`FormationNecessaire` = " + formationNecessaire + " ";
        }
        if (competenceDeClasse != null) {
            if (elementPrecedent) {
                query += ", ";
            }
            elementPrecedent = true;
            query += "`CompetenceClasse` = " + competenceDeClasse + " ";
        }
        if (malusArmure != null) {
            if (elementPrecedent) {
                query += ", ";
            }
            elementPrecedent = true;
            query += "`MalusArmure` = " + malusArmure + " ";
        }
        if (niveauDeCompetence != null) {
            if (elementPrecedent) {
                query += ", ";
            }
            elementPrecedent = true;
            query += "`niveauComp` = '" + niveauDeCompetence + "' ";
        }
        if (description != null) {
            if (elementPrecedent) {
                query += ", ";
            }
            elementPrecedent = true;
            query += "`Description` = '" + description + "' ";
        }
        query += "WHERE `Nom` = '" + nomCompetence + "' ;";

        // Execution Requète
        ConnexionBDD.getConnexionBDD().requestToDataBase(query);

        return trouver(nomCompetence);
    }

    @Override
    public Competence modifier (Competence comp) {
        return modifier(comp.getNom(), comp.getCaracAssociee(), String.valueOf(comp.isFormationNecessaire()),
                String.valueOf(comp.isCompetenceDeClasse()), String.valueOf(comp.isMalusArmure()),
                String.valueOf(comp.getNiveauCompetence()), comp.getDescription());
    }

    @Override
    public Competence trouver (String nomCompetence) {
        String query = "SELECT `Nom`, `CaracAssocie`, `FormationNecessaire`, `CompetenceClasse`, `MalusArmure`, `niveauComp`, `Description` "
                + "FROM `competence` WHERE nom = '" + nomCompetence + "';";
        ResultSet rSet = ConnexionBDD.getConnexionBDD().selectFromDataBase(query);

        Competence newComp = null;

        try {
            newComp = map(rSet);
        } catch (SQLException e) {
            Log.warning(e.toString());
        }
        return newComp;
    }

    @Override
    public Competence trouver (Competence comp) {
        return trouver(comp.getNom());
    }
    
    public List<Competence> trouverTous (){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Competence> competencesTrouvees = new ArrayList<>();
        
        try {
            connexion = ConnexionBDD.getConnexion();
            preparedStatement = connexion.prepareStatement(REQUEST_SLT_ALL);

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                competencesTrouvees.add( map(result) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return competencesTrouvees;
    }
    
    public List<Competence> trouverTousSauf (List<Competence> competencesExclues) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Competence> competencesTrouvees = new ArrayList<>();
        
        try {
            connexion = ConnexionBDD.getConnexion();
            preparedStatement = connexion.prepareStatement(getAllButTypedRequest(competencesExclues));

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                competencesTrouvees.add( map(result) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return competencesTrouvees;
    }

    @Override
    public Competence map (ResultSet result) throws SQLException {
        Competence newCompetence = null;
        try {
            if (result.next()) {
                String nomComp = result.getString("Nom");
                String nomCar = result.getString("CaracAssocie");
                String formationNec = nullToString(result.getString("formationNecessaire"));
                String competenceClasse = nullToString(result.getString("competenceClasse"));
                String malusArm = nullToString(result.getString("malusArmure"));
                String niveauComp = nullStringToInt(result.getString("niveauComp"));
                String descri = nullToString(result.getString("description"));

                newCompetence = new Competence(nomComp, nomCar, formationNec, competenceClasse, malusArm, niveauComp,
                        descri);
            }
        } catch (SQLException e) {
            Log.warning(e.toString());
        }
        return newCompetence;
    }

    @Override
    public boolean supprimer (String nomCompetence) {
        String query = "DELETE FROM `competence` " + "WHERE nom = '" + nomCompetence + "';";

        // Execution Requète
        return ConnexionBDD.getConnexionBDD().requestToDataBase(query);
    }

    @Override
    public boolean supprimer (Competence obj) {
        return supprimer(obj.getNom());
    }
    
    private String getAllButTypedRequest(List<Competence> competencesExclues){
        String result = "" + this.REQUEST_SLT_ALL + " WHERE ";
        for (Competence c : competencesExclues){
            result += "id != " + c.getId() + " AND ";
        }
        result += "1;";
        
        return result;
    }

}
