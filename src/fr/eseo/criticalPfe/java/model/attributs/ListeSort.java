package fr.eseo.criticalPfe.java.model.attributs;

import fr.eseo.criticalPfe.java.model.Model;

public class ListeSort extends Model{

	/********************* ATTRIBUTS *************************/
	String nom;
	Integer id;
	
	/******************* CONSTRUCTEURS ***********************/
	
	public ListeSort(){
		
	}
	
	public ListeSort(String nom, Integer id){
		this.nom = nom;
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
