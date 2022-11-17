package snoopy.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPaneController extends  Controller{
    @FXML private AnchorPane menuPaneAnchor;

    public void JeuDeBaseCliked() throws IOException {

        super.changePane("JeuDeBase.fxml", menuPaneAnchor);
    }
    public void chargerUnePartieCliked() throws IOException {
        super.changePane("ChargerUnePartie.fxml", menuPaneAnchor);
    }
    public void JeuAvanceCliked(){

    }

    public void quitterCliked(){
        System.out.println("FirstPaneController.quitterCliked()");
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();
        stage.close();
    }
    public void mdpCliked() throws IOException {
        super.changePane("MotDePasse.fxml", menuPaneAnchor);
    }
    public void scoresCliked() throws IOException {
        super.changePane("Scores.fxml", menuPaneAnchor);
    }

}
