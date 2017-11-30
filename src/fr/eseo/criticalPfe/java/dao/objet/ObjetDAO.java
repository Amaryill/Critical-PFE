package fr.eseo.criticalPfe.java.dao.objet;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.objet.Objet;

public class ObjetDAO extends DAO<Objet>{

	@Override
	public boolean creer(Objet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Objet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Objet trouver(Objet obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Objet newObj, Objet oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Objet map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}