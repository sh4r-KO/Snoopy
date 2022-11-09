package com.example.snoopy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuPaneController {
    @FXML private AnchorPane menuPaneAnchor;
    @FXML private javafx.scene.control.Button quitterB;
    @FXML private javafx.scene.control.Button JeuDeBaseB;
    @FXML private javafx.scene.control.Button scoresB;
    @FXML private javafx.scene.control.Button mdpB;
    @FXML private javafx.scene.control.Button chargerUnePartieB;
    @FXML private javafx.scene.control.Button jeuAvanceB;

    public void JeuDeBaseCliked(){

    }
    public void chargerUnePartieCliked() throws IOException {
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChargerUnePartie.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }
    public void JeuAvanceCliked(){

    }
    public void quitterCliked(){
        System.out.println("FirstPaneController.quitterCliked()");
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();
        stage.close();
    }
    public void mdpCliked() throws IOException {
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MotDePasse.fxml"));
        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }
    public void scoresCliked() throws IOException {

        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Scores.fxml"));
        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

}
