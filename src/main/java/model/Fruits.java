package model;

public enum Fruits {
	
CERISE("rouge.png"),
PRUNES("violet.png"),
POIRES("jaune.png"),
POMMES("vert.png"),
CORBEAU("noire.png");



private String values;

private Fruits(String values) {
	this.values=values;
}

public String couleur() {
	return this.values;
}

}
