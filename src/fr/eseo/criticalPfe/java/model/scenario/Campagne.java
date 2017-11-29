package fr.eseo.criticalPfe.java.model.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.PersonnageJoueur;

public class Campagne {

	String nomCampagne;
	List<PersonnageJoueur> joueurs;
	List<Session> sessions;
	Contenu contenu;

	
	public Campagne(String nomCampagne, List<PersonnageJoueur> joueurs, Contenu contenu){
		this.nomCampagne = nomCampagne;
		this.joueurs = joueurs;
		this.contenu = contenu;
		this.sessions = new ArrayList<>();
	}
	
	public Campagne(String nomCampagne){
		this(nomCampagne, new ArrayList<PersonnageJoueur>(), new Contenu());
	}

	
	
	public List<PersonnageJoueur> getJoueur() {
		return joueurs;
	}

	public void setJoueur(List<PersonnageJoueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(Session session){
		this.sessions.add(session);
	}
	

}
