package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class Univers {

	/********************* ATTRIBUTS *************************/

	String nomUnivers;
	String description;
	List<Campagne> campagnes;
	Contenu contenu;
	Utilisateur utilisateur;

	/******************* CONSTRUCTEURS ***********************/

	public Univers(String nomUnivers, List<Campagne> campagnes, Contenu contenu, String description,Utilisateur utilisateur) {
		this.nomUnivers = nomUnivers;
		this.campagnes = campagnes;
		this.contenu = contenu;
		this.description = description;
		this.utilisateur = utilisateur;

	}

	public Univers(Utilisateur utilisateur) {
		this("", new ArrayList<Campagne>(), new Contenu(), "", utilisateur);
	}
	
	public Univers(){
		
	}

	/************** ACCESSEURS ET MUTATEURS ******************/

	public String getNomUnivers() {
		return nomUnivers;
	}

	public void setNomUnivers(String nomUnivers) {
		this.nomUnivers = nomUnivers;
	}

	public List<Campagne> getCampagnes() {
		return campagnes;
	}

	public void setCampagnes(List<Campagne> campagnes) {
		this.campagnes = campagnes;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateur(){
		return this.utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur){
		this.utilisateur = utilisateur;
	}
	/********************** METHODES *************************/

	public void ajouterCampagne(String nomCampagne) {
		this.campagnes.add(new Campagne(nomCampagne));
	}
}
