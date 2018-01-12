package fr.eseo.criticalPfe.java.bo.entite;

import java.util.ArrayList;

import fr.eseo.criticalPfe.java.model.entite.Race;

public interface RaceBO {

	public Race trouverRace(Race race);
	
	public ArrayList<Race> trouverToutesRaces();
}
