package model;

import fx.Constante;

public class Corbeau extends ElementsVerger {

	private Panier puzzle;
	private Fruits specificite;
	private int piecesRestante ;
	public Corbeau(int nbAction,Panier puzzle) {
		super(Fruits.CORBEAU, nbAction, puzzle);
		this.piecesRestante=nbAction;
		this.puzzle = panier;
		specificite = Fruits.CORBEAU;
		
	}

	@Override
	public String toString() {
		return 9-piecesRestante + " pieces de puzzle";
	}

	@Override
	public void faitAction() {
		
		if (!verifActionRestante()) {
			piecesRestante--;
			((PuzzleCorbeau) puzzle).ajoutPiece();
			
			System.out.printf("une piece du %s a ete ajouter, %d piece(s) restante\n",specificite,piecesRestante);
		} else {
	
			System.out.println("le Corbeau a ete completé, vous avez perdu");
		}
	}
	
	@Override
	public Integer getActionRestante() {
		return piecesRestante;
	}
	
	@Override
	public Boolean verifActionRestante() {
		return piecesRestante==0;
	}
}
