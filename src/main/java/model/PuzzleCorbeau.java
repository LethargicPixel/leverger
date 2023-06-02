package model;

public class PuzzleCorbeau extends Panier {
	int pieceRestante;
	public PuzzleCorbeau() {
		super(Fruits.CORBEAU);
		pieceRestante=9;
	}


	public void ajoutPiece() {
		pieceRestante--;
		System.out.printf("une piece a ete placé, il reste %d piece(s)\n", pieceRestante);	
}
	@Override
	public Boolean verifPlace() {
		return pieceRestante==0;
}
}