package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.EntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

// On dit que TrucBOImpl implements TrucBO
public class PersonnageBOImpl implements PersonnageBO{

	// Tout BO définit le DAO associer à la classe
	PersonnageDAO dao;
	
	
	public PersonnageBOImpl(PersonnageDAO dao){
		this.dao = dao;
	}
	
	public Personnage creerPersonnage(Personnage personnage){
		// Quand on crée un BO on fait TrucBO truc = new TrucBOImpl(new TrucDAO);
		// Cela oblige à utiliser que des méthodes implémenter dans l'interface
		EntiteeBO boEntitee = new EntiteeBOImpl(new EntiteeDAO());
		
		personnage = (Personnage) boEntitee.creerEntitee(personnage);
		
		return dao.creer(personnage);
	}
}
