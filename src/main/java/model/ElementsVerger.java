package model;

public class ElementsVerger {
private Face specificite;
private Integer actionRestante;

public ElementsVerger(Face specificite, Integer actionTotal) {
	super();
	this.specificite = specificite;
	this.actionRestante = actionTotal;
}

public Boolean verifActionRestante() {
	return actionRestante!=0;
}

public void faitAction() {
	if (Boolean.TRUE.equals(verifActionRestante())) {
		actionRestante--;
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

