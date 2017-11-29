package fr.eseo.criticalPfe.java.dao.attribut;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.attributs.Competence;

public class CompetenceDAO extends DAO<Competence>{

	@Override
	public boolean creer(Competence obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Competence obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Competence trouver(Competence obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Competence newObj, Competence oldObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Competence map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}