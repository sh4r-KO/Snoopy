package snoopy.Controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    public GridPane GridPaneJB;
    public ImageView ImageViewJB;
    public AnchorPane jeuDeBaseAnchor;

    //constructeur
    public Controller(){


    }
    public void initialize(){
    }

    public void changePane(String fxmlFileName, AnchorPane callingAnchor) throws IOException {


        //explications pk y'a "snoopy/" : (20h)
        //https://stackoverflow.com/a/40065607

        Stage stage = (Stage) callingAnchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/snoopy/"+fxmlFileName));
        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

}