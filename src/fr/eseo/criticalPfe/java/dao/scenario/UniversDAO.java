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

	public Univers creationUnivers(String loginUtilisateur) {
		Univers univers = null;
		ConnexionBDD.getConnexion().insertIntoDataBase(
				"INSERT INTO `univers`(`Nom`,description,pseudo) VALUES ('nouvel univers','- Vide -','" + loginUtilisateur + "');");
		ResultSet rSet = ConnexionBDD.getConnexion().requestFromDataBase(
				"SELECT `Nom`, `Description`, `Pseudo` FROM `univers` WHERE id = (SELECT max(id) FROM univers)");
		try {
			List<Campagne> listeCampagne = new ArrayList<>();
			Utilisateur user = new Utilisateur();
			if (rSet.next()){
				user.setPseudo(rSet.getString("pseudo"));
				univers = new Univers(rSet.getString("nom"),listeCampagne ,new Contenu());
			}
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
		return univers;

	}
}
