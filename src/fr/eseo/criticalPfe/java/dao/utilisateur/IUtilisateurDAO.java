package fr.eseo.criticalPfe.java.dao.utilisateur;

import fr.eseo.criticalPfe.java.dao.DAOException;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public interface IUtilisateurDAO {

	    void creer( Utilisateur utilisateur ) throws DAOException;

	    Utilisateur trouver( String email ) throws DAOException;

}