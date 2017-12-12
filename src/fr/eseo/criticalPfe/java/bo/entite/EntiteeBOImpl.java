package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.CaracteristiqueDAO;
import fr.eseo.criticalPfe.java.dao.entite.EntiteeDAO;
import fr.eseo.criticalPfe.java.model.entite.Entitee;

public class EntiteeBOImpl implements EntiteeBO{

	EntiteeDAO dao;
	
	public EntiteeBOImpl() {
		this.dao = new EntiteeDAO();
	}

	@Override
	public Entitee creerEntitee(Entitee entitee) {
		CaracteristiqueBO boCaracteristique = new CaracteristiqueBOImpl();
		
		entitee.setCaracteristique(boCaracteristique.creerCaracteristique(entitee.getCaracteristique()));
		
		return this.dao.creer(entitee);
	}

	@Override
	public Entitee trouverEntitee(Entitee entitee) {
		CaracteristiqueBO boCaracteristique = new CaracteristiqueBOImpl();

		entitee = this.dao.trouver(entitee);		
		entitee.setCaracteristique(boCaracteristique.trouverCaracteristique(entitee.getCaracteristique()));

		System.out.println(entitee.getCaracteristique().getCaracs().get("for"));
		
		return entitee;
	}

}
