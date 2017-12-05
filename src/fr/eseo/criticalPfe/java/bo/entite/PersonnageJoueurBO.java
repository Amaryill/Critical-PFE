package fr.eseo.criticalPfe.java.bo.entite;

import fr.eseo.criticalPfe.java.dao.entite.PersonnageDAO;
import fr.eseo.criticalPfe.java.dao.entite.PersonnageJoueurDAO;
import fr.eseo.criticalPfe.java.model.entite.PersonnageJoueur;

public class PersonnageJoueurBO {

	PersonnageJoueurDAO dao;
	
	public PersonnageJoueurBO(PersonnageJoueurDAO dao){
		this.dao = dao;
	}
	
	public void creationUnivers(PersonnageJoueur personnageJoueur){
		dao.creer(personnageJoueur);
		
		PersonnageBO boPersonnage = new PersonnageBO(new PersonnageDAO());
		boPersonnage.creerPersonnage(personnageJoueur);
	}

}
