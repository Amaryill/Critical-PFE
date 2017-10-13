package fr.eseo.criticalPfe.model;

import java.util.List;

import fr.eseo.criticalPfe.model.scenario.Univers;

public class Utilisateur {

	Statistique statistique;
	List<Personnage> personnages;
	List<Univers> univers;

	public Statistique getStatistique() {
		return statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

	public List<Univers> getUnivers() {
		return univers;
	}

	public void setUnivers(List<Univers> univers) {
		this.univers = univers;
	}

}
