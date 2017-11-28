package fr.eseo.criticalPfe.java.dao.objet.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.objet.IInventaireDAO;

public class InventaireDAO implements IInventaireDAO {

	private DAOFactory daoFactory;
	
	public InventaireDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
