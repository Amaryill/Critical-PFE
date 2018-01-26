package fr.eseo.criticalPfe.java.model.entite;

import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.attributs.Don;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.objet.Inventaire;

public abstract class Entitee extends Model {

	Integer idEntitee;
	


	String nom;
	
	Caracteristique caracteristique = new Caracteristique();
	List<Competence> comptence;
	List<Don> dons;
	List<Sort> sorts;
	String langues;
	Inventaire inventaire;	
	
	double facteurPuissance;
	
	public Integer getIdEntitee() {
		return idEntitee;
	}

	public void setIdEntitee(Integer idEntitee) {
		this.idEntitee = idEntitee;
	}

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public List<Competence> getComptence() {
		return comptence;
	}

	public void setComptence(List<Competence> comptence) {
		this.comptence = comptence;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}

	public String getLangues() {
		return langues;
	}

	public void setLangues(String langues) {
		this.langues = langues;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public double getFacteurPuissance() {
		return facteurPuissance;
	}

	public void setFacteurPuissance(double facteurPuissance) {
		this.facteurPuissance = facteurPuissance;
	}
	
	public int getModificateur(Carac carac){
	    int valeur = 0;
	    int modificateur = 0;
	    switch(carac){
	    case FOR :
	        valeur = caracteristique.getCaracs().get(Carac.FOR.getAbrev());
	        break;
	    case INT :
	        valeur = caracteristique.getCaracs().get(Carac.INT.getAbrev());
            break;
	    case SAG :
	        valeur = caracteristique.getCaracs().get(Carac.SAG.getAbrev());
            break;
	    case CHA :
	        valeur = caracteristique.getCaracs().get(Carac.CHA.getAbrev());
            break;
	    case DEX :
	        valeur = caracteristique.getCaracs().get(Carac.DEX.getAbrev());
            break;
	    case CON :
	        valeur = caracteristique.getCaracs().get(Carac.CON.getAbrev());
            break;
        default :
            return 0;
	    }
	    modificateur = -5 + Math.floorDiv(valeur, 2);
	    
	    return modificateur;
	}
	
	public HashMap<String, Integer> getAllModificateurs(){
	    HashMap<String, Integer> modificateurs = new HashMap<>();
	    modificateurs.put(Carac.INT.getAbrev(), this.getModificateur(Carac.INT));
	    modificateurs.put(Carac.FOR.getAbrev(), this.getModificateur(Carac.FOR));
	    modificateurs.put(Carac.DEX.getAbrev(), this.getModificateur(Carac.DEX));
	    modificateurs.put(Carac.SAG.getAbrev(), this.getModificateur(Carac.SAG));
	    modificateurs.put(Carac.CON.getAbrev(), this.getModificateur(Carac.CON));
	    modificateurs.put(Carac.CHA.getAbrev(), this.getModificateur(Carac.CHA));
	    
	    return modificateurs;
	}
}
	