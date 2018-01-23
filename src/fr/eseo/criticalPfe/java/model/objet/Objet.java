package fr.eseo.criticalPfe.java.model.objet;

import java.util.HashMap;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.utils.Image;

public class Objet extends Model {

	String nom;
	int valeur;
	String description;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
