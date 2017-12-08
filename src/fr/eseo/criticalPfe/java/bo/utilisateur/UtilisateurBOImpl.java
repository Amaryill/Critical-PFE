package fr.eseo.criticalPfe.java.bo.utilisateur;

import fr.eseo.criticalPfe.java.dao.utilisateur.UtilisateurDAO;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UtilisateurBOImpl implements UtilisateurBO {
	
	UtilisateurDAO dao;
	
	public UtilisateurBOImpl(){
		this.dao = UtilisateurDAO.getUtilisateurDAO();
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
	
	/**
	 * utilisateur 1 demande utilisateur 2 en ami
	 */
	@Override
	public Boolean creerAmi(Utilisateur utilisateur1, String Pseudo2) {
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setPseudo(Pseudo2);
		return this.dao.creerAmi(utilisateur1, utilisateur2);
	}

	/**
	 * pas d'importance dans l'ordre des utilisateurs
	 */
	@Override
	public Boolean supprimerAmi(Utilisateur utilisateur1, String Pseudo2) {
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setPseudo(Pseudo2);
		return this.dao.supprimerAmi(utilisateur1, utilisateur2);
	}


	/**
	 * l'utilisateur 1 valide la demande de l'utilisateur 2;
	 */
	@Override
	public Boolean validerAmi(Utilisateur utilisateur1, String Pseudo2) {
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setPseudo(Pseudo2);
		return this.dao.validerAmi(utilisateur1, utilisateur2);
	}


	@Override
	public Utilisateur getAmis(Utilisateur utilisateur1) {
		return this.dao.getAmis(utilisateur1);
	}
	
	
}
