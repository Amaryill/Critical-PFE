package fr.eseo.criticalPfe.java.dao.objet.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.objet.IArgentDAO;

public class ArgentDAO implements IArgentDAO {
	
	private DAOFactory daoFactory;
	
	public ArgentDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
