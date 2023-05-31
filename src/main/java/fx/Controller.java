package fx;

import java.util.ArrayList;

import javafx.collections.ObservableList;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox vBoxCentre;

    @FXML
    private VBox vBoxGauche;

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
    
    int nbColonne = (int) Math.round(Math.sqrt(Constante.NB_FRUITS));
    
    static ArrayList<Integer> fruitRestant=new ArrayList<>();
    static {
    	for (int i=0;i<4;i++ ) {
    		fruitRestant.add(0);
    	}
    }
    
    static ArrayList<GridPane> listeFruits=new ArrayList<>();

    private int tour=1;
    
    @FXML
    void lancerJeu(MouseEvent event) {
    	 int lancerDe=Constante.lancerDeDe();
    	
    	if (!Constante.tour(lancerDe,tour)) {
    		int restant=fruitRestant.get(lancerDe);
    		
    		imgDe.setVisible(true);
	    	imgDe.setImage(new Image(Constante.de.get(lancerDe).couleur()));
	    	fruitRestant.set(lancerDe,restant+1);
	    	
	    	labelTour.setVisible(true);
	    	labelTour.setText("Tour n°"+tour);

	    	recupereElement(restant/nbColonne,restant%nbColonne,lancerDe).setVisible(false);

	    	
	    	tour++;
	    	}else {
	    		labelTour.setText("Tous les fruits ont été retirés,\n la partie est finie au tour n°"+tour+".");
	    		btnDe.setVisible(false);
	    		imgDe.setVisible(false);
	    	}
    }
    
    
    
    @FXML
    void initialize() {
    	
    	borderPane.setBackground(new Background(new BackgroundImage(new Image("fond.png"), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));

        ArrayList<StackPane> arbres = new ArrayList<>();
        arbres.add(arbre1);
        arbres.add(arbre2);
        arbres.add(arbre3);
        arbres.add(arbre4);



        for (int j = 0; j < 4; j++) {

            ImageView imgArbre = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arbre.png")));
            arbres.get(j).getChildren().add(imgArbre);
            imgArbre.setPreserveRatio(true);
            imgArbre.setFitWidth(800);
            if (j % 2 == 1) {
                VBox.setVgrow(arbres.get(j), Priority.ALWAYS);
            }

            GridPane emplacementFruit = new GridPane();

            StackPane.setAlignment(emplacementFruit, Pos.CENTER);
            StackPane.setAlignment(imgArbre, Pos.CENTER);
            
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
            if(GridPane.getRowIndex(fruit).equals(ligne) && GridPane.getColumnIndex(fruit).equals(colonne)) {
                return fruit;
            }
        }
        return null;
    }
}
