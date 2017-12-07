package fr.eseo.criticalPfe.java.model.scenario;

import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class Campagne {

	int id;
	Univers univers;
	String nomCampagne;
	String description;
	List<Personnage> joueurs;
	Contenu contenu;
	Regle regle;

	
	public Campagne(){
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Univers getUnivers() {
		return univers;
	}


	public void setUnivers(Univers univers) {
		this.univers = univers;
	}


	public String getNomCampagne() {
		return nomCampagne;
	}


	public void setNomCampagne(String nomCampagne) {
		this.nomCampagne = nomCampagne;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Personnage> getJoueurs() {
		return joueurs;
	}


	public void setJoueurs(List<Personnage> joueurs) {
		this.joueurs = joueurs;
	}


	public Contenu getContenu() {
		return contenu;
	}


	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}


	public Regle getRegle() {
		return regle;
	}


	public void setRegle(Regle regle) {
		this.regle = regle;
	}
	
}
