package fr.eseo.criticalPfe.java.model.scenario;

import java.util.HashMap;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class Session extends Model {
	
	private Campagne campagne;
	private String nomSession;
	private String dateSession;
	private HashMap<Utilisateur, String> etatParticipant;
	
	
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
	
	

}
