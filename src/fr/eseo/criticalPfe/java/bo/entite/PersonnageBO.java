package fr.eseo.criticalPfe.java.bo.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Personnage;

public interface PersonnageBO {
	
	// Je met la structure de la m�thode que je vais impl�menter dans PersonnageBOImpl
	public Personnage creerPersonnage(Personnage personnage);
	
	public Personnage trouverPersonnage(Personnage personnage);
	
	public List<Personnage> trouverPersonnageParUtilisateur(String pseudo);
}
