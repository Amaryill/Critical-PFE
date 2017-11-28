package fr.eseo.criticalPfe.java.dao.attribut.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.attribut.ICompetenceDAO;

public class CompetenceDAO implements ICompetenceDAO {
	
	private DAOFactory daoFactory;
	
	public CompetenceDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
