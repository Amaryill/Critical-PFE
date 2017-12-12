package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Entitee;
import fr.eseo.criticalPfe.java.model.entite.Monstre;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class EntiteeDAO implements DAO<Entitee> {

	// TODO Changer Table par le nom de la Univers
	private final String REQUEST_ADD = "INSERT INTO Entitee(Nom, Langue, FacteurPuissance, Id_Caracteristique) VALUES (?,?,?,?)";
	private final String REQUEST_DLT = "DELETE FROM Entitee WHERE Id=?";
	private final String REQUEST_UPD = "UPDATE Entitee SET Nom=?, Langue=?, FacteurPuissance=?, Id_Caracteristique=? WHERE id=?";
	private final String REQUEST_SLT = "SELECT Id, Nom, Langue, FacteurPuissance, Id_Caracteristique FROM Entitee WHERE";
	private final String CLAUSE_ID = " id=?";

	private String classe;
	private Personnage personnage;
	private Monstre monstre;

	public Entitee creer(Entitee obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_ADD);

			// TODO PraparedStatement
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getLangues());
			preparedStatement.setDouble(3, obj.getFacteurPuissance());
			preparedStatement.setInt(4, obj.getCaracteristique().getId());
			
			preparedStatement.executeUpdate();

			obj.setIdEntitee(ConnexionBDD.getLastId("Entitee"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Entitee obj) {
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
	public Entitee trouver(Entitee obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		classe = obj.getClass().getSimpleName();

		if(classe.equals("Personnage")){
			personnage = (Personnage) obj;// Entitee personnage = new Entitee();
		} else if(classe.equals("Monstre")){
			monstre = (Monstre) obj;
		}	
		
		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
			preparedStatement.setInt(1, obj.getIdEntitee());

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
	public Entitee modifier(Entitee obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(REQUEST_UPD);
			
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getLangues());
			preparedStatement.setDouble(3, obj.getFacteurPuissance());
			preparedStatement.setInt(4, obj.getCaracteristique().getId());
			preparedStatement.setInt(5, obj.getIdEntitee());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public Entitee map(ResultSet result) throws SQLException {
		if(classe.equals("Personnage")){		
			personnage.setNom(result.getString("nom"));
			personnage.setLangues(result.getString("Langue"));
			personnage.setFacteurPuissance(result.getDouble("FacteurPuissance"));
			personnage.getCaracteristique().setId(result.getInt("Id_Caracteristique"));
			
			return personnage;
		} else if(classe.equals("Monstre")){			
			monstre.setNom(result.getString("nom"));
			monstre.setLangues(result.getString("Langue"));
			monstre.setFacteurPuissance(result.getDouble("FacteurPuissance"));
			monstre.getCaracteristique().setId(result.getInt("Id_Caracteristique"));
			
			return monstre;
		} else {
			return null;
		}
	}
}
