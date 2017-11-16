package fr.eseo.criticalPfe.java.model;

import java.util.List;

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
	