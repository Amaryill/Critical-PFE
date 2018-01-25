package fr.eseo.criticalPfe.java.model.entite;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.criticalPfe.java.model.attributs.Compendium;
import fr.eseo.criticalPfe.java.model.attributs.Competence;
import fr.eseo.criticalPfe.java.model.scenario.Univers;
import fr.eseo.criticalPfe.java.model.utilisateur.Utilisateur;

public class Personnage extends Entitee {

    String nom;

    Utilisateur utilisateur = new Utilisateur();
    Univers univers = new Univers();

    List<Classe> classes = new ArrayList<Classe>();
    Race race = new Race();
    String alignement;
    String dieu;
    String sexe;
    String couleurYeux;
    String couleurCheveux;

    Compendium compendium = new Compendium();

    int taille;
    int age;
    int poids;

    public Personnage() {
        // TODO Auto-generated constructor stub
    }
    
    public Personnage(int id) {
        this.idEntitee = id;
    }

    public String getNom () {
        return nom;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public List<Classe> getClasses () {
        return classes;
    }

    public void setClasses (List<Classe> classes) {
        this.classes = classes;
    }

    public Race getRace () {
        return race;
    }

    public void setRace (Race race) {
        this.race = race;
    }

    public String getAlignement () {
        return alignement;
    }

    public void setAlignement (String alignement) {
        this.alignement = alignement;
    }

    public String getDieu () {
        return dieu;
    }

    public void setDieu (String dieu) {
        this.dieu = dieu;
    }

    public String getSexe () {
        return sexe;
    }

    public void setSexe (String sexe) {
        this.sexe = sexe;
    }

    public String getCouleurYeux () {
        return couleurYeux;
    }

    public void setCouleurYeux (String couleurYeux) {
        this.couleurYeux = couleurYeux;
    }

    public String getCouleurCheveux () {
        return couleurCheveux;
    }

    public void setCouleurCheveux (String couleurCheveux) {
        this.couleurCheveux = couleurCheveux;
    }

    public int getTaille () {
        return taille;
    }

    public void setTaille (int taille) {
        this.taille = taille;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public int getPoids () {
        return poids;
    }

    public void setPoids (int poids) {
        this.poids = poids;
    }

    public Compendium getCompendium () {
        return compendium;
    }

    public void setCompendium (Compendium compendium) {
        this.compendium = compendium;
    }

    public void ajouterClasse (Classe classe) {
        this.classes.add(classe);
    }

    public Utilisateur getUtilisateur () {
        return utilisateur;
    }

    public void setUtilisateur (Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Univers getUnivers () {
        return this.univers;
    }

    public void setUnivers (Univers univers) {
        this.univers = univers;
    }

    public int getNiveau () {
        return (int) this.getFacteurPuissance();
    }

    public String toString () {
        return ("Personnage : " + nom + " ; couleur : " + couleurCheveux);
    }

    public String toStringClasses () {
        String result = "";
        if (classes != null && classes.size() > 0) {
            for (int i = 0; i < classes.size() - 1; i++) {
                result += classes.get(i).getNom() + " - ";
            }
            result += classes.get(classes.size() - 1).getNom();
        }
        return result;
    }

    public int getPointsCompRestants () {
        int capital = this.getMaxPointsComp();
        if (capital > 0 && this.getComptence() != null) {
            for (Competence c : this.getComptence()) {
                capital -= c.getNiveauCompetence();
            }
        }

        return capital;
    }

    public int getMaxPointsComp () {
        int capital = 0;
        if (this.classes != null) {
            for (Classe c : this.classes) {
                capital += this.getCaracteristique().getModificateurs().get("int") + c.getNiveau() * c.getPointCompetenceNiveau();
            }
        }

        return capital;
    }
}
