package fr.eseo.criticalPfe.model;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.model.scenario.Univers;

public class Utilisateur {

	Profil profil;
	Statistique statistique;
	List<PersonnageJoueur> personnages;
	List<Univers> listUnivers;

	
	public Utilisateur(Profil profil, Statistique statistique, List<PersonnageJoueur> personnages, List<Univers> listUnivers){
		this.profil = profil;
		this.statistique = statistique;
		this.personnages = personnages;
		this.listUnivers = listUnivers;
	}
	
	public Utilisateur(){
		this(null , new Statistique(), new ArrayList<PersonnageJoueur>(), new ArrayList<Univers>());
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
	
	
	public Univers getUniversParNom(String nomUnivers){
		Univers universRetour = null;
		for(Univers univers : listUnivers){
			if(univers.getNomUnivers().equals(nomUnivers)){
				universRetour=univers;
			}
		}
		
		return universRetour;
	}

	public void setUnivers(List<Univers> univers) {
		this.listUnivers = univers;
	}

	public void creerPersonnage(Classe classe, Race race, String alignement, String dieu, String sex,
			String couleurYeux, String couleurCheveux, int taille, int age, int poids) {
		List<Classe> classes = new ArrayList<>();
		classes.add(classe);
		PersonnageJoueur personnage = new PersonnageJoueur(classes, race, alignement, dieu, sex, couleurYeux,
				couleurCheveux, taille, age, poids);

		this.personnages.add(personnage);
	}

	public void creerUnivers(String nomUnivers) {
		this.listUnivers.add(new Univers(nomUnivers));
	}
}
