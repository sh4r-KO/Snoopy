package com.example.snoopy;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    //******************************************************************************************************************
    //---------------------------------A NE PAS SUPPRIMIER MEME SI YA EDS DOUBLONS OK ????------------------------------
    //******************************************************************************************************************
    /*
    TODO: reduce visibilty of all elements in contorllers like public button -> private
    TODO: make a super controller and add redundances method such as ReturnCliecked (if difference faced, re-write or add parameters)
    TODO: make all element in fxml responsive/relative to the size
    TODO: super cntroler avec la methode dec hangement de fichier fxml

    */
    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************

    public static final int Stage_width = 1240; //1440;//75% of 1920
    public static final int Stage_height = 710; //810;//75% of 1080

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FirstPane.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}