package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Session;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class SessionDAO implements DAO<Session>{
	
	private static SessionDAO dao;
	
	private final String ADD_SESSION = "INSERT INTO Session(Id_Campagne) VALUES (?)";
	private final String DLT_SESSION = "DELETE FROM Session WHERE Id = ?";
	private final String CHG_SESSION = "UPDATE Univers SET Id_Campagne=? WHERE Id=?";
	private final String SLT_SESSION = "SELECT Id, Id_Campagne FROM Session WHERE Id=?";
	private final String SLT_SESSION_BY_CAMPAGNE = "SELECT Id,Id_Campagne FROM Session WHERE Id_Campagne=?";
	
	private final String SLT_PARTICIPE = "SELECT Id, Pseudo FROM Participe WHERE Id=?";
	private final String ADD_PARTICIPE = "INSERT INTO Participe(Id, Pseudo) VALUES (?,?)";
	private final String DLT_PARTICIPE = "DELETE FROM Participe WHERE Id = ? and Pseudo = ?";
	private final String SLT_PARTICIPANTS_BY_SESSION = "SELECT Pseudo FROM Participe WHERE Id=?";
	
	
	
	private SessionDAO (){
	}
	
	public static SessionDAO getSessionDAO(){
		if (dao == null){
			dao = new SessionDAO();
		}
		return dao;
	}

	@Override
	public Session creer(Session obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_SESSION);
			preparedStatement.setInt(1, obj.getCampagne().getId());
			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("SESSION"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Session obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(DLT_SESSION);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Session trouver(Session obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_SESSION);
			preparedStatement.setInt(1, obj.getId());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				obj = map(result);
			}
			

			
			preparedStatement = connexion.prepareStatement(SLT_PARTICIPE);
			preparedStatement.setInt(1, obj.getId());
			ResultSet resultParticipe = preparedStatement.executeQuery();
			while(resultParticipe.next()){
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(resultParticipe.getString("Pseudo"));
				obj.getEtatParticipant().put(utilisateur, "null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}
	
	public ArrayList<Session> trouverByCampagne(Session obj) {
		ArrayList<Session> listeSession = new ArrayList<>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_SESSION_BY_CAMPAGNE);
			preparedStatement.setInt(1, obj.getCampagne().getId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Session session = map(result);
				preparedStatement = connexion.prepareStatement(SLT_PARTICIPE);
				preparedStatement.setInt(1, session.getId());
				ResultSet resultParticipe = preparedStatement.executeQuery();
				
				HashMap<Utilisateur, String> etatParticipant = session.getEtatParticipant();
				while(resultParticipe.next()){
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setPseudo(resultParticipe.getString("Pseudo"));
					etatParticipant.put(utilisateur, "null");
					System.out.println(session);
				}
				session.setEtatParticipant(etatParticipant);
				listeSession.add(session);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listeSession;
	}

	@Override
	public Session modifier(Session obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(CHG_SESSION);
			preparedStatement.setInt(1, obj.getCampagne().getId());
			preparedStatement.setInt(6, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Session map(ResultSet result) throws SQLException {
		Session session = new Session();

		session.setId(result.getInt("Id"));
		Campagne campagne = new Campagne();
		campagne.setId(result.getInt("Id_Campagne"));
		session.setCampagne(campagne);
		session.setDateSession("Vendredi 26 Janvier");
		session.setNomSession("Démonstration du PFE");

		return session;
	}
	
	public Boolean ajouterParticipant(Session obj, Utilisateur user) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_PARTICIPE);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.setString(2, user.getPseudo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean supprimerParticipant(Session obj, Utilisateur user) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(DLT_PARTICIPE);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.setString(2, user.getPseudo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<Utilisateur> getParticipants(Session obj){
		ArrayList<Utilisateur> listeUtilisateur = new ArrayList<>();
		Utilisateur user;
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(SLT_PARTICIPANTS_BY_SESSION);
			preparedStatement.setInt(1, obj.getId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				user = new Utilisateur();
				user.setPseudo(result.getString("Pseudo"));
				listeUtilisateur.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listeUtilisateur;
	}
	
	

}
