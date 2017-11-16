package fr.eseo.criticalPfe.java.model.objet;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {

	/********************* ATTRIBUTS *************************/

	List<Objet> objets;
	Argent argent;

	/******************* CONSTRUCTEURS ***********************/

	public Inventaire(List<Objet> objets, Argent argent) {
		this.objets = objets;
		this.argent = argent;
	}

	public Inventaire() {
		this(new ArrayList<Objet>(), new Argent());
	}

	/************** ACCESSEURS ET MUTATEURS ******************/

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public Argent getArgent() {
		return argent;
	}

	public void setArgent(Argent argent) {
		this.argent = argent;
	}

}
