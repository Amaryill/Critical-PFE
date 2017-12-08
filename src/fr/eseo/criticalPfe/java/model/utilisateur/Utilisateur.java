package fr.eseo.criticalPfe.java.model.utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class Utilisateur extends Model {

	String pseudo;
	String login;
	String password;
	String mail;
	String presentation;
	Statistique statistique;
	List<Personnage> personnages;
	List<Univers> listUnivers;
	HashMap<String,String> amis;

	public Utilisateur(String pseudo, String login, String password, String mail, String presentation, Statistique statistique, List<Personnage> personnages,
			List<Univers> listUnivers) {
		this.pseudo = pseudo;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.presentation = presentation;
		this.statistique = statistique;
		this.personnages = personnages;
		this.listUnivers = listUnivers;
	}

	public Utilisateur() {
		this(null, null, null, null, null, new Statistique(), new ArrayList<Personnage>(), new ArrayList<Univers>());
	}

	/************** ACCESSEURS ET MUTATEURS *************/
	

	public List<Univers> getListUnivers() {
		return listUnivers;
	}

	public void setListUnivers(List<Univers> listUnivers) {
		this.listUnivers = listUnivers;
	}

	public HashMap<String, String> getAmis() {
		return amis;
	}

	public void setAmis(HashMap<String, String> amis) {
		this.amis = amis;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPresentation() {
		return this.presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	
	public Statistique getStatistique() {
		return this.statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
	}

	public List<Personnage> getPersonnages() {
		return this.personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

	public List<Univers> getUnivers() {
		return this.listUnivers;
	}

	public void setUnivers(List<Univers> univers) {
		this.listUnivers = univers;
	}
}
