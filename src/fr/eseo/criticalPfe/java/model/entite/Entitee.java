package fr.eseo.criticalPfe.java.model.entite;

import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.attributs.Don;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.objet.Inventaire;
import fr.eseo.criticalPfe.java.utils.Image;

public abstract class Entitee extends Model {

	Caracteristique caracteristique;
	List<Competence> comptence;
	List<Don> dons;
	List<Sort> sorts;
	List<String> langues;
	Inventaire inventaire;	
	
	double facteurPuissance;
	
	Image image; // Peut être une liste si on veut pouvoir mettre plusieurs image d'une entitée importante ?

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

	public List<String> getLangues() {
		return langues;
	}

	public void setLangues(List<String> langues) {
		this.langues = langues;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}


	
}
	