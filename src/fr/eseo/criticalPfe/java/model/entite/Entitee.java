package fr.eseo.criticalPfe.java.model.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.attributs.Don;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.objet.Inventaire;
import fr.eseo.criticalPfe.java.utils.Image;

public abstract class Entitee {

	Caracteristique caracteristique;
	List<Competence> comptence;
	List<Don> dons;
	List<Sort> sorts;
	List<String> langues;
	Inventaire inventaire;	
	
	double facteurPuissance;
	
	Image image; // Peut être une liste si on veut pouvoir mettre plusieurs image d'une entitée importante ?
	
}
	