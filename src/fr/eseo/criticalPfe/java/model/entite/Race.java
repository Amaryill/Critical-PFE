package fr.eseo.criticalPfe.java.model.entite;

import fr.eseo.criticalPfe.java.model.Model;

public class Race extends Model {

	/********************* ATTRIBUTS *************************/

	String nom;
	String description;
	int vitesse;
	int deDeVie;
	String taille;

	/******************* CONSTRUCTEURS ***********************/

	public Race(String nom, String description, int vitesse, int deDeVie, String taille) {
		this.nom = nom;
		this.description = description;
		this.vitesse = vitesse;
		this.deDeVie = deDeVie;
		this.taille = taille;
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

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public int getDeDeVie() {
		return deDeVie;
	}

	public void setDeDeVie(int deDeVie) {
		this.deDeVie = deDeVie;
	}	
}
