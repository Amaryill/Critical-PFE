package fr.eseo.criticalPfe.java.dao.attribut.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.attribut.ICompendiumDAO;

public class CompendiumDAO implements ICompendiumDAO{

	private DAOFactory daoFactory;
	
	public CompendiumDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
