package fr.eseo.criticalPfe.java.dao.objet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.objet.Objet;

public class ObjetDAO implements DAO<Objet> {

	private final String REQUEST_ADD = "INSERT INTO Objet(Nom, Valeur, Description) VALUES (?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Objet WHERE Id=?";
	private final String REQUEST_UPD = "UPDATE Objet SET Nom=?, Valeur=?, Description=? WHERE id=?";
	private final String REQUEST_SLT = "SELECT Id, Nom, Valeur, Description FROM Objet WHERE";
	private final String CLAUSE_ID = " id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	@Override
	public Objet creer(Objet obj) {
		try {
			connection = ConnexionBDD.getConnexion();
			preparedStatement = connection.prepareStatement(REQUEST_ADD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setInt(2, obj.getValeur());
			preparedStatement.setString(3, obj.getDescription());

			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("Objet"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Objet obj) {
		connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnexionBDD.getConnexion();
			preparedStatement = connection.prepareStatement(REQUEST_DLT);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Objet trouver(Objet obj) {
		connection = null;
		preparedStatement = null;

		try {
			connection = ConnexionBDD.getConnexion();
			preparedStatement = connection.prepareStatement(REQUEST_SLT + CLAUSE_ID);
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

	@Override
	public Objet modifier(Objet obj) {
		connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnexionBDD.getConnexion();
			preparedStatement = connection.prepareStatement(REQUEST_UPD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setInt(2, obj.getValeur());
			preparedStatement.setString(3, obj.getDescription());
			preparedStatement.setInt(8, obj.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Objet map(ResultSet result) throws SQLException {
		Objet objet = new Objet();

		// TODO : mappage
		objet.setId(result.getInt("Id"));
		objet.setNom(result.getString("Nom"));
		objet.setValeur(result.getInt("Valeur"));
		objet.setDescription(result.getString("Description"));
		return objet;
	}
}