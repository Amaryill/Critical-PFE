package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class PersonnageDAO implements DAO<Personnage> {

	// TODO Changer Table par le nom de la Univers
	private final String REQUEST_ADD = "INSERT INTO Personnage(Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux, taille, poids, age, nom, Id_Compendium, Id_Entitee, pseudo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String REQUEST_LIEN_CLASSE = "INSERT INTO EstClasse(niveau, id, Nom) VALUES(?,?,?)"; // TODO
	private final String REQUEST_DLT = "DELETE FROM Personnage WHERE Id=?";
	private final String REQUEST_UPD = "UPDATE Personnage SET Alignement=?, Dieu=?, Sexe=?, CouleurYeux=?, CouleurCheveux=?, taille=?, poids=?, age=?, nom=?, Id_Compendium=?, Id_Entitee=?, pseudo=? WHERE id=?"; // TODO
	private final String REQUEST_SLT = "SELECT Id, Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux, taille, poids, age, nom, Id_Compendium, Id_Entitee, pseudo FROM Personnage WHERE";
	private final String CLAUSE_ID = " id=?";
	private final String CLAUSE_PSEUDO = " pseudo=?";

	public Personnage creer(Personnage obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD);

			// TODO PraparedStatement
			preparedStatement.setString(1, obj.getAlignement());
			preparedStatement.setString(2, obj.getDieu());
			preparedStatement.setString(3, obj.getSexe());
			preparedStatement.setString(4, obj.getCouleurYeux());
			preparedStatement.setString(5, obj.getCouleurCheveux());
			preparedStatement.setInt(6, obj.getTaille());
			preparedStatement.setInt(7, obj.getPoids());
			preparedStatement.setInt(8, obj.getAge());
			preparedStatement.setString(9, obj.getRace().getNom());
			// A décommenter quand compendium implenter
			preparedStatement.setInt(10, 1);
			preparedStatement.setInt(11, obj.getIdEntitee());
			preparedStatement.setString(12, obj.getUtilisateur().getPseudo());
			preparedStatement.executeUpdate();
			obj.setId(ConnexionBDD.getLastId("Personnage"));

			preparedStatement = connexion.prepareStatement(REQUEST_LIEN_CLASSE);
			for(Classe classe : obj.getClasses()){
				preparedStatement.setInt(1, classe.getNiveau());
				preparedStatement.setInt(2, obj.getId());
				preparedStatement.setString(3, classe.getNom());

				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Personnage obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_DLT);
			preparedStatement.setInt(1, obj.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Personnage trouver(Personnage obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		Personnage persoTrouve = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
			System.out.println(obj.getId());
			preparedStatement.setInt(1, obj.getId());
			
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
			    persoTrouve = map(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return persoTrouve;
	}

	@Override
	public Personnage modifier(Personnage obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPD);
			// TODO mappage des changements
			preparedStatement.setString(1, obj.getAlignement());
			preparedStatement.setString(2, obj.getDieu());
			preparedStatement.setString(3, obj.getSexe());
			preparedStatement.setString(4, obj.getCouleurYeux());
			preparedStatement.setString(5, obj.getCouleurCheveux());
			preparedStatement.setInt(6, obj.getTaille());
			preparedStatement.setInt(7, obj.getPoids());
			preparedStatement.setInt(8, obj.getAge());
			preparedStatement.setString(9, obj.getNom());
			preparedStatement.setInt(10, obj.getCompendium().getId());
			preparedStatement.setInt(11, obj.getIdEntitee());
			preparedStatement.setString(11, obj.getUtilisateur().getPseudo());
			preparedStatement.setInt(12, obj.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override	
	public Personnage map(ResultSet result) throws SQLException {
		Personnage personnage = new Personnage();

		// TODO : mappage
		personnage.setId(result.getInt("Id"));
		personnage.setAlignement(result.getString("Alignement"));
		personnage.setDieu(result.getString("Dieu"));
		personnage.setSexe(result.getString("Sexe"));
		personnage.setCouleurYeux(result.getString("CouleurYeux"));
		personnage.setCouleurCheveux(result.getString("CouleurCheveux"));
		personnage.setTaille(result.getInt("taille"));
		personnage.setPoids(result.getInt("poids"));
		personnage.setAge(result.getInt("age"));
		personnage.getRace().setNom(result.getString("nom"));
		personnage.getCompendium().setId(result.getInt("Id_Compendium"));
		personnage.setIdEntitee(result.getInt("Id_Entitee"));		
		personnage.getUtilisateur().setPseudo(result.getString("pseudo"));
		return personnage;
	}

	public List<Personnage> trouverParUtilisateur(String pseudo) {
		List<Personnage> personnages = new ArrayList<Personnage>();
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_PSEUDO);
			preparedStatement.setString(1, pseudo);
			
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				personnages.add(map(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return personnages;
	}
}
