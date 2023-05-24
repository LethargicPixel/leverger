package model;

public class ElementsVerger {
private Face specificite;
private Integer actionRestante;
private Panier panier;

public ElementsVerger(Face specificite, Integer actionTotal,Panier panier) {
	super();
	this.specificite = specificite;
	this.actionRestante = actionTotal;
	this.panier=panier;
}

public Boolean verifActionRestante() {
	return actionRestante!=0;
}

public void faitAction() {
	if (Boolean.TRUE.equals(verifActionRestante())) {
		actionRestante--;
		panier.remplir(specificite);
		System.out.printf("le fruit %s a ete retirer de larbre, %d fruit(s) restant\n",specificite.toText(),actionRestante);
	} else {
		System.out.printf("le fruit %s n'a pas pu etre recuperer\n",specificite.toText());
	}
}

@Override
public String toString() {
	return actionRestante +" "+ specificite.toText()+" restant";
}





}	

