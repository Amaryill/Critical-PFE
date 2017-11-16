package fr.eseo.criticalPfe.java.utils;

public class Outils {

	public static int getModificateurTaille(String taille) {
		return taille.equals("I") ? -8
				: taille.equals("Min") ? -6
						: taille.equals("TP") ? -4
								: taille.equals("P") ? -2 : taille.equals("M") ? 0 : taille.equals("G") ? 2
										: taille.equals("TG") ? 4
												: taille.equals("Gig") ? 6 : taille.equals("C") ? 8 : null;

	}
}
