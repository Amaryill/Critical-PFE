package fr.eseo.criticalPfe.java.dao.objet;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.objet.Armure;

public class ArmureDAO extends DAO<Armure>{

	@Override
	public boolean creer(Armure obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Armure obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Armure trouver(Armure obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Armure newObj, Armure oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Armure map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}