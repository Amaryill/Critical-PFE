package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class PersonnageDAO extends DAO<Personnage>{

	@Override
	public boolean creer(Personnage obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Personnage obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personnage trouver(Personnage obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Personnage newObj, Personnage oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personnage map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}