package fr.eseo.criticalPfe.java.model.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class Utilisateur extends Model {

	String pseudo;
	String description;
	Statistique statistique;
	List<Personnage> personnages;
	List<Univers> listUnivers;

	public Utilisateur(String pseudo, String description, Statistique statistique, List<Personnage> personnages,
			List<Univers> listUnivers) {
		this.pseudo = pseudo;
		this.description = description;
		this.statistique = statistique;
		this.personnages = personnages;
		this.listUnivers = listUnivers;
	}

	public Utilisateur() {
		this(null, null, new Statistique(), new ArrayList<Personnage>(), new ArrayList<Univers>());
	}

	/************** ACCESSEURS ET MUTATEURS *************/


	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}	

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
		return listUnivers;
	}

	public void setUnivers(List<Univers> univers) {
		this.listUnivers = univers;
	}
}
