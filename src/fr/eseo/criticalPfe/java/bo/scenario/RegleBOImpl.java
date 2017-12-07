package fr.eseo.criticalPfe.java.bo.scenario;

import fr.eseo.criticalPfe.java.dao.scenario.RegleDAO;
import fr.eseo.criticalPfe.java.model.scenario.Regle;

public class RegleBOImpl implements RegleBO{
	
	public Regle CreerRegle(){
		Regle regle = new Regle();
		return RegleDAO.getRegleDAO().creer(regle);
	}
}
