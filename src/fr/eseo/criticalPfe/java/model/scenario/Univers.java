package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

public class Univers {

	/********************* ATTRIBUTS *************************/

	int id;
	String nomUnivers;
	String description;
	List<Campagne> campagnes;
	Contenu contenu;

	
	/******************* CONSTRUCTEURS ***********************/
	
	
	public Univers(int id, String nomUnivers, String description, List<Campagne> campagnes, Contenu contenu) {
		this.id = id;
		this.nomUnivers = nomUnivers;
		this.description = description;
		this.campagnes = campagnes;
		this.contenu = contenu;
	}

	public Univers(String nomUnivers){
		this(0,nomUnivers,"", new ArrayList<Campagne>(), new Contenu());
	}
	

	/************** ACCESSEURS ET MUTATEURS ******************/
	
	public String getNomUnivers() {
		return nomUnivers;
	}

	public void setNomUnivers(String nomUnivers) {
		this.nomUnivers = nomUnivers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	/********************** METHODES *************************/

	public void ajouterCampagne(String nomCampagne){
		this.campagnes.add(new Campagne(nomCampagne));
	}
}
