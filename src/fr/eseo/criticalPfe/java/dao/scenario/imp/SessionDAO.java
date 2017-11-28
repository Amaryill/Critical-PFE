package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.ISessionDAO;

public class SessionDAO implements ISessionDAO {

	private DAOFactory daoFactory;
	
	public SessionDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
