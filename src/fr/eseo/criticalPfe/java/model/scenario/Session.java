package fr.eseo.criticalPfe.java.model.scenario;

import java.util.HashMap;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class Session extends Model {
	
	private Campagne campagne;
	private String nomSession;
	private String dateSession;
	private HashMap<Utilisateur, String> etatParticipant = new HashMap<Utilisateur, String>();
	private HashMap<Utilisateur, Personnage> personnageUtilisateur;
	
	
	public Campagne getCampagne() {
		return campagne;
	}

	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}

	public String getNomSession() {
		return nomSession;
	}

	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}

	public String getDateSession() {
		return dateSession;
	}

	public void setDateSession(String dateSession) {
		this.dateSession = dateSession;
	}

	public HashMap<Utilisateur, String> getEtatParticipant() {
		return etatParticipant;
	}

	public void setEtatParticipant(HashMap<Utilisateur, String> etatParticipant) {
		this.etatParticipant = etatParticipant;
	}

	public HashMap<Utilisateur, Personnage> getPersonnageUtilisateur() {
		return personnageUtilisateur;
	}

	public void setPersonnageUtilisateur(HashMap<Utilisateur, Personnage> personnageUtilisateur) {
		this.personnageUtilisateur = personnageUtilisateur;
	}
	
	
	
	

}
