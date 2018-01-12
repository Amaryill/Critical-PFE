package fr.eseo.criticalPfe.java.model.attributs;

import java.util.HashMap;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.entite.Classe;

public class Sort extends Model {

	/********************* ATTRIBUTS *************************/

	String nom;
	String reference;
	HashMap<Classe, Integer> levelSort;

	String ecole;
	String tempsIncantation;
	String composantes;
	String portee;
	String cible;
	
	int duree;

	String jetDeSauvegarde;
	String resistanceMagie;
	String description;

	
	/******************* CONSTRUCTEURS ***********************/
	
	public Sort(){
		
	}
	
	public Sort(String nom, String reference,HashMap<Classe, Integer> levelSort, String ecole, String tempsIncantation,
			String composantes, String portee, String cible,int duree, String jetDeSauvegarde, String resistanceMagie,
			String description) {
		this.nom = nom;
		this.reference = reference;
		this.levelSort = levelSort;
		this.ecole = ecole;
		this.tempsIncantation = tempsIncantation;
		this.composantes = composantes;
		this.duree = duree;
		this.portee = portee;
		this.cible = cible;
		this.jetDeSauvegarde = jetDeSauvegarde;
		this.resistanceMagie = resistanceMagie;
		this.description = description;
	}

	
	/************** ACCESSEURS ET MUTATEURS ******************/

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public HashMap<Classe, Integer> getLevelSort() {
		return levelSort;
	}

	public void setLevelSort(HashMap<Classe, Integer> levelSort) {
		this.levelSort = levelSort;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getTempsIncantation() {
		return tempsIncantation;
	}

	public void setTempsIncantation(String tempsIncantation) {
		this.tempsIncantation = tempsIncantation;
	}

	public String getComposantes() {
		return composantes;
	}

	public void setComposantes(String composantes) {
		this.composantes = composantes;
	}

	public String getPortee() {
		return portee;
	}

	public void setPortee(String portee) {
		this.portee = portee;
	}

	public String getCible() {
		return cible;
	}

	public void setCible(String cible) {
		this.cible = cible;
	}
	
	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getJetDeSauvegarde() {
		return jetDeSauvegarde;
	}

	public void setJetDeSauvegarde(String jetDeSauvegarde) {
		this.jetDeSauvegarde = jetDeSauvegarde;
	}

	public String getResistanceMagie() {
		return resistanceMagie;
	}

	public void setResistanceMagie(String resistanceMagie) {
		this.resistanceMagie = resistanceMagie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
