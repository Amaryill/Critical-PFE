package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;

public class UniversDAO {

	public void creationUnivers(String loginUtilisateur) {
		try {
			ConnexionBDD.getConnexion().insertIntoDataBase("INSERT INTO `univers`(`Nom`,pseudo) VALUES ('nouvel univers','"+loginUtilisateur+"');");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
