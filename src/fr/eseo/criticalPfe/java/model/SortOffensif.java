package fr.eseo.criticalPfe.java.model;

import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.utils.De;

public class SortOffensif extends Sort {

	int degatBase;
	List<De> degatDes;
	
	public SortOffensif(int degatBase, List<De> degatDes, String nom, HashMap<Classe, Integer> levelSort, String ecole, String tempsIncantation,
			String composantes, int portee, int duree, String jetDeSauvegarde, String resistanceMagie,
			String description) {
		
		super(nom, levelSort, ecole, tempsIncantation, composantes, portee, duree, jetDeSauvegarde, resistanceMagie,
				description);
		this.degatBase = degatBase;
		this.degatDes = degatDes;
	}
}
