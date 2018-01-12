package fr.eseo.criticalPfe.java.model.attributs;

import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.utils.De;

public class SortOffensif extends Sort {

	int degatBase;
	List<De> degatDes;
	
	public SortOffensif(int degatBase, List<De> degatDes, String nom, String reference, HashMap<Classe, Integer> levelSort, String ecole, String tempsIncantation,
			String composantes, String portee, String cible, int duree, String jetDeSauvegarde, String resistanceMagie,
			String description) {
		
		super(nom, reference, levelSort, ecole, tempsIncantation, composantes, portee, cible, duree, jetDeSauvegarde, resistanceMagie,
				description);
		this.degatBase = degatBase;
		this.degatDes = degatDes;
	}
}
