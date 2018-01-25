package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.List;

import fr.eseo.criticalPfe.java.model.scenario.Univers;

public interface UniversBO {

	public Univers creationUnivers(String loginUtilisateur);
	public void supprimerUnivers(int idUnivers);
	public List<Univers> getListeUnivers(String pseudoUtilisateur);
	public Univers getUnivers(int idUnivers);
	public void renommerUnivers(int idUnivers, String nouveauNom);
	public void editDescriptionUnivers(int idUnivers, String nouvelleDescription);
	public void modifierUnivers(Univers univers);
}
