package fr.eseo.criticalPfe.java.dao.attribut.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.attribut.IDonDAO;

public class DonDAO implements IDonDAO {
	
	private DAOFactory daoFactory;
	
	public DonDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

}
