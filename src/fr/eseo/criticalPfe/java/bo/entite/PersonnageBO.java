package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.EntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class PersonnageBO {

	PersonnageDAO dao;
	
	public PersonnageBO(PersonnageDAO dao){
		this.dao = dao;
	}
	
	public void creerPersonnage(Personnage personnage){
		EntiteeBO boEntitee = new EntiteeBO(new EntiteeDAO());

		boEntitee.creerEntitee(personnage);
		
		dao.creer(personnage);
	}

}
