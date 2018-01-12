package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.attributs.ListeSort;

public class ListeSortDAO implements DAO<ListeSort>{
	
	private final String REQUEST_LS_ADD = "INSERT INTO ListeSort(nom,id) VALUES (?,?)";
	private final String REQUEST_LS_DLT = "DELETE FROM ListeSort WHERE nom=?";
	private final String REQUEST_LS_SLT = "SELECT nom,id FROM ListeSort WHERE";
	private final String CLAUSE_ID_LS = " nom=?";

	private Connection connexion;
	private PreparedStatement preparedStatement;
	
	

	@Override
	public ListeSort creer(ListeSort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_LS_ADD);

			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setInt(2, obj.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}
	

	@Override
	public boolean supprimer(ListeSort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_LS_DLT);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ListeSort trouver(ListeSort obj) {
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_LS_SLT + CLAUSE_ID_LS);
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
	public ListeSort modifier(ListeSort obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListeSort map(ResultSet result) throws SQLException {
		ListeSort listeSort = new ListeSort();

		listeSort.setNom(result.getString("nom"));
		listeSort.setId(result.getInt("id"));
		
		return listeSort;
	}

	
}
