package fr.eseo.criticalPfe.java.dao.utilisateur.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.utilisateur.IStatistiqueDAO;

public class StatistiqueDAO implements IStatistiqueDAO {

	private DAOFactory daoFactory;
	
	public StatistiqueDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	
}
