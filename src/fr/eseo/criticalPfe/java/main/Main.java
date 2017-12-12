package fr.eseo.criticalPfe.java.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.bo.entite.PersonnageBO;
import fr.eseo.criticalPfe.java.bo.entite.PersonnageBOImpl;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;
import fr.eseo.criticalPfe.java.model.entite.Race;

public class Main {
	public static void main (String[] args){

		PersonnageBO personnageBO = new PersonnageBOImpl();
	
		Personnage personnage = new Personnage();
		Caracteristique caracteristique = new Caracteristique();
		HashMap<String, Integer> caracs = new HashMap<String, Integer>();
		Race race = new Race();
		Classe classe = new Classe();
		
		caracs.put("for", 18);
		caracs.put("dex", 18);
		caracs.put("con", 18);
		caracs.put("int", 18);
		caracs.put("sag", 18);
		caracs.put("cha", 18);
		caracteristique.setCaracs(caracs);
		caracteristique.setPointDeVieMax(20);
		personnage.setCaracteristique(caracteristique);

		race.setNom("Elfe");
		personnage.setRace(race);
		
		classe.setNom("Magicien");
		classe.setNiveau(1);
		personnage.ajouterClasse(classe);
		
		
		personnage.setFacteurPuissance(1);
		personnage.setAge(18);
		personnage.setNom("Suly GOD MODE !!!");
		personnage.setAlignement("Loyal Bon");
		personnage.setLangues("Commun, Elfique");
		personnage.setTaille(140);
		personnage.setPoids(41);
		personnage.setCouleurCheveux("Blanc");
		personnage.setCouleurYeux("Bleu");
		personnage.setSexe("F");
		personnage.setDieu("Avada");
		
		personnageBO.creerPersonnage(personnage);
	}
}
