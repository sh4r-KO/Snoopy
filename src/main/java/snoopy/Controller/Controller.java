package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import snoopy.Model.Player;

import java.io.IOException;

public class Controller{


    //constructeur
    public Controller(){


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
