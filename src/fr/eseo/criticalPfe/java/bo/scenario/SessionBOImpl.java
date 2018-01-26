package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.scenario.CampagneDAO;
import fr.eseo.criticalPfe.java.dao.scenario.SessionDAO;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Session;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class SessionBOImpl implements SessionBO{

	@Override
	public Session creationSession(Session session) {
		return SessionDAO.getSessionDAO().creer(session);
	}

	@Override
	public void supprimerSession(Session session) {
		ArrayList<Utilisateur> listeUser = SessionDAO.getSessionDAO().getParticipants(session);
		for (Utilisateur utilisateur : listeUser) {
			SessionDAO.getSessionDAO().supprimerParticipant(session, utilisateur);
		}
		SessionDAO.getSessionDAO().supprimer(session);
	}

	@Override
	public List<Session> getListeSessionByCampagne(Session session) {
		return SessionDAO.getSessionDAO().trouverByCampagne(session);
	}

	@Override
	public Session editSession(Session session) {
		return SessionDAO.getSessionDAO().modifier(session);		
	}

	@Override
	public List<Utilisateur> getParticipants(Session session) {
		return SessionDAO.getSessionDAO().getParticipants(session);
	}

	@Override
	public void ajouterParticipants(Session session, Utilisateur user) {
		SessionDAO.getSessionDAO().ajouterParticipant(session, user);
	}

	@Override
	public void supprimerParticipants(Session session, Utilisateur user) {
		SessionDAO.getSessionDAO().supprimerParticipant(session, user);
		
	}

	@Override
	public Session trouverSession(Session session) {
		return SessionDAO.getSessionDAO().trouver(session);
	}

	
	
	
}
