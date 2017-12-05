package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;

public class Univers extends Model {

	/********************* ATTRIBUTS *************************/

	String nomUnivers;
	String description;
	List<Campagne> campagnes;
	Contenu contenu;
	Regle regle;

	
	/******************* CONSTRUCTEURS ***********************/
	
	
	public Univers(String nomUnivers, String description, List<Campagne> campagnes, Contenu contenu) {
		this.nomUnivers = nomUnivers;
		this.description = description;
		this.campagnes = campagnes;
		this.contenu = contenu;
	}

	public Univers(String nomUnivers){
		this(nomUnivers,"", new ArrayList<Campagne>(), new Contenu());
	}
	

	public Univers() {
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
