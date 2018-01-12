package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.entite.Race;

public class SortDAO implements DAO<Sort>{

	
	private final String REQUEST_ADD = "INSERT INTO Sort(nom, ecole, reference, composante, portee, cible, tempsincantation,jetsauvegardecible,jetsauvegardeeffet) VALUES (?,?,?,?,?,?,?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Sort WHERE nom=?";
	private final String REQUEST_UPD = "UPDATE Sort SET nom=?, ecole=?, reference=?, composante=?, portee=?,cible=?,tempsincantation=?,jetsauvegardecible=?,jetsauvegardeeffet=? WHERE nom=?";
	private final String REQUEST_SLT = "SELECT nom, ecole, reference, composante, portee, cible, tempsincantation, jetsauvegardecible, jetsauvegardeeffet FROM Race WHERE";
	private final String CLAUSE_ID = " nom=?";
	
	private Connection connexion;
	private PreparedStatement preparedStatement;	
	
	@Override
	public Sort creer(Sort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getEcole());
			preparedStatement.setString(3, obj.getReference());
			preparedStatement.setString(4, obj.getComposantes());
			preparedStatement.setString(5, obj.getPortee());
			preparedStatement.setString(6, obj.getCible());
			preparedStatement.setString(7, obj.getTempsIncantation());
			preparedStatement.setString(8, obj.getJetDeSauvegarde());
			preparedStatement.setString(9, obj.getResistanceMagie());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Sort obj) {
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
	public Sort trouver(Sort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
			preparedStatement.setString(1, obj.getNom());

			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				obj = map(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Sort modifier(Sort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getEcole());
			preparedStatement.setString(3, obj.getReference());
			preparedStatement.setString(4, obj.getComposantes());
			preparedStatement.setString(5, obj.getPortee());
			preparedStatement.setString(6, obj.getCible());
			preparedStatement.setString(7, obj.getTempsIncantation());
			preparedStatement.setString(8, obj.getJetDeSauvegarde());
			preparedStatement.setString(9, obj.getResistanceMagie());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Sort map(ResultSet result) throws SQLException {
		Sort sort = new Sort();

		sort.setNom(result.getString("nom"));
		sort.setEcole(result.getString("ecole"));
		sort.setReference(result.getString("reference"));
		sort.setComposantes(result.getString("composante"));
		sort.setPortee(result.getString("portee"));
		sort.setCible(result.getString("cible"));
		sort.setTempsIncantation(result.getString("tempsincantation"));
		sort.setJetDeSauvegarde(result.getString("jetsauvegardecible"));
		sort.setResistanceMagie(result.getString("jetsauvegardeeffet"));

		return sort;
	}

}
