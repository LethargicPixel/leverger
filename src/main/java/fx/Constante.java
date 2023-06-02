package fx;
import java.util.ArrayList;

import model.Corbeau;
import model.ElementsVerger;
import model.Fruits;
import model.Panier;
import model.PuzzleCorbeau;

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
        arbres.add(new Corbeau(9, new PuzzleCorbeau()));
    }


    
    
    public static Integer nbTour = 1;
    public static String LIGNE="--------------------------------";
    
    
    
    
    public static Boolean verifFinPartieFruit() {
        Integer compte=0;
    	for (int i=0;i<4;i++) {
            if (arbres.get(i).verifActionRestante()) {
                compte++;
            }
        }

        return compte==4;
        
    }
    
    public static Boolean verifFinPartieCorbeau() {
    	return arbres.get(4).verifActionRestante();
    }
    
    public static void etatVerger() {
    	for (ElementsVerger arbre : arbres) {
    		System.out.println(arbre.toString());
        }
    }
	public static Boolean tour(int numero,int nbTour) {
		
		System.out.println(LIGNE);
		arbres.get(numero).faitAction();
		etatVerger();
		System.out.println(nbTour+"ieme tours");

		System.out.println(LIGNE);
		
		if (verifFinPartieFruit()){
			
			System.out.println("Plus de fruits restant la partie est gagné");
			return false;
		}
		
		if (verifFinPartieCorbeau()){
			
			System.out.println("le puzzle du corbeau a ete completer, la partie est perdu");

			return false;
		}

		return true;

		

	}
	
	
	public static int lancerDeDe() {
		
		return (int) (Math.random()*arbres.size());
	}
}

