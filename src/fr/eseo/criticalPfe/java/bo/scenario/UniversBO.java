package fr.eseo.criticalPfe.java.bo.scenario;

import fr.eseo.criticalPfe.java.dao.scenario.UniversDAO;

public class UniversBO {
	
	public void creationUnivers(String loginUtilisateur){
		UniversDAO dAO = new UniversDAO();
		dAO.creationUnivers(loginUtilisateur);
	}

}
