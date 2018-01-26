package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.ArrayList;

import fr.eseo.criticalPfe.java.dao.scenario.CampagneDAO;
import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Session;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class CampagneBOImpl implements CampagneBO{
	
	public ArrayList<Campagne> getListeCampagneByUnivers(Univers univers){
		Campagne campagne = new Campagne();
		campagne.setUnivers(univers);
		return CampagneDAO.getCampagneDAO().trouverByUnivers(campagne);
	}
	
	public void supprimerCampagne(Campagne campagne){
		CampagneDAO.getCampagneDAO().supprimer(campagne);
	}
	
	public void modifierCampagne(Campagne campagne){
		CampagneDAO.getCampagneDAO().modifier(campagne);
	}
	
	public void creerCampagne(Campagne campagne){
		CampagneDAO.getCampagneDAO().creer(campagne);
	}

	public Campagne trouverCampagne(Campagne campagne) {
		SessionBO boSession = new SessionBOImpl();
		
		campagne = CampagneDAO.getCampagneDAO().trouver(campagne);
		Session session = new Session();
		session.setCampagne(campagne);
		campagne.setSessions(boSession.getListeSessionByCampagne(session));
		return campagne;
	}
}
