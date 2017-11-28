package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IPersonnageDAO;

public class PersonnageDAO implements IPersonnageDAO{
	
	private DAOFactory daoFactory;
	
	public PersonnageDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
