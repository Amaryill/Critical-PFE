package fr.eseo.criticalPfe.java.dao.scenario.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.scenario.IUniversDAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class UniversDAO implements IUniversDAO {

	@Override
	public boolean creerUnivers(Univers univers) {
		String pseudo = univers.getUtilisateur().getPseudo();
		String nomUnivers = univers.getNomUnivers();
		
		try {
			ConnexionBDD.getConnexion().insertIntoDataBase("INSERT INTO `univers`(`Nom`,pseudo) VALUES ('"+nomUnivers+"','"+ pseudo +"');");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean supprimerUnivers(Univers univers) {
		String pseudo = univers.getUtilisateur().getPseudo();
		String nomUnivers = univers.getNomUnivers();
		
		try {
			ConnexionBDD.getConnexion().requestFromDataBase("DELETE FROM univers WHERE nom='"+nomUnivers+"' AND pseudo='"+pseudo+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Univers trouverUnivers(Univers univers) {
		String pseudo = univers.getUtilisateur().getPseudo();
		String nomUnivers = univers.getNomUnivers();
		Univers universRetour = null;
		
		try {
			//TODO Liste des caracs que l'on veut r�cup�rer (et de tous les objets li�s � l'univers pour pouvoir set les informations
			ResultSet result = ConnexionBDD.getConnexion().requestFromDataBase("SELECT //TOUTES LES CARACS// INTO univers WHERE nom='"+nomUnivers+"' AND pseudo='"+pseudo+"'");
			universRetour = this.map(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return universRetour;
	}

	@Override
	public boolean modifierUnivers(Univers newUnivers, Univers oldUnivers) {
		String pseudo = oldUnivers.getUtilisateur().getPseudo();
		String nomUnivers = oldUnivers.getNomUnivers();
		String modification = "";
		
		try {
			ConnexionBDD.getConnexion().requestFromDataBase("UPDATE univers SET "+ modification +" nom='"+nomUnivers+"' AND pseudo='"+pseudo+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private Univers map(ResultSet result) throws SQLException {
		Univers univers = new Univers();
		
		while (result.next()) {
			univers.setNomUnivers(result.getString("nomUnivers"));
			univers.setDescription(result.getString("description"));
			//TODO SET TOUT LES ATTRIBUTS
		}
		
		return univers;
	}
}