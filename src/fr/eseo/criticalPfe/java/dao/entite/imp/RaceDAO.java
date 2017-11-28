package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IRaceDAO;

public class RaceDAO implements IRaceDAO{

	private DAOFactory daoFactory;
	
	public RaceDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
