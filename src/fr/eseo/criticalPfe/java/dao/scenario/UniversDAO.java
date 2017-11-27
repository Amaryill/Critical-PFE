package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;

public class UniversDAO {

	public void creationUnivers(String loginUtilisateur) {
		try {
			ConnexionBDD.getConnexion().insertIntoDataBase("INSERT INTO `univers`(`Nom`) VALUES ('nouvel univers');");

			ConnexionBDD.getConnexion().insertIntoDataBase("INSERT INTO `creeunivers`(`Login`, `Id`) VALUES ('"+loginUtilisateur+"',(Select max(id) from univers))");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
