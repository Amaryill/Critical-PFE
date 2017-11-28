package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.ILieuDAO;

public class LieuDAO implements ILieuDAO {
	
	private DAOFactory daoFactory;
	
	public LieuDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	
}
