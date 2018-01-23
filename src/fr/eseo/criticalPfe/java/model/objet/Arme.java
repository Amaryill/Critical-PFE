package fr.eseo.criticalPfe.java.model.objet;

import java.util.List;

import fr.eseo.criticalPfe.java.utils.De;
import fr.eseo.criticalPfe.java.utils.Image;

public class Arme extends Objet {

	De deDegat;
	int multiplicateurCoupCritique;
	int valeurCoupCritique;
	int portee;

	public Arme(String nom, De deDegat, int multiplicateurCoupCritique, int valeurCoupCritique, int portee,
			int valeur, String description) {
		this.nom = nom;
		this.deDegat = deDegat;
		this.multiplicateurCoupCritique = multiplicateurCoupCritique;
		this.valeurCoupCritique = valeurCoupCritique;
		this.portee = portee;
		this.valeur = valeur;
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

	public int getValeurCoupCritique() {
		return valeurCoupCritique;
	}

	public void setValeurCoupCritique(int valeurCoupCritique) {
		this.valeurCoupCritique = valeurCoupCritique;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

}
