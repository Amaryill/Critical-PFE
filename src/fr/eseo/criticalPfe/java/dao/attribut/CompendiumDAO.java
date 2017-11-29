package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.model.attributs.Compendium;

public class CompendiumDAO extends DAO<Compendium>{

	@Override
	public boolean creer(Compendium obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Compendium obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compendium trouver(Compendium obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Compendium newObj, Compendium oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compendium map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
