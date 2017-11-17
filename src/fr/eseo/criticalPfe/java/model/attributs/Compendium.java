package fr.eseo.criticalPfe.java.model.attributs;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.objet.Objet;

public class Compendium {

	/********************* ATTRIBUTS *************************/
	
	List<Sort> sorts;
	List<Competence> competences;
	List<Don> dons;
	List<Objet> objets;

	
	/******************* CONSTRUCTEURS ***********************/

	public Compendium(List<Sort> sorts, List<Competence> competences, List<Don> dons, List<Objet> objets){
		this.sorts = sorts;
		this.competences = competences;
		this.dons = dons;
		this.objets = objets;
	}
	
	public Compendium(){
		this(new ArrayList<Sort>(), new ArrayList<Competence>(), new ArrayList<Don>(), new ArrayList<Objet>());
	}


	/************** ACCESSEURS ET MUTATEURS ******************/

	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
}
