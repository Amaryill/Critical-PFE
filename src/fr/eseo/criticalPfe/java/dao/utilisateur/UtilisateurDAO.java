package fr.eseo.criticalPfe.java.dao.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur>{

	@Override
	public boolean creer(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur trouver(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Utilisateur newObj, Utilisateur oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}