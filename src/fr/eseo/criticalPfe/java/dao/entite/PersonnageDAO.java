package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class PersonnageDAO implements DAO<Personnage> {

	// TODO Changer Table par le nom de la Univers
	private final String REQUEST_ADD = "INSERT INTO Personnage(Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux, taille, poids, age, nom, Id_Compendium, Id_Entite) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String REQUEST_LIEN_CLASSE = "INSERT INTO EstClasse(niveau, id, Nom) VALUES(?,?,?)"; // TODO
	private final String REQUEST_DLT = "DELETE FROM Personnage WHERE Id=?";
	private final String REQUEST_UPD = "UPDATE Personnage SET Alignement=?, Dieu=?, Sexe=?, CouleurYeux=?, CouleurCheveux=?, taille=?, poids=?, age=?, nom=?, Id_Compendium=?, Id_Entite=? WHERE id=?"; // TODO
	private final String REQUEST_SLT = "SELECT Id, Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux, taille, poids, age, nom, Id_Compendium, Id_Entite FROM Personnage WHERE";
	private final String CLAUSE_ID = " id=?";

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
			preparedStatement.executeUpdate();
			obj.setId(ConnexionBDD.getLastId("Personnage"));

			preparedStatement = connexion.prepareStatement(REQUEST_LIEN_CLASSE);
			for(Classe classe : obj.getClasses()){
				System.out.println(classe.getNiveau());
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

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
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
		personnage.setNom(result.getString("nom"));
		personnage.getCompendium().setId(result.getInt("Id_Compendium"));
		personnage.setIdEntitee(result.getInt("Id_Entitee"));
		
		return personnage;
	}
}
