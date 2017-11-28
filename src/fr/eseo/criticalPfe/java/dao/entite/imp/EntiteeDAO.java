package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IEntiteeDAO;

public class EntiteeDAO implements IEntiteeDAO{
	
	private DAOFactory daoFactory;
	
	public EntiteeDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
