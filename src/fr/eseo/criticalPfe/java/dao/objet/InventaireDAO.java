package fr.eseo.criticalPfe.java.dao.objet;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.objet.Inventaire;

public class InventaireDAO extends DAO<Inventaire>{

	@Override
	public boolean creer(Inventaire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Inventaire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Inventaire trouver(Inventaire obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Inventaire newObj, Inventaire oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Inventaire map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}