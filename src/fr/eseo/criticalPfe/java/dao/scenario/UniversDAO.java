package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UniversDAO implements DAO<Univers> {
	
	private static UniversDAO dao;

	private final String ADD_UNIVERS = "INSERT INTO Univers(Nom, description, Pseudo, Id_Contenu, Id_Regle) VALUES (?,?,?,?,?)";
	private final String DLT_UNIVERS = "DELETE FROM Univers WHERE Id = ?";
	private final String CHG_UNIVERS = "UPDATE Univers SET Nom=?, Description=?,Pseudo = ?, Id_Contenu=?, Id_Regle=? WHERE id=?";
	private final String SLT_UNIVERS = "SELECT Id, Nom, Description,Pseudo, Id_Contenu, Id_Regle FROM Univers WHERE id=?";
	private final String SLT_UNIVERS_BY_PSEUDO = "SELECT Id, Nom, Description,pseudo, Id_Contenu, Id_Regle FROM Univers WHERE pseudo=?";

	
	private UniversDAO (){
	}
	
	public static UniversDAO getUniversDAO(){
		if (dao == null){
			dao = new UniversDAO();
		}
		return dao;
	}
	
	@Override
	public Univers creer(Univers obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_UNIVERS);
			preparedStatement.setString(1, obj.getNomUnivers());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setString(3, obj.getUser().getPseudo());
			preparedStatement.setInt(4, obj.getContenu().getId());
			preparedStatement.setInt(5, obj.getRegle().getId());
			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("UNIVERS"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Univers obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(DLT_UNIVERS);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Univers trouver(Univers obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_UNIVERS);
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
	
	
	public ArrayList<Univers> trouverByPseudo(Univers obj) {
		ArrayList<Univers> listeUnivers = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_UNIVERS_BY_PSEUDO);
			preparedStatement.setString(1, obj.getUser().getPseudo());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listeUnivers.add(map(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listeUnivers;
	}

	@Override
	public Univers modifier(Univers obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(CHG_UNIVERS);
			preparedStatement.setString(1, obj.getNomUnivers());
			preparedStatement.setString(2, obj.getDescription());
			preparedStatement.setString(3, obj.getUser().getPseudo());
			preparedStatement.setInt(4, obj.getContenu().getId());
			preparedStatement.setInt(5, obj.getRegle().getId());
			preparedStatement.setInt(6, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}
	
	@Override
	public Univers map(ResultSet result) throws SQLException {
		Univers univers = new Univers();

		univers.setId(result.getInt("Id"));
		univers.setNomUnivers(result.getString("Nom"));
		univers.setDescription(result.getString("Description"));
		Utilisateur user = new Utilisateur();
		user.setPseudo(result.getString("Pseudo"));
		univers.setUser(user);
		univers.getContenu().setId(result.getInt("Id_Contenu"));
		univers.getRegle().setId(result.getInt("Id_Regle"));

		return univers;

	}
	
	
}
