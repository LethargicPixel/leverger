package fx;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Controller {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox vBoxCentre;

    @FXML
    private VBox vBoxGauche;

    @FXML
    private GridPane gridCorbeau;
    
    @FXML
    private VBox vboxDroite;

    @FXML
    private StackPane arbre1;

    @FXML
    private StackPane arbre2;

    @FXML
    private StackPane arbre3;

    @FXML
    private StackPane arbre4;

    @FXML
    private Button btnDe;
    
    @FXML
    private ImageView imgDe;

    @FXML
    private Label labelTour;
    
    ArrayList<ImageView> puzzle = new ArrayList<>();
    
    int nbColonne = (int) Math.round(Math.sqrt(Constante.NB_FRUITS));
    
    static ArrayList<Label> labelsPanier = new ArrayList<>();
    
    static ArrayList<GridPane> listeFruits=new ArrayList<>();

    private int tour=1;
    
    @FXML
    void lancerJeu(MouseEvent event) {
    	int lancerDe=Constante.lancerDeDe();

    	int restant=Constante.arbres.get(lancerDe).getActionRestante()-1;
    	
    	if (Constante.tour(lancerDe,tour)) {
    		
    		
    		imgDe.setVisible(true);
	    	imgDe.setImage(new Image(Constante.de.get(lancerDe).couleur()));

	    	
	    	labelTour.setVisible(true);
	    	labelTour.setText("Tour n°"+tour);

	    	if (restant>=0 && lancerDe!=4) {
	    		recupereElement(restant/nbColonne,restant%nbColonne,lancerDe).setVisible(false);
	    		labelsPanier.get(lancerDe).setText(Constante.NB_FRUITS-restant+"/10");
	    	}
	    	
	    	if (lancerDe==4) {

	    		puzzle.get(8-Constante.arbres.get(4).getActionRestante()).setVisible(true);
	    	
	    	}
	    	
	    	tour++;
	    	}else {
    	
    	if (Constante.verifFinPartieFruit()) {
    			recupereElement(restant/nbColonne,restant%nbColonne,lancerDe).setVisible(false);
	    		labelTour.setText("Tous les fruits ont été retirés,\n la partie est gagné au tour n°"+tour+".");
	    		btnDe.setVisible(false);
	    		imgDe.setVisible(false);
	    	}else {
    	
    	if (Constante.verifFinPartieCorbeau()) {
    		puzzle.get(8).setVisible(true);
    		labelTour.setText("Le corbeau est apparu,\nla partie est perdue au tour n°"+tour+".");
    		btnDe.setVisible(false);
    		imgDe.setVisible(false);
    	}}}
    }
    
    
    
    
    
    
    @FXML
    void initialize() {
    	
    	borderPane.setBackground(new Background(new BackgroundImage(new Image("fond.png"), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));

        ArrayList<StackPane> arbres = new ArrayList<>();
        arbres.add(arbre1);
        arbres.add(arbre2);
        arbres.add(arbre3);
        arbres.add(arbre4);
        
        gridCorbeau.setVgap(40);
        gridCorbeau.setHgap(31);
        
        for (int x = 0; x < 9; x++) {
        	ImageView piece = new ImageView( new Image(getClass().getClassLoader().getResourceAsStream(x%3+""+x/3+".png")));
        	piece.setPreserveRatio(true);
        	piece.setFitWidth(100);
        	piece.setVisible(false);
        	gridCorbeau.add(piece,x%3,x/3);
        	puzzle.add(piece);
        }

        for (int j = 0; j < 4; j++) {

            ImageView imgArbre = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arbre.png")));
            ImageView imgPanier = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("panier.png")));
            
            Label labelPanier=new Label("0/10");
            

            labelPanier.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            
            labelsPanier.add(labelPanier);
            
            arbres.get(j).getChildren().add(imgArbre);
            arbres.get(j).getChildren().add(imgPanier);
            arbres.get(j).getChildren().add(labelPanier);
            
            imgArbre.setPreserveRatio(true);
            imgArbre.setFitWidth(800);
            
            imgPanier.setTranslateY(-90);
            imgPanier.setPreserveRatio(true);
            imgPanier.setFitWidth(200);
            
            labelPanier.setTranslateY(-120);
            labelPanier.setTranslateX(-80);
            


            GridPane emplacementFruit = new GridPane();

            StackPane.setAlignment(emplacementFruit, Pos.CENTER);
            StackPane.setAlignment(imgArbre, Pos.CENTER);
            StackPane.setAlignment(imgPanier, Pos.BOTTOM_RIGHT);
            StackPane.setAlignment(labelPanier, Pos.BOTTOM_RIGHT);  
            
            emplacementFruit.setMinWidth(0);
            emplacementFruit.setMaxWidth(200);
            emplacementFruit.setMinHeight(0);
            emplacementFruit.setMaxHeight(150);
            emplacementFruit.setTranslateY(-70);
            emplacementFruit.setTranslateX(30);
            
            for (int i = 0; i < Constante.NB_FRUITS; i++) {
                ImageView imgFruit = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(j + ".png")));
                imgFruit.setPreserveRatio(true);
                imgFruit.setFitHeight(50);
                emplacementFruit.add(imgFruit, i % nbColonne, i / nbColonne);
            }
            listeFruits.add(emplacementFruit);
            arbres.get(j).getChildren().add(emplacementFruit);
            
            

            
        }
        
        
    }
    public static Node recupereElement(Integer ligne, Integer colonne, int index) {
        for (Node fruit : Controller.listeFruits.get(index).getChildren()) {
            if(GridPane.getRowIndex(fruit)==(ligne) && GridPane.getColumnIndex(fruit)==(colonne)) {
                return fruit;
            }
        }
        return null;
    }
}
