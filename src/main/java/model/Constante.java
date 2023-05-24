package model;
import java.util.ArrayList;

public class Constante {
    public static ArrayList<Face> de = new ArrayList<Face>();
    static {
        for (Face face : Face.values()) {
            de.add(face);
        }
    }
    
    public static ArrayList<ElementsVerger> arbres = new ArrayList<>();
    static {
        arbres.add(new ElementsVerger(Face.COULEUR1,10,new Panier(Face.COULEUR1) ));
        arbres.add(new ElementsVerger(Face.COULEUR2,10,new Panier(Face.COULEUR2) ));
        arbres.add(new ElementsVerger(Face.COULEUR3,10,new Panier(Face.COULEUR3) ));
        arbres.add(new ElementsVerger(Face.COULEUR4,10,new Panier(Face.COULEUR4) ));
    }
    

    
    
    public static Integer nbTour = 1;
    public static String LIGNE="--------------------------------";
    
    
    
    
    public static boolean verifFinPartie() {
        Integer compte=0;
    	for (ElementsVerger arbre : arbres) {
            if (Boolean.FALSE.equals(arbre.verifActionRestante())) {
                compte++;
            }
        }
        return compte==4;
        
    }
    
    public static void etatVerger() {
    	for (ElementsVerger arbre : arbres) {
    		System.out.println(arbre.toString());
        }
    }
	public static void partieSolo() {
		
		while (!verifFinPartie()){
			
			System.out.println(LIGNE);
			etatVerger();
			System.out.println(nbTour+"ieme tours");
			arbres.get(lancerDeDe()).faitAction();
			nbTour++;
			System.out.println(LIGNE);
	
		}
		System.out.println("Plus de fruits restant la partie est fini");

	}
	
	
	public static int lancerDeDe() {
		
		return (int)(Math.random()*4);
	}
}

