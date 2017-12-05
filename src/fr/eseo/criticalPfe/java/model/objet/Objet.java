package fr.eseo.criticalPfe.java.model.objet;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.utils.Image;

public abstract class Objet extends Model {

	String nom;
	int valeur;
	String description;
	Image image;

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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
