package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Contenu;
import fr.eseo.criticalPfe.java.model.scenario.Univers;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;
import fr.eseo.criticalPfe.java.utils.Log;

public class UniversDAO {

	public Univers creationUnivers(String pseudoUtilisateur) {
		Univers univers = null;
		ConnexionBDD.getConnexion().requestToDataBase(
				"INSERT INTO `univers`(`Nom`,description,pseudo) VALUES ('nouvel univers','- Vide -','"
						+ pseudoUtilisateur + "');");
		ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
				"SELECT `Id`, `Nom`, `Description`, `Pseudo`  FROM `univers` WHERE id = (SELECT max(id) FROM univers)");
		List<Campagne> listeCampagne = new ArrayList<>();
		Utilisateur user = new Utilisateur();
		try {
			if (rSet.next()) {
				user.setPseudo(rSet.getString("pseudo"));
				univers = new Univers(rSet.getInt("id"), rSet.getString("nom"), rSet.getString("description"),
						listeCampagne, new Contenu());
			}
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
		return univers;

	}

	public void supprimerUnivers(int idUnivers, String utilisateur) {
		ConnexionBDD.getConnexion().requestToDataBase(
				"DELETE FROM `univers` WHERE `Id` = " + idUnivers + " and `Pseudo` = " + utilisateur);
	}

	public List<Univers> getListeUnivers(String pseudoUtilisateur) {
		List<Univers> listeUnivers = new ArrayList<>();
		ResultSet rSet = ConnexionBDD.getConnexion().selectFromDataBase(
				"SELECT `Id`, `Nom`, `Description`  FROM `univers` WHERE pseudo = '" + pseudoUtilisateur+"'");
		Utilisateur user = new Utilisateur();
		user.setPseudo(pseudoUtilisateur);
		try {
			while (rSet.next()) {
				listeUnivers.add(new Univers(rSet.getInt("id"), rSet.getString("nom"), rSet.getString("description"),
						new ArrayList<>(), new Contenu()));
			}
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
		return listeUnivers;
	}
}
