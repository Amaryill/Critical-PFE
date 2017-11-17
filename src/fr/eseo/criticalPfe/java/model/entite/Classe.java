package fr.eseo.criticalPfe.java.model.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.attributs.Competence;

public class Classe {

	/********************* ATTRIBUTS *************************/
	
	String nom;
	int niveau;
	int bba;
	int reflexe;
	int vigueur;
	int volonte;
	int deDeVie;
	String alignement;
	List<Competence> competencesDeClasse;
	int pointCompetenceNiveau;
	String description;

	
	/******************* CONSTRUCTEURS ***********************/

	public Classe(String nom, int niveau, int bba, int reflexe, int vigueur, int volonte, int deDeVie,
			String alignement, List<Competence> competencesDeClasse, int pointCompetencecNiveau, String description) {
		this.nom = nom;
		this.niveau = niveau;
		this.bba = bba;
		this.reflexe = reflexe;
		this.volonte = volonte;
		this.deDeVie = deDeVie;
		this.alignement = alignement;
		this.competencesDeClasse = competencesDeClasse;
		this.pointCompetenceNiveau = pointCompetencecNiveau;
		this.description = description;
	}

	
	/************** ACCESSEURS ET MUTATEURS ******************/
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getBba() {
		return bba;
	}

	public void setBba(int bba) {
		this.bba = bba;
	}

	public int getReflexe() {
		return reflexe;
	}

	public void setReflexe(int reflexe) {
		this.reflexe = reflexe;
	}

	public int getVigueur() {
		return vigueur;
	}

	public void setVigueur(int vigueur) {
		this.vigueur = vigueur;
	}

	public int getVolonte() {
		return volonte;
	}

	public void setVolonte(int volonte) {
		this.volonte = volonte;
	}

	public int getDeDeVie() {
		return deDeVie;
	}

	public void setDeDeVie(int deDeVie) {
		this.deDeVie = deDeVie;
	}

	public String getAlignement() {
		return alignement;
	}

	public void setAlignement(String alignement) {
		this.alignement = alignement;
	}

	public List<Competence> getCompetencesDeClasse() {
		return competencesDeClasse;
	}

	public void setCompetencesDeClasse(List<Competence> competencesDeClasse) {
		this.competencesDeClasse = competencesDeClasse;
	}

	public int getPointCompetenceNiveau() {
		return pointCompetenceNiveau;
	}

	public void setPointCompetenceNiveau(int pointCompetenceNiveau) {
		this.pointCompetenceNiveau = pointCompetenceNiveau;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
