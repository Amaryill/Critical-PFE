package fr.eseo.criticalPfe.java.bo.scenario;

import fr.eseo.criticalPfe.java.dao.scenario.UniversDAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class UniversBO {
	
	UniversDAO dao;
	
	public UniversBO(UniversDAO dao){
		this.dao = dao;
	}
	
	public void creationUnivers(Univers univers){
		dao.creer(univers);
	}

}
