package fx;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VergerFx extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException{
    	
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();

        int largeur = (int) tailleEcran.getWidth();
        int hauteur = (int) tailleEcran.getHeight();

    	
    	
        Parent pane = FXMLLoader.load(getClass().getResource("scene.fxml"));

        
        Scene scene = new Scene(pane, largeur-50, hauteur-100);


        
        
        
        primaryStage.setTitle("scene verger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
