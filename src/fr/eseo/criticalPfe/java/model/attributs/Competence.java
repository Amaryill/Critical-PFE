package fr.eseo.criticalPfe.java.model.attributs;

public class Competence {

	/************** ACCESSEURS ET MUTATEURS ******************/

	String nom;
	String caracAssociee;

	boolean formationNecessaire;
	boolean competenceDeClasse;
	boolean malusArmure;

	int niveauCompetence;

	String description;

	
	/******************* CONSTRUCTEURS ***********************/

	public Competence(String nom, String caracAssociee, boolean formationNecesaire, boolean competenceDeClasse,
			boolean malusArmure, int niveauDeCompetence, String description) {
		this.nom = nom;
		this.caracAssociee = caracAssociee;
		this.formationNecessaire = formationNecesaire;
		this.competenceDeClasse = competenceDeClasse;
		this.malusArmure = malusArmure;
		this.niveauCompetence = niveauDeCompetence;
		this.description = description;
	}

	
	/************** ACCESSEURS ET MUTATEURS ******************/

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCaracAssociee() {
		return caracAssociee;
	}


	public void setCaracAssociee(String caracAssociee) {
		this.caracAssociee = caracAssociee;
	}


	public boolean isFormationNecessaire() {
		return formationNecessaire;
	}


	public void setFormationNecessaire(boolean formationNecessaire) {
		this.formationNecessaire = formationNecessaire;
	}


	public boolean isCompetenceDeClasse() {
		return competenceDeClasse;
	}


	public void setCompetenceDeClasse(boolean competenceDeClasse) {
		this.competenceDeClasse = competenceDeClasse;
	}


	public boolean isMalusArmure() {
		return malusArmure;
	}


	public void setMalusArmure(boolean malusArmure) {
		this.malusArmure = malusArmure;
	}


	public int getNiveauCompetence() {
		return niveauCompetence;
	}


	public void setNiveauCompetence(int niveauCompetence) {
		this.niveauCompetence = niveauCompetence;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
