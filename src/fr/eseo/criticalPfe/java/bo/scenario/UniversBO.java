package fr.eseo.criticalPfe.java.bo.scenario;

import fr.eseo.criticalPfe.java.dao.scenario.UniversDAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class UniversBO {
	
	public Univers creationUnivers(String loginUtilisateur){
		UniversDAO dAO = new UniversDAO();
		return dAO.creationUnivers(loginUtilisateur);
	}

}
