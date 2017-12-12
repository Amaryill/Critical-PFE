package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.CaracteristiqueDAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;

public class CaracteristiqueBOImpl implements CaracteristiqueBO{
	
	CaracteristiqueDAO dao;
	
	public CaracteristiqueBOImpl() {
		this.dao = new CaracteristiqueDAO();
	}

	public Caracteristique creerCaracteristique(Caracteristique caracteristique) {
		return this.dao.creer(caracteristique);
	}
	
	public Caracteristique trouverCaracteristique(Caracteristique caracteristique) {
		return this.dao.trouver(caracteristique);
	}
}
