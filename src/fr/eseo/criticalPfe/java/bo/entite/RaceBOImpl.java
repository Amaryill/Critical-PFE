package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.RaceDAO;
import fr.eseo.criticalPfe.java.model.entite.Race;

public class RaceBOImpl implements RaceBO {

	private RaceDAO dao;
	
	public RaceBOImpl(){
		this.dao = new RaceDAO();
	}
	
	public Race trouverRace(Race race){
		return this.dao.trouver(race);
	}
}
