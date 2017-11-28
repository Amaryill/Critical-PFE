package fr.eseo.criticalPfe.java.dao.attribut.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.attribut.ISortDAO;

public class SortDAO implements ISortDAO {
	
	private DAOFactory daoFactory;
	
	public SortDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
