package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class Univers {

	/********************* ATTRIBUTS *************************/
	
	
	String nomUnivers;
	String description;
	List<Campagne> campagnes;
	Contenu contenu;
	Regle regle;
	Utilisateur user;
	int id;

	
	

	/******************* CONSTRUCTEURS ***********************/
	
	

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Univers(String nomUnivers, String description, Contenu contenu , Regle regle) {
		this.nomUnivers = nomUnivers;
		this.description = description;
		this.contenu = contenu;
		this.regle = regle;
	}
	

	public Univers() {
		this.contenu = new Contenu();
		this.regle = new Regle();
		// TODO Auto-generated constructor stub
	}

	/************** ACCESSEURS ET MUTATEURS ******************/
	
	public String getNomUnivers() {
		return nomUnivers;
	}

	public void setNomUnivers(String nomUnivers) {
		this.nomUnivers = nomUnivers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public Regle getRegle() {
		return regle;
	}

	public void setRegle(Regle regle) {
		this.regle = regle;
	}

	/********************** METHODES *************************/

	public void ajouterCampagne(String nomCampagne){
		this.campagnes.add(new Campagne(nomCampagne));
	}
}
