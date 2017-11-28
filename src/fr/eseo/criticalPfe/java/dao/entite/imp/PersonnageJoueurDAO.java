package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.IPersonnageJoueurDAO;

public class PersonnageJoueurDAO implements IPersonnageJoueurDAO{

	private DAOFactory daoFactory;
	
	public PersonnageJoueurDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
}
