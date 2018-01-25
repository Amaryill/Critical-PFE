package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.ArrayList;

import fr.eseo.criticalPfe.java.model.scenario.Campagne;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public interface CampagneBO {

	
	public ArrayList<Campagne> getListeCampagneByUnivers(Univers univers);
	public void supprimerCampagne(Campagne campagne);
	public void modifierCampagne(Campagne campagne);
	public void creerCampagne(Campagne campagne);
	public Campagne trouverCampagne(Campagne campagne);
}
