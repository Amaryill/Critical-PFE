package fr.eseo.criticalPfe.java.bo.attribut;

import java.util.Map;

import fr.eseo.criticalPfe.java.dao.attribut.SortDAO;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class SortBOImpl implements SortBO {

	private static SortDAO sortDAO;
	
	public SortBOImpl(){
		sortDAO = new SortDAO();
	}
	
	@Override
	public void ajouterSort(Sort sort, Personnage personnage) {
		sortDAO.ajoutListeSort(sort, personnage);
	}

	@Override
	public void supprimerSort(Sort sort) {
		sortDAO.supprimerListeSort(sort);
	}

	@Override
	public Map<Personnage, Sort> trouverSortDuPersonnage(Personnage personnage) {
		
		return sortDAO.trouverListeSort(personnage);
		
	}
	@Override
	public Sort trouverSort(Sort sort) {
		return sortDAO.trouver(sort);
	}

	

}
