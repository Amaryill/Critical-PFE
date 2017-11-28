package fr.eseo.criticalPfe.java.dao.objet.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.objet.IArmureDAO;

public class ArmureDAO implements IArmureDAO{
	
	private DAOFactory daoFactory;
	
	public ArmureDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}