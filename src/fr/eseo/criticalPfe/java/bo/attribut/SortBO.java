package fr.eseo.criticalPfe.java.bo.attribut;

import java.util.Map;

import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public interface SortBO {
	
	public void ajouterSort(Sort sort, Personnage personnage);
	public void supprimerSort(Sort sort);
	public Map<Personnage,Sort> trouverSortDuPersonnage(Personnage personnage);
	public Sort trouverSort(Sort sort);
	
}
