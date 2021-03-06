package fr.eseo.criticalPfe.java.bo.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.dao.attribut.SortDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Entitee;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

// On dit que TrucBOImpl implements TrucBO
public class PersonnageBOImpl implements PersonnageBO{

	// Tout BO d�finit le DAO associer � la classe
	PersonnageDAO dao;
	
	
	public PersonnageBOImpl(){
		this.dao = new PersonnageDAO();
	}
	
	public List<Personnage> trouverPersonnageParUtilisateur(String pseudo){
		List<Personnage> personnages = this.dao.trouverParUtilisateur(pseudo);
		EntiteeBO boEntitee = new EntiteeBOImpl();
		for(Personnage personnage : personnages){
			personnage = (Personnage) boEntitee.trouverEntitee(personnage);
		}
		
		return personnages;
	}
	
	public Personnage trouverPersonnage(Personnage personnage){
		EntiteeBO boEntitee = new EntiteeBOImpl();
		SortDAO daoSort = new SortDAO();
		ClasseBO classeBO = new ClasseBOImpl();
		Personnage personnageTrouve = this.dao.trouver(personnage);
		if(personnageTrouve != null){
		    Entitee entitee = boEntitee.trouverEntitee(personnageTrouve);
		    personnageTrouve.setCaracteristique(entitee.getCaracteristique());
		    personnageTrouve.setSorts(daoSort.trouverListeSort(personnageTrouve));
		    personnageTrouve.setClasses(classeBO.trouverClassesParPersonnage(personnageTrouve));
		}
		return personnageTrouve;
	}
	 
	public Personnage creerPersonnage(Personnage personnage){
		// Quand on cr�e un BO on fait TrucBO truc = new TrucBOImpl(new TrucDAO);
		// Cela oblige � utiliser que des m�thodes impl�menter dans l'interface
		EntiteeBO boEntitee = new EntiteeBOImpl();
		ClasseBO boClasse = new ClasseBOImpl();
		RaceBO boRace = new RaceBOImpl();
		
		personnage = (Personnage) boEntitee.creerEntitee(personnage);
		personnage.setClasses(boClasse.trouverClasses(personnage.getClasses()));
		personnage.setRace(boRace.trouverRace(personnage.getRace()));
//		personnage.setCompendium();
		
		
		return dao.creer(personnage);
//		return null;
}
}
