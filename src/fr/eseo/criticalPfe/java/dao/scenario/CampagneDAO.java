package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class CampagneDAO implements DAO<Campagne> {

	private final String ADD_CAMPAGNE = "INSERT INTO Campagne(Nom, description, Id_Univers, Id_Contenue, Id_Regle) VALUES (?,?,?,?,?)";
	private final String DLT_CAMPAGNE = "DELETE FROM Campagne WHERE Id = ?";
	private final String CHG_CAMPAGNE = "UPDATE Campagne SET Nom=?, Description=?,Id_Univers = ?, Id_Contenue=?, Id_Regle=? WHERE id=?";
	private final String SLT_CAMPAGNE = "SELECT Id, Nom, Description,Id_Univers, Id_Contenue, Id_Regle FROM Campagne WHERE id=?";
	private final String SLT_CAMPAGNE_BY_UNIVERS = "SELECT Id, Nom, Description,pseudo, Id_Contenue, Id_Regle FROM Campagne WHERE Id_Univers=?";

	@Override
	public Campagne creer(Campagne obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_CAMPAGNE);

			preparedStatement.setString(1, obj.getNomCampagne());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getUnivers().getId());
			preparedStatement.setInt(4, obj.getContenu().getId());
			preparedStatement.setInt(5, obj.getRegle().getId());

			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("CAMPAGNE"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Campagne obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(DLT_CAMPAGNE);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Campagne trouver(Campagne obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_CAMPAGNE);
			preparedStatement.setInt(1, obj.getId());

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

	public Campagne trouverByUnivers(Campagne obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_CAMPAGNE_BY_UNIVERS);
			preparedStatement.setInt(1, obj.getUnivers().getId());

			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				obj = map(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Campagne modifier(Campagne obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(CHG_CAMPAGNE);
			preparedStatement.setString(1, obj.getNomCampagne());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setInt(3, obj.getUnivers().getId());
			preparedStatement.setInt(4, obj.getContenu().getId());
			preparedStatement.setInt(5, obj.getRegle().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Campagne map(ResultSet result) throws SQLException {

		Campagne campagne = new Campagne();

		campagne.setId(result.getInt("Id"));
		campagne.setNomCampagne(result.getString("Nom"));
		campagne.setDescription(result.getString("Description"));
		Univers univers = new Univers();
		univers.setId(result.getInt("Id_Univers"));
		campagne.setUnivers(univers);
		campagne.getContenu().setId(result.getInt("Id_Contenue"));
		campagne.getRegle().setId(result.getInt("Id_Regle"));

		return campagne;
	}
}
