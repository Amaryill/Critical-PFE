package fr.eseo.criticalPfe.java.bo.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Personnage;

public interface PersonnageBO {
	
	// Je met la structure de la méthode que je vais implémenter dans PersonnageBOImpl
	public Personnage creerPersonnage(Personnage personnage);
	
	public Personnage trouverPersonnage(Personnage personnage);
	
	public List<Personnage> trouverPersonnageParUtilisateur(String pseudo);
}
