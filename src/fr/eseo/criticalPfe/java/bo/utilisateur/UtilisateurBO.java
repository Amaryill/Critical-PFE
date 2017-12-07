package fr.eseo.criticalPfe.java.bo.utilisateur;

import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public interface UtilisateurBO {
	public Utilisateur creerUtilisateur(Utilisateur utilisateur);
	public Utilisateur modifUtilisateur(Utilisateur utilisateur);
	public Utilisateur pullUtilisateur(Utilisateur utilisateur);
	public Utilisateur connexion(Utilisateur utilisateur);
}
