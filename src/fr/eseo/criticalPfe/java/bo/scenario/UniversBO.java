package fr.eseo.criticalPfe.java.bo.scenario;

import java.util.List;

import fr.eseo.criticalPfe.java.dao.scenario.UniversDAO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class UniversBO {
	
	public Univers creationUnivers(String loginUtilisateur){
		ImplContenuBO contenuBO = new ImplContenuBO();
		ImplRegleBO regleBO = new ImplRegleBO();
		
		Utilisateur user = new Utilisateur();
		user.setPseudo(loginUtilisateur);
		Univers univers = new Univers("Nouvel Univers", "- Vide -",contenuBO.CreerContenu(),regleBO.CreerRegle());
		univers.setUser(user);
		
		return UniversDAO.getUniversDAO().creer(univers);
	}

	public void supprimerUnivers(int idUnivers) {
		Univers univers = new Univers();
		univers.setId(idUnivers);
		UniversDAO.getUniversDAO().supprimer(univers);
	}

	public List<Univers> getListeUnivers(String pseudoUtilisateur) {
		Univers univers = new Univers();
		Utilisateur user = new Utilisateur();
		user.setPseudo(pseudoUtilisateur);
		univers.setUser(user);
		return UniversDAO.getUniversDAO().trouverByPseudo(univers);
	}
	
	public Univers getUnivers(int idUnivers){
		Univers univers = new Univers();
		univers.setId(idUnivers);
		return UniversDAO.getUniversDAO().trouver(univers);
	}
	
	public void renommerUnivers(int idUnivers, String nouveauNom){
		Univers univers = this.getUnivers(idUnivers);
		univers.setNomUnivers(nouveauNom);
		modifierUnivers(univers);
	}
	
	public void editDescriptionUnivers(int idUnivers, String nouvelleDescription){
		Univers univers = this.getUnivers(idUnivers);
		System.out.println(univers.getContenu().getId());
		univers.setDescription(nouvelleDescription);
		modifierUnivers(univers);
	}

	private void modifierUnivers(Univers univers) {
		UniversDAO.getUniversDAO().modifier(univers);
	}
}
