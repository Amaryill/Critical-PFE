package fr.eseo.criticalPfe.java.model.entite;

import java.util.HashMap;
import java.util.List;

import fr.eseo.criticalPfe.java.model.Model;
import fr.eseo.criticalPfe.java.utils.Outils;

/**
 * 
 * @author Maxime pv ou point competence bonus dans classe prédilection
 *
 */
public class Caracteristique extends Model {

	/********************* ATTRIBUTS *************************/

	HashMap<String, Integer> caracs = new HashMap<String, Integer>(); // OK
	HashMap<String, Integer> modificateurs = new HashMap<String, Integer>(); // OK

	int pointDeVie;
	int pointDeVieMax;

	int reflexe;
	int vigueur;
	int volonte;

	int initiative;

	int vitesse;

	String taille;

	int bba;
	int bac;
	int bad;
	int ca;
	// int bmo;
	// int dmd;

	public Caracteristique(HashMap<String, Integer> caracs, HashMap<String, Integer> modificateurs, int pointDeVie,
			int pointDeVieMax, int reflexe, int volonte, int vigueur, int initiative, int bac, int bad, int vitesse,
			String taille, int ca, int bba
	// , int bmo, int dmd
	) {
		this.caracs = caracs;
		this.modificateurs = modificateurs;
		this.pointDeVie = pointDeVie;
		this.pointDeVieMax = pointDeVieMax;
		this.reflexe = reflexe;
		this.vigueur = vigueur;
		this.volonte = volonte;
		this.initiative = initiative;
		this.bac = bac;
		this.bad = bad;
		this.vitesse = vitesse;
		this.taille = taille;
		this.ca = ca;
		this.bba = bba;
		// this.bmo = bmo;
		// this.dmd = dmd;
	}

	public Caracteristique(HashMap<String, Integer> caracs, List<Classe> classes, Race race) {
		this.caracs = new HashMap<String, Integer>();
		this.modificateurs = new HashMap<String, Integer>();

		for (String carac : caracs.keySet()) {
			this.caracs.put(carac, caracs.get(carac));
			this.modificateurs.put(carac, (caracs.get(carac) / 2) - 5);
		}

		this.reflexe = modificateurs.get("dex");
		this.volonte = modificateurs.get("int");
		this.vigueur = modificateurs.get("con");
		this.bba = 0;

		for (Classe classe : classes) {
			this.reflexe += classe.getReflexe();
				this.volonte += classe.getVolonte();
				this.vigueur += classe.getVigueur();
			this.bba += classe.getBba();
		}

		this.initiative = this.getModificateurs().get("dex");
		this.vitesse = race.getVitesse();
		this.taille = race.getTaille();
		this.ca = 10 + modificateurs.get("dex") - Outils.getModificateurTaille(race.getTaille());
		this.bac = bba + modificateurs.get("for") + Outils.getModificateurTaille(race.getTaille());
		this.bad = bba + modificateurs.get("dex") + Outils.getModificateurTaille(race.getTaille());
	}

	public Caracteristique() {
		// TODO Auto-generated constructor stub
	}

	/************** ACCESSEURS ET MUTATEURS ******************/

	public HashMap<String, Integer> getCaracs() {
		return caracs;
	}

	public void setCaracs(HashMap<String, Integer> caracs) {
		this.caracs = caracs;
		for (String carac : caracs.keySet()) {
			this.modificateurs.put(carac, (caracs.get(carac) / 2) - 5);
		}
	}

	public HashMap<String, Integer> getModificateurs() {
		return modificateurs;
	}

	public void setModificateurs(HashMap<String,	 Integer> modificateurs) {
		this.modificateurs = modificateurs;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getPointDeVieMax() {
		return pointDeVieMax;
	}

	public void setPointDeVieMax(int pointDeVieMax) {
		this.pointDeVieMax = pointDeVieMax;
	}

	public int getReflexe() {
		return reflexe;
	}

	public void setReflexe(int reflexe) {
		this.reflexe = reflexe;
	}

	public int getVigueur() {
		return vigueur;
	}

	public void setVigueur(int vigueur) {
		this.vigueur = vigueur;
	}

	public int getVolonte() {
		return volonte;
	}

	public void setVolonte(int volonte) {
		this.volonte = volonte;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public int getCa() {
		return ca;
	}

	public void setCa(int ca) {
		this.ca = ca;
	}

	public int getBba() {
		return bba;
	}

	public void setBba(int bba) {
		this.bba = bba;
	}

	// public int getBmo() {
	// return bmo;
	// }
	//
	// public void setBmo(int bmo) {
	// this.bmo = bmo;
	// }
	//
	// public int getDmd() {
	// return dmd;
	// }
	//
	// public void setDmd(int dmd) {
	// this.dmd = dmd;
	// }
}
