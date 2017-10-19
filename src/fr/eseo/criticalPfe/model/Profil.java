package fr.eseo.criticalPfe.model;

public class Profil {

	/********************* ATTRIBUTS *************************/

	String pseudo;
	
	
	/******************* CONSTRUCTEURS ***********************/

	public Profil(String pseudo){
		this.pseudo = pseudo;
	}

	
	/************** ACCESSEURS ET MUTATEURS ******************/

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}

