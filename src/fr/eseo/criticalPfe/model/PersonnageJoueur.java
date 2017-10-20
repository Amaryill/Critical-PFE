package fr.eseo.criticalPfe.model;

import java.util.List;

public class PersonnageJoueur extends Personnage {

	Compendium compendium;
	
	public PersonnageJoueur(List<Classe> classes, Race race, String alignement, String dieu, String sex, String couleurYeux,
			String couleurCheveux, int taille, int age, int poids) {
		super(classes, race, alignement, dieu, sex, couleurYeux, couleurCheveux, taille, age, poids);
	}

	}
