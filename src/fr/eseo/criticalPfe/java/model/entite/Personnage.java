package fr.eseo.criticalPfe.java.model.entite;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.attributs.Compendium;

public class Personnage extends Entitee {

	String nom;

	List<Classe> classes = new ArrayList<Classe>();
	Race race;
	String alignement;
	String dieu;
	String sexe;
	String couleurYeux;
	String couleurCheveux;

	Compendium compendium;
	int niveauPersonnage;

	int taille;
	int age;
	int poids;


	public Personnage() {
		// TODO Auto-generated constructor stub
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public Compendium getCompendium() {
		return compendium;
	}

	public void setCompendium(Compendium compendium) {
		this.compendium = compendium;
	}
	
	public void ajouterClasse(Classe classe){
		this.classes.add(classe);
	}
}
