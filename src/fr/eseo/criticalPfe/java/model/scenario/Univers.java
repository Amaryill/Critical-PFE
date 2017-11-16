package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Contenu;

public class Univers {

	/********************* ATTRIBUTS *************************/
	
	String nomUnivers;
	List<Campagne> campagnes;
	Contenu contenu;

	
	/******************* CONSTRUCTEURS ***********************/
	
	public Univers(String nomUnivers, List<Campagne> campagnes, Contenu contenu){
		this.nomUnivers = nomUnivers;
		this.campagnes = campagnes;
		this.contenu = contenu;
	}
	
	public Univers(String nomUnivers){
		this(nomUnivers, new ArrayList<Campagne>(), new Contenu());
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
	
	
	/********************** METHODES *************************/

	public void ajouterCampagne(String nomCampagne){
		this.campagnes.add(new Campagne(nomCampagne));
	}
}
