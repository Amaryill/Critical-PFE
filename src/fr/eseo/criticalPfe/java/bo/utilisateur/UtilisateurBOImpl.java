package fr.eseo.criticalPfe.java.bo.utilisateur;

import fr.eseo.criticalPfe.java.dao.utilisateur.UtilisateurDAO;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurBOImpl implements UtilisateurBO {
	
	UtilisateurDAO dao;
	
	public UtilisateurBOImpl(UtilisateurDAO dao){
		this.dao = dao;
	}
	
	
	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {				
		return dao.creer(utilisateur);
	}

	@Override
	public Utilisateur modifUtilisateur(Utilisateur utilisateur) {		
		return dao.modifier(utilisateur);
	}

	public Utilisateur connexion(Utilisateur utilisateur){
		return dao.connexion(utilisateur);
	}
	
	@Override
	public Utilisateur pullUtilisateur(Utilisateur utilisateur) {
		return dao.trouver(utilisateur);
	}
	
}
