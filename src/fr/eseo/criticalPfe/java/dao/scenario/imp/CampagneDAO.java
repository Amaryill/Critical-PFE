package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.ICampagneDAO;

public class CampagneDAO implements ICampagneDAO {
	
	private DAOFactory daoFactory;
	
	public CampagneDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
