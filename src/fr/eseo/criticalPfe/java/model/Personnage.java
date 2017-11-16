package fr.eseo.criticalPfe.java.model;

import java.util.HashMap;
import java.util.List;

public class Personnage extends Entitee {

	String nom;

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

	public Personnage(String nom, List<Classe> classes, Race race, HashMap<String, Integer> caracs, String alignement,
			String dieu, String sex, String couleurYeux, String couleurCheveux, int taille, int age, int poids) {
		this.nom = nom;
		this.classes = classes;
		this.race = race;
		this.caracteristique = new Caracteristique(caracs, classes, race);
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getAlignement() {
		return alignement;
	}

	public void setAlignement(String alignement) {
		this.alignement = alignement;
	}

	public String getDieu() {
		return dieu;
	}

	public void setDieu(String dieu) {
		this.dieu = dieu;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public String getCouleurCheveux() {
		return couleurCheveux;
	}

	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}

	public int getNiveauPersonnage() {
		return niveauPersonnage;
	}

	public void setNiveauPersonnage(int niveauPersonnage) {
		this.niveauPersonnage = niveauPersonnage;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

}
