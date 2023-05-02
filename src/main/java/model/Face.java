package model;

public enum Face {
COULEUR1("Pommes"),
COULEUR2("Poires"),
COULEUR3("Banane"),
COULEUR4("Peches");

private String values;

private Face(String values) {
	this.values=values;
}

public String toText() {
	return this.values;
}

}
