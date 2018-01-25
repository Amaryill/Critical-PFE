package fr.eseo.criticalPfe.java.bo.attribut;

import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public interface SortBO {
	
	public void ajouterSort(Sort sort, Personnage personnage);
	public void supprimerSort(Sort sort);
	public void trouverSortDuPersonnage(Sort sort);
	public Sort trouverSort(Sort sort);
	
}
