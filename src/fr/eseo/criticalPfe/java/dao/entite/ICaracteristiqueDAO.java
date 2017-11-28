package fr.eseo.criticalPfe.java.dao.entite;

import fr.eseo.criticalPfe.java.model.entite.Caracteristique;

public interface ICaracteristiqueDAO {

	public boolean creer(Caracteristique caracteristique);
	
	public boolean supprimer(Caracteristique caracteristique);
	
	public boolean trouver(Caracteristique caracteristique);
	
	public boolean modifier(Caracteristique caracteristiqueNouvelle, Caracteristique caracterisitiqueAncienne);
}
