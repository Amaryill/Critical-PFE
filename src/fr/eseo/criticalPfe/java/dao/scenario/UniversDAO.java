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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** VERSION CHAILLOU **/
	

//	public Univers creationUnivers(String pseudoUtilisateur) {
//		Univers univers = null;
//		ConnexionBDD.getConnexion().requestToDataBase(
//				"INSERT INTO `univers`(`Nom`,description,pseudo) VALUES ('nouvel univers','- Vide -','"
//						+ pseudoUtilisateur + "');");
//		ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
//				"SELECT `Id`, `Nom`, `Description`, `Pseudo`  FROM `univers` WHERE id = (SELECT max(id) FROM univers)");
//		List<Campagne> listeCampagne = new ArrayList<>();
//		Utilisateur user = new Utilisateur();
//		try {
//			if (rSet.next()) {
//				user.setPseudo(rSet.getString("pseudo"));
//				univers = new Univers(rSet.getString("nom"), rSet.getString("description"), listeCampagne,
//						new Contenu());
//				univers.setId(rSet.getInt("id"));
//			}
//		} catch (SQLException e) {
//			Log.warning(e.toString());
//		}
//		return univers;
//
//	}
//
//	public void supprimerUnivers(int idUnivers, String utilisateur) {
//		ConnexionBDD.getConnexion().requestToDataBase(
//				"DELETE FROM `univers` WHERE `Id` = " + idUnivers + " and `Pseudo` = '" + utilisateur + "'");
//	}
//
//	public List<Univers> getListeUnivers(String pseudoUtilisateur) {
//		List<Univers> listeUnivers = new ArrayList<>();
//		ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
//				"SELECT `Id`, `Nom`, `Description`  FROM `univers` WHERE pseudo = '" + pseudoUtilisateur + "'");
//		Utilisateur user = new Utilisateur();
//		user.setPseudo(pseudoUtilisateur);
//		try {
//			while (rSet.next()) {
//				Univers univers = new Univers(rSet.getString("nom"), rSet.getString("description"), new ArrayList<>(),
//						new Contenu());
//				univers.setId(rSet.getInt("id"));
//				listeUnivers.add(univers);
//			}
//		} catch (SQLException e) {
//			Log.warning(e.toString());
//		}
//		return listeUnivers;
//	}
//
//	public Univers getUnivers(int idUnivers) {
//		Univers univers = null;
//		ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
//				"SELECT `Id`, `Nom`, `Description`, `Pseudo`  FROM `univers` WHERE id = " + idUnivers);
//		Utilisateur user = new Utilisateur();
//		try {
//			// TODO ajouter les campagnes
//
//			if (rSet.next()) {
//				user.setPseudo(rSet.getString("Pseudo"));
//				univers = new Univers(rSet.getString("nom"), rSet.getString("description"), new ArrayList<>(),
//						new Contenu());
//				univers.setId(rSet.getInt("id"));
//			}
//		} catch (SQLException e) {
//			Log.warning(e.toString());
//		}
//		return univers;
//	}
//
//	public void rennommerUnivers(int idUnivers, String nouveauNomUnivers) {
//		ConnexionBDD.getConnexion()
//				.requestToDataBase("UPDATE `univers` SET `Nom`='" + nouveauNomUnivers + "' WHERE `Id`=" + idUnivers);
//	}
//	
//	public void editDescriptionUnivers(int idUnivers, String nouvelleDescriptionUnivers) {
//		ConnexionBDD.getConnexion().requestToDataBase(
//				"UPDATE `univers` SET `Description`='"+nouvelleDescriptionUnivers+"' WHERE `Id`="+idUnivers);
//		
//	}
	
	
	
}
