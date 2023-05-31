package model;

import java.util.ArrayList;

import fx.Constante;

public class Panier {
	
	
	private Integer place=Constante.NB_FRUITS;
	private ArrayList<Fruits> contenu = new ArrayList<>();
	private Fruits fruit;
	
	
	public Panier(Fruits fruit) {
		this.fruit=fruit;
	}

	public Boolean verifPlace() {
		return place!=0;
	}
	
	public void montreContenu() {
		contenu.forEach((contenus) -> System.out.println(contenus));
	}
	
	
	
	public void remplir(Fruits objet) {
			
			contenu.add(objet);
			place--;
			System.out.printf("vous avez ajouter une %s au panier , il reste %d place(s)\n", objet,place);
			
	}

	public Fruits getFruit() {
		return fruit;
	}


}