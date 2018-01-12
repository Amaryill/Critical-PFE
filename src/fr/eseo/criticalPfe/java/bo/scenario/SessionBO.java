package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.List;

import fr.eseo.criticalPfe.java.model.scenario.Session;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public interface SessionBO {
	
	public Session creationSession(Session session);
	public void supprimerSession(Session session);
	public List<Session> getListeSessionByCampagne(Session session);
	public Session editSession(Session session);
	
	public List<Utilisateur> getParticipants(Session session);
	public void ajouterParticipants(Session session, Utilisateur user);
	public void supprimerParticipants(Session session, Utilisateur user);
}
