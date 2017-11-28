package fr.eseo.criticalPfe.java.dao.objet.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.objet.IObjetDAO;

public class ObjetDAO implements IObjetDAO {

	private DAOFactory daoFactory;

	public ObjetDAO(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
}
