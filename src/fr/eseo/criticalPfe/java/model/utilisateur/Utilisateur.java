package fr.eseo.criticalPfe.java.model.utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.PersonnageJoueur;
import fr.eseo.criticalPfe.java.model.entite.Race;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class Utilisateur {

	String pseudo;
	String description;
	Statistique statistique;
	List<PersonnageJoueur> personnages;
	List<Univers> listUnivers;

	public Utilisateur(String pseudo, String description, Statistique statistique, List<PersonnageJoueur> personnages,
			List<Univers> listUnivers) {
		this.pseudo = pseudo;
		this.description = description;
		this.statistique = statistique;
		this.personnages = personnages;
		this.listUnivers = listUnivers;
	}

	public Utilisateur() {
		this(null, null, new Statistique(), new ArrayList<PersonnageJoueur>(), new ArrayList<Univers>());
	}

	/************** ACCESSEURS ET MUTATEURS *************/

	public Statistique getStatistique() {
		return statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
	}

	public List<PersonnageJoueur> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<PersonnageJoueur> personnages) {
		this.personnages = personnages;
	}

	public List<Univers> getUnivers() {
		return listUnivers;
	}

	public void setUnivers(List<Univers> univers) {
		this.listUnivers = univers;
	}
	
	public String getPseudo(){
		return this.pseudo;
	}

	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	/********************** METHODES *************************/

	public Univers getUniversParNom(String nomUnivers) {
		Univers universRetour = null;
		for (Univers univers : listUnivers) {
			if (univers.getNomUnivers().equals(nomUnivers)) {
				universRetour = univers;
			}
		}

		return universRetour;
	}

	public PersonnageJoueur getPersonnageParNom(String nomPersonnage) {
		PersonnageJoueur personnageRetour = null;
		for (PersonnageJoueur personnage : personnages) {
			if (personnage.getNom().equals(nomPersonnage)) {
				personnageRetour = personnage;
			}
		}

		return personnageRetour;
	}

	public void creerPersonnage(String nom, Classe classe, Race race, HashMap<String, Integer> caracs,
			String alignement, String dieu, String sex, String couleurYeux, String couleurCheveux, int taille, int age,
			int poids) {
		List<Classe> classes = new ArrayList<>();
		classes.add(classe);
		PersonnageJoueur personnage = new PersonnageJoueur(nom, classes, race, caracs, alignement, dieu, sex, couleurYeux,
				couleurCheveux, taille, age, poids);		
		this.personnages.add(personnage);
	}

	public void supprimerPersonnage(String nomPersonnage) {
		this.personnages.remove(getPersonnageParNom(nomPersonnage));
	}

	public void creerUnivers(String nomUnivers) {
		this.listUnivers.add(new Univers(this));
	}

	public void supprimerUnivers(String nomUnivers) {
		this.listUnivers.remove(getUniversParNom(nomUnivers));
	}
}
