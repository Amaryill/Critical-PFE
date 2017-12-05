package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.entite.PersonnageJoueur;

public class Campagne extends Model {

	String nomCampagne;
	List<PersonnageJoueur> joueurs;
	List<Chapitre> chapitres;
	Contenu contenu;

	
	public Campagne(String nomCampagne, List<PersonnageJoueur> joueurs, List<Chapitre> chapitres, Contenu contenu){
		this.nomCampagne = nomCampagne;
		this.joueurs = joueurs;
		this.chapitres = chapitres;
		this.contenu = contenu;
	}
	
	public Campagne(String nomCampagne){
		this(nomCampagne, new ArrayList<PersonnageJoueur>(), new ArrayList<Chapitre>(), new Contenu());
	}

	
	
	public List<PersonnageJoueur> getJoueur() {
		return joueurs;
	}

	public void setJoueur(List<PersonnageJoueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}
	

}
