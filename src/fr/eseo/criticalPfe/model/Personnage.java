package fr.eseo.criticalPfe.model;

import java.util.ArrayList;
import java.util.List;

public class Personnage extends Entitee {

	List<Classe> classes;
	Race race;
	String alignement;
	String dieu;
	String sex;
	String couleurYeux;
	String couleurCheveux;

	int niveauPersonnage;

	int taille;
	int age;
	int poids;

	public Personnage(List<Classe> classes, Race race, String alignement, String dieu, String sex, String couleurYeux,
			String couleurCheveux, int taille, int age, int poids) {
		this.classes = classes;
		this.race = race;
		this.alignement = alignement;
		this.dieu = dieu;
		this.sex = sex;
		this.couleurYeux = couleurYeux;
		this.couleurCheveux = couleurCheveux;
		this.niveauPersonnage = 1;
		this.taille = taille;
		this.age = age;
		this.poids = poids;
	}
}
