package fr.eseo.criticalPfe.java.utils;

import java.util.Random;

public class De {

	int valeurDe;
	
	public De(int valeurDe){
		this.valeurDe = valeurDe;
	}

	public int getValeurDe() {
		return valeurDe;
	}

	public void setValeurDe(int valeurDe) {
		this.valeurDe = valeurDe;
	}
	
	public int lanceDe(){
		Random random = new Random();
		return(1+random.nextInt(valeurDe));
	}
	
}
