package fr.eseo.criticalPfe.java.dao.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Race;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurDAO implements DAO<Utilisateur>{
	
	private final String REQUEST_ADD = "INSERT INTO Utilisateur(Pseudo, Login, Password, Mail, presentation) VALUES (?,?,?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Utilisateur WHERE login=?";
	private final String REQUEST_UPD = "UPDATE Utilisateur SET Pseudo=?, Login=?, Password=?, Mail=?, presentation=? WHERE Login=?";
	private final String REQUEST_SLT = "SELECT Pseudo, Login, Password, Mail, presentation FROM Race WHERE";
	private final String REQUEST_CON = "SELECT Password FROM Utilisateur WHERE Login=?";
	private final String CLAUSE_ID = " Login=?";
	
	
	@Override
	public Utilisateur creer(Utilisateur obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD);

			preparedStatement.setString(1, obj.getPseudo());
			preparedStatement.setString(2, obj.getLogin());
			preparedStatement.setString(3, obj.getPassword());
			preparedStatement.setString(4, obj.getMail());
			preparedStatement.setString(5, obj.getPresentation());
			
			preparedStatement.executeUpdate();
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Utilisateur obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_DLT);
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Utilisateur connexion(Utilisateur obj){
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_CON);
			preparedStatement.setString(1, obj.getLogin());
			
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				obj.setPassword(result.getString("password"));				
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return obj;
		
	}
	
	
	@Override
	public Utilisateur trouver(Utilisateur obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
			preparedStatement.setString(1, obj.getLogin());

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
	public Utilisateur modifier(Utilisateur obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPD);

			preparedStatement.setString(1, obj.getPseudo());
			preparedStatement.setString(2, obj.getLogin());
			preparedStatement.setString(3, obj.getPassword());
			preparedStatement.setString(4, obj.getMail());
			preparedStatement.setString(5, obj.getPresentation());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Utilisateur map(ResultSet result) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setPseudo(result.getString("pseudo"));
		utilisateur.setLogin(result.getString("login"));
		utilisateur.setPassword(result.getString("password"));
		utilisateur.setMail(result.getString("mail"));
		utilisateur.setPresentation(result.getString("presentation"));

		return utilisateur;
	}

}
