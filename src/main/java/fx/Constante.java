package fx;
import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ElementsVerger;
import model.Fruits;
import model.Panier;

public class Constante {
	
	
	public static final int NB_FRUITS = 10;
	
	public static ArrayList<Fruits> de = new ArrayList<Fruits>();
    
    static {
        for (Fruits face : Fruits.values()) {
            de.add(face);
        }
    }
    
    
    
    public static ArrayList<ElementsVerger> arbres = new ArrayList<>();
    static {
        arbres.add(new ElementsVerger(Fruits.CERISE,NB_FRUITS,new Panier(Fruits.CERISE) ));
        arbres.add(new ElementsVerger(Fruits.PRUNES,NB_FRUITS,new Panier(Fruits.PRUNES) ));
        arbres.add(new ElementsVerger(Fruits.POIRES,NB_FRUITS,new Panier(Fruits.POIRES) ));
        arbres.add(new ElementsVerger(Fruits.POMMES,NB_FRUITS,new Panier(Fruits.POMMES) ));
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
	public static boolean tour(int numero,int nbTour) {
		
		if (verifFinPartie()){
			
			System.out.println("Plus de fruits restant la partie est fini");
			return true;
		}
		
		System.out.println(LIGNE);
		etatVerger();
		System.out.println(nbTour+"ieme tours");
		arbres.get(numero).faitAction();

		System.out.println(LIGNE);
		return false;

		

	}
	
	
	public static int lancerDeDe() {
		
		return (int)(Math.random()*4);
	}
}

