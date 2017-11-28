package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.IContenuDAO;

public class ContenuDAO implements IContenuDAO {

	private DAOFactory daoFactory;
	
	public ContenuDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
