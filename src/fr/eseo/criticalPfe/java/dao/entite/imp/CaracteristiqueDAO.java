package fr.eseo.criticalPfe.java.dao.entite.imp;

import fr.eseo.criticalPfe.java.dao.DAOFactory;
import fr.eseo.criticalPfe.java.dao.entite.ICaracteristiqueDAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;

public class CaracteristiqueDAO implements ICaracteristiqueDAO{

	private DAOFactory daoFactory;
	
	public CaracteristiqueDAO(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	@Override
	public boolean creer(Caracteristique caracteristique) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Caracteristique caracteristique) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean trouver(Caracteristique caracteristique) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(Caracteristique caracteristiqueNouvelle, Caracteristique caracterisitiqueAncienne) {
		// TODO Auto-generated method stub
		return false;
	}
}
