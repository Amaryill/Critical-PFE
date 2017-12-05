package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.CaracteristiqueDAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;

public class CaracteristiqueBO {
	
	CaracteristiqueDAO dao;
	
	public CaracteristiqueBO(CaracteristiqueDAO dao) {
		this.dao = dao;
	}

	public Caracteristique creerCaracteristique(Caracteristique caracteristique) {
		return this.dao.creer(caracteristique);
	}
}
