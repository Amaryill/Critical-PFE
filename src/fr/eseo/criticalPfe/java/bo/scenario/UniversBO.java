package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.dao.scenario.UniversDAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

public class UniversBO {
	
	public Univers creationUnivers(String loginUtilisateur){
		UniversDAO dAO = new UniversDAO();
		return dAO.creationUnivers(loginUtilisateur);
	}

	public void supprimerUnivers(int idUnivers, String utilisateur) {
		UniversDAO dAO = new UniversDAO();
		dAO.supprimerUnivers(idUnivers,utilisateur);
	}

	public List<Univers> getListeUnivers(String loginUtilisateur) {
		UniversDAO dAO = new UniversDAO();
		return dAO.getListeUnivers(loginUtilisateur);
	}
	
	public Univers getUnivers(int idUnivers){
		UniversDAO dAO = new UniversDAO();
		return dAO.getUnivers(idUnivers);
	}

}
