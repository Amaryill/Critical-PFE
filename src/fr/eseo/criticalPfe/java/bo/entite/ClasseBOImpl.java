package fr.eseo.criticalPfe.java.bo.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.dao.entite.ClasseDAO;
import fr.eseo.criticalPfe.java.model.entite.Classe;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

public class ClasseBOImpl implements ClasseBO {

	private ClasseDAO dao;
	
	public ClasseBOImpl(){
		this.dao = new ClasseDAO();
	}
	
	public Classe trouverClasse(Classe classe){
		int niveau = classe.getNiveau();
		classe = this.dao.trouver(classe);
		classe.setNiveau(niveau);
		
		return classe;
	}
	
	public List<Classe> trouverClasses(List<Classe> classes){
		for(int i=0 ; i<classes.size() ; i++){
			classes.set(i, trouverClasse(classes.get(i)));
		}
		return classes;
	}
	
	public List<Classe> trouverToutesClasses(){
	    return this.dao.trouverTous();
	}

	@Override
	public List<Classe> trouverClassesParPersonnage(Personnage personnage) {
		System.out.println("On trouve les classe du personnage");
		return this.dao.trouverClassesParPersonnage(personnage);
	}
}
