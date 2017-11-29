package fr.eseo.criticalPfe.java.dao.scenario;

import fr.eseo.criticalPfe.java.model.scenario.Univers;

public interface IUniversDAO {

	public boolean creerUnivers(Univers univers);
	
	public boolean supprimerUnivers(Univers univers);
	
	public Univers trouverUnivers(Univers univers);
	
	public boolean modifierUnivers(Univers newUnivers, Univers oldUnivers);
}
