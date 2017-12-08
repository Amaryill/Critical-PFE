package fr.eseo.criticalPfe.java.bo.entite;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.entite.ClasseDAO;
import fr.eseo.criticalPfe.java.dao.entite.EntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.dao.entite.RaceDAO;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

// On dit que TrucBOImpl implements TrucBO
public class PersonnageBOImpl implements PersonnageBO{

	// Tout BO définit le DAO associer à la classe
	PersonnageDAO dao;
	
	
	public PersonnageBOImpl(){
		this.dao = new PersonnageDAO();
	}
	
	public Personnage creerPersonnage(Personnage personnage){
		// Quand on crée un BO on fait TrucBO truc = new TrucBOImpl(new TrucDAO);
		// Cela oblige à utiliser que des méthodes implémenter dans l'interface
		EntiteeBO boEntitee = new EntiteeBOImpl();
		ClasseBO boClasse = new ClasseBOImpl();
		RaceBO boRace = new RaceBOImpl();
		
		personnage = (Personnage) boEntitee.creerEntitee(personnage);
		personnage.setClasses(boClasse.trouverClasses(personnage.getClasses()));
		personnage.setRace(boRace.trouverRace(personnage.getRace()));
//		personnage.setCompendium();
		
		System.out.println(personnage.getIdEntitee());
		System.out.println(personnage.getClasses().get(0).getNom());
		System.out.println(personnage.getRace().getNom());
		
		return dao.creer(personnage);
//		return null;
	}
}
