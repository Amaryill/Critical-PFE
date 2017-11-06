package fr.eseo.criticalPfe.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BddBoAmi {
	/**
	 * Attributs de classe BddBO
	 */
	private BddDao bdd;

	/**
	 * Instance de BddBo, creation de la connexion à la bdd
	 */
	public BddBoAmi() {
		this.bdd = new BddDao();
	}

	/**
	 * Retourne la bdd
	 * 
	 * @return
	 */
	public BddDao getBdd() {
		return bdd;
	}

	/**
	 * Set la bdd
	 * 
	 * @param bdd
	 */
	public void setBdd(BddDao bdd) {
		this.bdd = bdd;
	}

	public void demandeAmi(String pseudo1, String pseudo2) {

		String demandeAmi = "INSERT INTO `demandeami` VALUES ('En_Attente','" + pseudo1 + "','" + pseudo2 + "')";
		this.bdd.prepareStmt(demandeAmi);
		this.bdd.executePrep();
	}

	public void annulerDemandeAmi(String pseudo1, String pseudo2) {

		String demandeAmi = "DELETE FROM `demandeami` WHERE `Login`='" + pseudo1 + "' and `Login_Utilisateur`='"
				+ pseudo2 + "' and `Etat`='En_Attente'";
		this.bdd.prepareStmt(demandeAmi);
		this.bdd.executePrep();
	}

	public void refuserAmi(String pseudo1, String pseudo2) {

		String refuserAmi = "DELETE FROM `demandeami` WHERE `Login` = '" + pseudo2 + "' and `Login_Utilisateur` = '"
				+ pseudo1 + "'";
		this.bdd.prepareStmt(refuserAmi);
		this.bdd.executePrep();
	}

	public void validerAmi(String pseudo1, String pseudo2) {

		String validerAmi = "INSERT INTO `ami` VALUES ('" + pseudo1 + "','" + pseudo2 + "')";
		this.bdd.prepareStmt(validerAmi);
		this.bdd.executePrep();
		validerAmi = "UPDATE `demandeami` SET `Etat`='Valide' WHERE `Login`='" + pseudo2 + "' and `Login_Utilisateur`='"
				+ pseudo1 + "'";
		this.bdd.prepareStmt(validerAmi);
		this.bdd.executePrep();
	}

	public void supprimerAmi(String pseudo1, String pseudo2) {

		String supprimerAmi = "DELETE FROM `ami` WHERE (`Login`='" + pseudo1 + "' AND `Login_Utilisateur` = '" + pseudo2
				+ "') OR (`Login`='" + pseudo2 + "' AND `Login_Utilisateur` = '" + pseudo1 + "')";
		this.bdd.prepareStmt(supprimerAmi);
		this.bdd.executePrep();
		supprimerAmi = "DELETE FROM `demandeAmi` WHERE (`Login`='" + pseudo1 + "' AND `Login_Utilisateur` = '" + pseudo2
				+ "') OR (`Login`='" + pseudo2 + "' AND `Login_Utilisateur` = '" + pseudo1 + "')";
		this.bdd.prepareStmt(supprimerAmi);
		this.bdd.executePrep();
	}

	public ArrayList<String> getListeAmi(String pseudo) throws SQLException {
		ArrayList<String> listeAmi = new ArrayList<>();
		String getAmis = "select * from ami where Login= '" + pseudo + "' or Login_Utilisateur = '" + pseudo + "'";
		this.bdd.prepareStmt(getAmis);
		ResultSet resultatAmi = this.bdd.executePrep();
		while (resultatAmi.next()) {
			if (resultatAmi.getString(1).equals(pseudo)) {
				listeAmi.add(resultatAmi.getString(2));
			} else {
				listeAmi.add(resultatAmi.getString(1));
			}
		}
		return listeAmi;
	}

	public ArrayList<String> getDemandesEnvoyees(String pseudo) throws SQLException {
		ArrayList<String> listeDemande = new ArrayList<>();
		String getDemandes = "select Login_Utilisateur from demandeAmi where Login= '" + pseudo
				+ "' and etat = 'En_Attente'";
		this.bdd.prepareStmt(getDemandes);
		ResultSet resultatDemande = this.bdd.executePrep();
		while (resultatDemande.next()) {
			listeDemande.add(resultatDemande.getString("Login_Utilisateur"));
		}
		return listeDemande;
	}

	public ArrayList<String> getDemandesRecues(String pseudo) throws SQLException {
		ArrayList<String> listeRecu = new ArrayList<>();
		String getReception = "select Login from demandeAmi where Login_Utilisateur= '" + pseudo
				+ "' and etat = 'En_Attente'";
		this.bdd.prepareStmt(getReception);
		ResultSet resultatReception = this.bdd.executePrep();
		while (resultatReception.next()) {
			listeRecu.add(resultatReception.getString("Login"));
		}
		return listeRecu;
	}
	
	public ArrayList<String> getDemandesValidees(String pseudo) throws SQLException {
		ArrayList<String> listeValide = new ArrayList<>();
		String getValide = "select Login_Utilisateur from demandeAmi where Login= '" + pseudo
				+ "' and etat = 'Valide'";
		this.bdd.prepareStmt(getValide);
		ResultSet resultatValidation = this.bdd.executePrep();
		while (resultatValidation.next()) {
			listeValide.add(resultatValidation.getString("Login_Utilisateur"));
		}
		for (String login : listeValide) {
			String deletValide = "DELETE FROM `demandeami` WHERE `Login` = '" + pseudo
					+ "' and `Login_Utilisateur` = '" + login + "'";
			this.bdd.prepareStmt(deletValide);
			this.bdd.executePrep();
		}
		return listeValide;
	}
	
	public ArrayList<String> getNonAmi(String pseudo) throws SQLException {
		ArrayList<String> listeNonAmi = new ArrayList<>();
		String getNonAmi = "SELECT `Login` FROM `utilisateur` WHERE Login not in "
				+ "(SELECT `Login` FROM `ami` WHERE `Login_Utilisateur` ='" + pseudo + "')"
				+ " and login not in (SELECT `Login_Utilisateur` FROM `ami` WHERE `Login` " + "='" + pseudo
				+ "') and login not in (SELECT `Login_Utilisateur` FROM `demandeAmi`" + " WHERE `Login` ='"
				+ pseudo + "') and login not in (SELECT `Login` FROM `demandeAmi"
				+ "` WHERE `Login_Utilisateur` ='" + pseudo + "') and login!='" + pseudo + "'";
		this.bdd.prepareStmt(getNonAmi);
		ResultSet resultatNonAmi = this.bdd.executePrep();
		while (resultatNonAmi.next()) {
			listeNonAmi.add(resultatNonAmi.getString("Login"));
		}
		return listeNonAmi;
	}

	/**
	 * Ferme la connexion à la bdd
	 */
	public void close() {
		this.bdd.closeBdd();
	}
}
