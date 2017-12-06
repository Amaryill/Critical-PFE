package fr.eseo.criticalPfe.java.bo.scenario;

import fr.eseo.criticalPfe.java.dao.scenario.ContenuDAO;
import fr.eseo.criticalPfe.java.model.scenario.Contenu;

public class ImplContenuBO implements ContenuBO{
	
	public Contenu CreerContenu(){
		Contenu contenu = new Contenu();
		return ContenuDAO.getContenuDAO().creer(contenu);
	}
}
