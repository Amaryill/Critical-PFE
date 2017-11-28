package fr.eseo.criticalPfe.java.dao.utilisateur.imp;

import fr.eseo.criticalPfe.java.dao.DAOException;
import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.utilisateur.IUtilisateurDAO;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {

	private DAOFactory daoFactory;
	
	public UtilisateurDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void creer(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur trouver(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
