package fr.eseo.criticalPfe.java.dao.objet.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.objet.IArmeDAO;

public class ArmeDAO implements IArmeDAO {
	
	private DAOFactory daoFactory;

	public ArmeDAO (DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
}
