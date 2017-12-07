package fr.eseo.criticalPfe.java.model.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.attributs.Don;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.objet.Inventaire;
import fr.eseo.criticalPfe.java.utils.Image;

public abstract class Entitee extends Model {

	Integer idEntitee;
	


	String nom;
	
	Caracteristique caracteristique;
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
}
	