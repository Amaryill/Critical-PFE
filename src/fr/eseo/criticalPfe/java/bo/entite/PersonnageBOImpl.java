package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.EntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

// On dit que TrucBOImpl implements TrucBO
public class PersonnageBOImpl implements PersonnageBO{

	// Tout BO d�finit le DAO associer � la classe
	PersonnageDAO dao;
	
	
	public PersonnageBOImpl(PersonnageDAO dao){
		this.dao = dao;
	}
	
	public Personnage creerPersonnage(Personnage personnage){
		// Quand on cr�e un BO on fait TrucBO truc = new TrucBOImpl(new TrucDAO);
		// Cela oblige � utiliser que des m�thodes impl�menter dans l'interface
		EntiteeBO boEntitee = new EntiteeBOImpl(new EntiteeDAO());
		
		personnage = (Personnage) boEntitee.creerEntitee(personnage);
		
		return dao.creer(personnage);
	}
}
