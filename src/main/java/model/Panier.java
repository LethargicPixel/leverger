package model;

import java.util.ArrayList;

public class Panier {
	
	
	private Integer place=10;
	private ArrayList<Face> contenu = new ArrayList<>();
	private Face fruit;
	
	
	public Panier(Face fruit) {
		this.setFruit(fruit);
	}

	public Boolean verifPlace() {
		return place!=0;
	}
	
	public void montreContenu() {
		contenu.forEach((contenus) -> System.out.println(contenus.toText()));
	}
	
	
	
	public void remplir(Face objet) {
			System.out.printf("vous avez ajouter une %s au panier , il reste %d place(s)\n", objet.toText(),place);
			contenu.add(objet);
			place--;
			
			
	}

	public Face getFruit() {
		return fruit;
	}


}