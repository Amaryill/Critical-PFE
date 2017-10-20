package fr.eseo.criticalPfe.model;

public class Caracteristique {

	/********************* ATTRIBUTS *************************/
	
	int force;
	int dexterie;
	int constitution;
	int intelligence;
	int sagesse;
	int charisme;
	
	int pointDeVie;
	int pointDeVieMax;
	
	int reflexe;
	int vigueur;
	int volonte;
	
	int initiative;
	
	int bonusAttaque;
	int bonusAttaqueCac;
	int bonusAttaqueDistance;

	double vitesse;
	
	String taille;
	
	int classeArmure;
	int bba;
	int bmo;
	int dmd;
	
	
	/************** ACCESSEURS ET MUTATEURS ******************/
	
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getDexterie() {
		return dexterie;
	}
	public void setDexterie(int dexterie) {
		this.dexterie = dexterie;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getSagesse() {
		return sagesse;
	}
	public void setSagesse(int sagesse) {
		this.sagesse = sagesse;
	}
	public int getCharisme() {
		return charisme;
	}
	public void setCharisme(int charisme) {
		this.charisme = charisme;
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
	public int getBonusAttaque() {
		return bonusAttaque;
	}
	public void setBonusAttaque(int bonusAttaque) {
		this.bonusAttaque = bonusAttaque;
	}
	public int getBonusAttaqueCac() {
		return bonusAttaqueCac;
	}
	public void setBonusAttaqueCac(int bonusAttaqueCac) {
		this.bonusAttaqueCac = bonusAttaqueCac;
	}
	public int getBonusAttaqueDistance() {
		return bonusAttaqueDistance;
	}
	public void setBonusAttaqueDistance(int bonusAttaqueDistance) {
		this.bonusAttaqueDistance = bonusAttaqueDistance;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public int getClasseArmure() {
		return classeArmure;
	}
	public void setClasseArmure(int classeArmure) {
		this.classeArmure = classeArmure;
	}
	public int getBba() {
		return bba;
	}
	public void setBba(int bba) {
		this.bba = bba;
	}
	public int getBmo() {
		return bmo;
	}
	public void setBmo(int bmo) {
		this.bmo = bmo;
	}
	public int getDmd() {
		return dmd;
	}
	public void setDmd(int dmd) {
		this.dmd = dmd;
	}
}
