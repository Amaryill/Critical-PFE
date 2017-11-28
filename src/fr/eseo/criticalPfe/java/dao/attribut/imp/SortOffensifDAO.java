package fr.eseo.criticalPfe.java.dao.attribut.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.attribut.ISortOffensifDAO;

public class SortOffensifDAO implements ISortOffensifDAO{

	private DAOFactory daoFactory;
	
	public SortOffensifDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
