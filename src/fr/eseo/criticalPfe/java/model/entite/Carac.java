package fr.eseo.criticalPfe.java.model.entite;

public enum Carac {
    FOR("Force", "for"),
    INT("Intelligence", "int"),
    CHA("Charisme", "cha"),
    DEX("Dextérité", "dex"),
    SAG("Sagesse", "sag"),
    CON("Constitution", "con");
    
    private String nomComplet = "";
    private String abrev = "";
    
    private Carac(String nomComplet, String abrev){
        this.nomComplet = nomComplet;
        this.abrev = abrev;
    }
    
    public String getNomComplet(){
        return nomComplet;
    }
    
    public String getAbrev(){
        return abrev;
    }
}
