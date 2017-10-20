package fr.eseo.criticalPfe.model.objet;

import fr.eseo.criticalPfe.utils.Image;

public abstract class Objet {
	
	String nom;
	int valeur;
	String description;
	Image image;
	
	public Objet(String nom, int valeur, String description, Image image){
		this.nom = nom;
		this.valeur = valeur;
		this.description = description;
		this.image = image;
	}
	
}
