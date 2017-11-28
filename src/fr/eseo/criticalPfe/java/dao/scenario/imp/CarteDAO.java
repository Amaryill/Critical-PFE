package fr.eseo.criticalPfe.java.dao.scenario.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.scenario.ICarteDAO;

public class CarteDAO implements ICarteDAO {
	
	private DAOFactory daoFactory;
	
	public CarteDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
