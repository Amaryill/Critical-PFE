package fr.eseo.criticalPfe.model;

public class Race {
	
	/********************* ATTRIBUTS *************************/

	String nom;
	String description;
	
	
	/******************* CONSTRUCTEURS ***********************/

	public Race(String nom, String description){
		this.nom = nom;
		this.description = description;
	}

	
	/************** ACCESSEURS ET MUTATEURS ******************/

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
