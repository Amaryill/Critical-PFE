package fr.eseo.criticalPfe.java.bo.objet;

import fr.eseo.criticalPfe.java.dao.objet.ObjetDAO;
import fr.eseo.criticalPfe.java.model.objet.Objet;

public class ObjetBOImpl implements ObjetBO {

	ObjetDAO dao;
	
	public ObjetBOImpl(){
		this.dao = new ObjetDAO();
	}
	
	@Override
	public Objet trouverObjet(Objet objet) {
		return this.dao.trouver(objet);
	}

	@Override
	public Objet creerObjet(Objet objet) {
		return this.dao.creer(objet);
	}

}
