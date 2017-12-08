package fr.eseo.criticalPfe.java.bo.utilisateur;

import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public interface UtilisateurBO {
	public Utilisateur creerUtilisateur(Utilisateur utilisateur);
	public Utilisateur modifUtilisateur(Utilisateur utilisateur);
	public Utilisateur pullUtilisateur(Utilisateur utilisateur);
	public Utilisateur connexion(Utilisateur utilisateur);
	
	public Boolean creerAmi(Utilisateur utilisateur1, String Pseudo2);
	public Boolean supprimerAmi(Utilisateur utilisateur1, String Pseudo2);
	public Boolean validerAmi(Utilisateur utilisateur1, String Pseudo2);
	public Utilisateur getAmis(Utilisateur utilisateur1);
}
