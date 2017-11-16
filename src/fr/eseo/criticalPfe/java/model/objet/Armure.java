package fr.eseo.criticalPfe.java.model.objet;

import fr.eseo.criticalPfe.java.utils.Image;

public class Armure extends Objet {

	int bonusArmure;
	int bonusDexteriteMaximal;
	int malusArmureTest;
	double risqueEchecSort;
	int vitesse;

	public Armure(String nom, int bonusArmure, int bonusDexteriteMaximal, int malusArmureTest, double risqueEchecSort,
			int vitesse, int valeur, String description, Image image) {
		this.nom = nom;
		this.bonusArmure = bonusArmure;
		this.bonusDexteriteMaximal = bonusDexteriteMaximal;
		this.malusArmureTest = malusArmureTest;
		this.risqueEchecSort = risqueEchecSort;
		this.vitesse = vitesse;
		this.valeur = valeur;
		this.description = description;
		this.image = image;
	}

	public Armure(String nom, int bonusArmure, int bonusDexteriteMaximal, int malusArmureTest, double risqueEchecSort,
			int vitesse, int valeur, String description) {
		this(nom, bonusArmure, bonusDexteriteMaximal, malusArmureTest, risqueEchecSort, vitesse, valeur, description,
				null);
	}

	public int getBonusArmure() {
		return bonusArmure;
	}

	public void setBonusArmure(int bonusArmure) {
		this.bonusArmure = bonusArmure;
	}

	public int getBonusDexteriteMaximal() {
		return bonusDexteriteMaximal;
	}

	public void setBonusDexteriteMaximal(int bonusDexteriteMaximal) {
		this.bonusDexteriteMaximal = bonusDexteriteMaximal;
	}

	public int getMalusArmureTest() {
		return malusArmureTest;
	}

	public void setMalusArmureTest(int malusArmureTest) {
		this.malusArmureTest = malusArmureTest;
	}

	public double getRisqueEchecSort() {
		return risqueEchecSort;
	}

	public void setRisqueEchecSort(double risqueEchecSort) {
		this.risqueEchecSort = risqueEchecSort;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

}
