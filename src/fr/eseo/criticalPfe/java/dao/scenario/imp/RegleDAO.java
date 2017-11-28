package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.IRegleDAO;

public class RegleDAO implements IRegleDAO {
	
	private DAOFactory daoFactory;
	
	public RegleDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
