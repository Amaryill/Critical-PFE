package fr.eseo.criticalPfe.java.model.objet;

import java.util.Arrays;
import java.util.List;

public class Argent {

	int piecePlatine;
	int pieceOr;
	int pieceArgent;
	int pieceBronze;

	public Argent(int piecePlatine, int pieceOr, int pieceArgent, int pieceBronze) {
		this.piecePlatine = piecePlatine;
		this.pieceOr = pieceOr;
		this.pieceArgent = pieceArgent;
		this.pieceBronze = pieceBronze;
	}

	public Argent() {
		this(0, 0, 0, 0);
	}

	public int getPiecePlatine() {
		return piecePlatine;
	}

	public void setPiecePlatine(int piecePlatine) {
		this.piecePlatine = piecePlatine;
	}

	public int getPieceOr() {
		return pieceOr;
	}

	public void setPieceOr(int pieceOr) {
		this.pieceOr = pieceOr;
	}

	public int getPieceArgent() {
		return pieceArgent;
	}

	public void setPieceArgent(int pieceArgent) {
		this.pieceArgent = pieceArgent;
	}

	public int getPieceBronze() {
		return pieceBronze;
	}

	public void setPieceBronze(int pieceBronze) {
		this.pieceBronze = pieceBronze;
	}

	public int getValeur() {
		return (this.pieceBronze + 10 * this.pieceArgent + 100 * this.pieceOr + 1000 * this.piecePlatine);
	}

	public List<Integer> payer(int valeur) {


		return this.monaie(valeur);
	}
	
	
	private List<Integer> monaie(int valeur){
		List<Integer> valeurPieces = Arrays.asList(new Integer[]{1000,100,10,1});
	    List<Integer> monaie = Arrays.asList(new Integer[]{0,0,0,0});
	    
	    for (int i = 0; i < monaie.size(); i++ )
	    {
	    	monaie.set(i, valeur / valeurPieces.get(i));
	        valeur %= valeurPieces.get(i);
	    }
	    
	    return monaie;
	}

	public String toString() {
		return ("Valeur bourse : " + this.getValeur() + " (" + this.piecePlatine + " PP, " + this.pieceOr + " PO, "
				+ this.pieceArgent + " PA, " + this.pieceBronze + " PB)");
	}
}
