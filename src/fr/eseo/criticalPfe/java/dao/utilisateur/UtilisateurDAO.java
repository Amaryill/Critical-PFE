package fr.eseo.criticalPfe.java.dao.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurDAO implements DAO<Utilisateur>{
	private static UtilisateurDAO dao;
	
	private final String REQUEST_ADD = "INSERT INTO Utilisateur(Pseudo, Login, Password, Mail, presentation) VALUES (?,?,?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Utilisateur WHERE login=?";
	private final String REQUEST_UPD = "UPDATE Utilisateur SET Pseudo=?, Login=?, Password=?, Mail=?, presentation=? WHERE Login=?";
	private final String REQUEST_SLT = "SELECT Pseudo, Login, Password, Mail, presentation FROM Utilisateur WHERE";
	private final String REQUEST_CON = "SELECT Password FROM Utilisateur WHERE Login=?";
	private final String CLAUSE_ID = " Login=?";
	
	//TODO verifier que l'amitié n'existe pas dans le sens inverse
	private final String REQUEST_ADD_AMI = "INSERT INTO `ami`(`Etat`, `Pseudo`, `Pseudo_Utilisateur`) VALUES (?,?,?)";
	private final String REQUEST_DLT_AMI = "DELETE FROM ami` WHERE (Pseudo=? and Pseudo_Utilisateur=?) OR (Pseudo=? and Pseudo_Utilisateur=?)";
	private final String REQUEST_UPDATE_AMI = "UPDATE `ami` SET `Etat`=? WHERE Pseudo=? and Pseudo_Utilisateur=?";
	private final String REQUEST_SLT_AMI = "SELECT `Etat`, `Pseudo`, `Pseudo_Utilisateur` FROM `ami` where Pseudo=? OR Pseudo_Utilisateur=?";

	private UtilisateurDAO(){};
	
	public static UtilisateurDAO getUtilisateurDAO(){
		if(dao == null){
			dao = new UtilisateurDAO();
		}
		return dao;
	}
	
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
			preparedStatement = connexion.prepareStatement(REQUEST_SLT+CLAUSE_ID);
			preparedStatement.setString(1, obj.getLogin());
			
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				obj.setPassword(result.getString("password"));
				obj.setPseudo(result.getString("pseudo"));
			} else {
				obj.setPassword("");
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
			preparedStatement.setString(6, obj.getLogin());
			
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
	
	public Boolean creerAmi(Utilisateur user1, Utilisateur user2) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD_AMI);
			preparedStatement.setString(1, "EN_ATTENTE");
			preparedStatement.setString(2, user1.getPseudo());
			preparedStatement.setString(3, user2.getPseudo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean supprimerAmi(Utilisateur user1, Utilisateur user2) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_DLT_AMI);
			preparedStatement.setString(1, user1.getPseudo());
			preparedStatement.setString(2, user2.getPseudo());
			preparedStatement.setString(3, user2.getPseudo());
			preparedStatement.setString(4, user1.getPseudo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validerAmi(Utilisateur user1, Utilisateur user2) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPDATE_AMI);
			preparedStatement.setString(1, "VALIDE");
			preparedStatement.setString(2, user2.getPseudo());
			preparedStatement.setString(3, user1.getPseudo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Utilisateur getAmis(Utilisateur user){
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		HashMap<String,String> listeAmis = new HashMap<>();

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT_AMI);
			preparedStatement.setString(1, user.getPseudo());
			preparedStatement.setString(2, user.getPseudo());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				if(!result.getString("pseudo").equals(user.getPseudo())){
					listeAmis.put(result.getString("Pseudo"), result.getString("Etat"));
				}else{
					listeAmis.put(result.getString("Pseudo_Utilisateur"), result.getString("Etat"));
				}
			}
			user.setAmis(listeAmis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
