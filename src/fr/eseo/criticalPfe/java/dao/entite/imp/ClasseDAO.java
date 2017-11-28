package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IClasseDAO;

public class ClasseDAO implements IClasseDAO{
	
	private DAOFactory daoFactory;
	
	public ClasseDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
