package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.PersonnageJoueur;

public class PersonnageJoueurDAO implements DAO<PersonnageJoueur> {

	private final String REQUEST_CREER_PERSONNAGE = "INSERT INTO Personnage(Alignement, Dieu, Sexe, CouleurYeux, CouleurCheveux) VALUES ('?','?','?','?','?')";
	
	@Override
	public PersonnageJoueur creer(PersonnageJoueur obj) {
//		ConnexionBDD connexion = ConnexionBDD.getConnexion();
//		
//		try {
//			connexion.requestToDataBase(REQUEST_CREER_PERSONNAGE);
//			obj.setId(connexion.getLastId("Personnage"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		return obj;
	}

	@Override
	public boolean supprimer(PersonnageJoueur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonnageJoueur trouver(PersonnageJoueur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageJoueur modifier(PersonnageJoueur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageJoueur map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
