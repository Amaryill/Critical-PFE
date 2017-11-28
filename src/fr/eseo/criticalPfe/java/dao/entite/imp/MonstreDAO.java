package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IMonstreDAO;

public class MonstreDAO implements IMonstreDAO{
	
	private DAOFactory daoFactory;
	
	public MonstreDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
