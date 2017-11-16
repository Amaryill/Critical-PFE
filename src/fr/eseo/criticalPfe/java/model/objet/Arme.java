package fr.eseo.criticalPfe.java.model.objet;

import java.util.List;

import fr.eseo.criticalPfe.java.utils.De;
import fr.eseo.criticalPfe.java.utils.Image;

public class Arme extends Objet {

	De deDegat;
	int multiplicateurCoupCritique;
	List<Integer> valeurCoupCritique;
	int portee;

	public Arme(String nom, De deDegat, int multiplicateurCoupCritique, List<Integer> valeurCoupCritique, int portee,
			int valeur, String description, Image image) {
		this.nom = nom;
		this.deDegat = deDegat;
		this.multiplicateurCoupCritique = multiplicateurCoupCritique;
		this.valeurCoupCritique = valeurCoupCritique;
		this.portee = portee;
		this.valeur = valeur;
		this.description = description;
		this.image = image;
	}

	public Arme(String nom, De deDegat, int multiplicateurCoupCritique, List<Integer> valeurCoupCritique, int portee,
			int valeur, String description) {
		this(nom, deDegat, multiplicateurCoupCritique, valeurCoupCritique, portee, valeur, description, null);
	}

	public De getDeDegat() {
		return deDegat;
	}

	public void setDeDegat(De deDegat) {
		this.deDegat = deDegat;
	}

	public int getMultiplicateurCoupCritique() {
		return multiplicateurCoupCritique;
	}

	public void setMultiplicateurCoupCritique(int multiplicateurCoupCritique) {
		this.multiplicateurCoupCritique = multiplicateurCoupCritique;
	}

	public List<Integer> getValeurCoupCritique() {
		return valeurCoupCritique;
	}

	public void setValeurCoupCritique(List<Integer> valeurCoupCritique) {
		this.valeurCoupCritique = valeurCoupCritique;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

}
