package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Race;

public class RaceDAO implements DAO<Race> {

	// TODO Changer Table par le nom de la Univers
	private final String REQUEST_ADD = "INSERT INTO Race(nom, Description, Taille, Vitesse) VALUES (?,?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Race WHERE nom=?";
	private final String REQUEST_UPD = "UPDATE Race SET nom=?, Description=?, Taille=?, Vitesse=? WHERE nom=?";
	private final String REQUEST_SLT = "SELECT nom, Description, Taille, Vitesse FROM Race WHERE";
	private final String REQUEST_SLT_ALL = "SELECT nom, Description, Taille, Vitesse FROM Race";
	private final String CLAUSE_ID = " nom=?";

	public Race creer(Race obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setString(3, obj.getTaille());
			preparedStatement.setInt(4, obj.getVitesse());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Race obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_DLT);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Race trouver(Race obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		Race raceTrouvee = null;
		
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
			preparedStatement.setString(1, obj.getNom());

			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				raceTrouvee = map(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return raceTrouvee;
	}
	
	public ArrayList<Race> trouverTous(){
	       Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ArrayList<Race> racesTrouvees = new ArrayList<>();
	        
	        try {
	            connexion = ConnexionBDD.getConnexion();
	            preparedStatement = connexion.prepareStatement(REQUEST_SLT_ALL);

	            ResultSet result = preparedStatement.executeQuery();
	            
	            while (result.next()) {
	                racesTrouvees.add( map(result) );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return racesTrouvees;
	}

	@Override
	public Race modifier(Race obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setString(3, obj.getTaille());
			preparedStatement.setInt(4, obj.getVitesse());
			preparedStatement.setString(5, obj.getNom());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Race map(ResultSet result) throws SQLException {
		Race race = new Race();

		race.setNom(result.getString("nom"));
		race.setDescription(result.getString("Description"));
		race.setTaille(result.getString("Taille"));
		race.setVitesse(result.getInt("vitesse"));

		return race;

	}
}
