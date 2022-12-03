package snoopy;


import snoopy.Controller.JeuDeBaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import snoopy.Model.Board;

import java.io.IOException;

public class Main extends Application {
    //******************************************************************************************************************
    //---------------------------------A NE PAS SUPPRIMER MEME SI IL Y A DES DOUBLONS OK ????------------------------------
    //******************************************************************************************************************
    /*
    TODO: reduce visibilty of all elements in contorllers like public button -> private
    TODO: make all element in fxml responsive/relative to the size
    TODO: all modelView musst extends ImageView
    TODO: reduce title of the menu
    TODO : in case of not enough number in int[][] use hexa to represent the number ABCDEF = 10 11 12 13 14 15
    */
    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************

    public static final int Stage_width = 1440;//75% of 1920
    public static final int Stage_height = 810;//75% of 1080 //coucou

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ViewFmxl/FirstPane.fxml"));

        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);

        stage.addEventFilter(KeyEvent.KEY_PRESSED, new JeuDeBaseController());//can change stage to something else, reduce the scope of the controlller, preferable to use ke.consume() in the controller
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Snoopy");

        stage.show();
        //Board player = new Board();
    }
    public static void main(String[] args) {
        launch(args);
    }

}