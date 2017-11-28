package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.ISessionDAO;

public class UniversDAO implements ISessionDAO {

	private DAOFactory daoFactory;
	
	public UniversDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}