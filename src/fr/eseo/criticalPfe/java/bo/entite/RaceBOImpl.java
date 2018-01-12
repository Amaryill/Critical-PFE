package fr.eseo.criticalPfe.java.bo.entite;

import java.util.ArrayList;

import fr.eseo.criticalPfe.java.dao.entite.RaceDAO;
import fr.eseo.criticalPfe.java.model.entite.Race;

public class RaceBOImpl implements RaceBO {

	private RaceDAO dao;
	
	public RaceBOImpl(){
		this.dao = new RaceDAO();
	}
	
	@Override
	public Race trouverRace(Race race){
		return this.dao.trouver(race);
	}
	
	@Override
	public ArrayList<Race> trouverToutesRaces() {
	    return this.dao.trouverTous();
	}
}
