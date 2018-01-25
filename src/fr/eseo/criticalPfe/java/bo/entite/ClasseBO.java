package fr.eseo.criticalPfe.java.bo.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public interface ClasseBO {

	public Classe trouverClasse(Classe classe);

	public List<Classe> trouverClasses(List<Classe> classes);
	
	public List<Classe> trouverToutesClasses();
	
	public List<Classe> trouverClassesParPersonnage(Personnage personnage);
}