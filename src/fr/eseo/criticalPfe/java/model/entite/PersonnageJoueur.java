package fr.eseo.criticalPfe.java.model.entite;

import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.attributs.Compendium;

public class PersonnageJoueur extends Personnage {

	Compendium compendium;

	public PersonnageJoueur(String nom, List<Classe> classes, Race race, HashMap<String, Integer> caracs,
			String alignement, String dieu, String sex, String couleurYeux, String couleurCheveux, int taille, int age,
			int poids, Compendium compendium) {
		super(nom, classes, race, caracs, alignement, dieu, sex, couleurYeux, couleurCheveux, taille, age, poids);
		this.compendium = compendium;
	}
	
	public PersonnageJoueur(String nom, List<Classe> classes, Race race, HashMap<String, Integer> caracs,
			String alignement, String dieu, String sex, String couleurYeux, String couleurCheveux, int taille, int age,
			int poids) {
		this(nom, classes, race, caracs, alignement, dieu, sex, couleurYeux, couleurCheveux, taille, age, poids, null);
	}

}
