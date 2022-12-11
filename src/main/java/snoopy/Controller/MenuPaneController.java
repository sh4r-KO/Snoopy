package snoopy.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPaneController extends Controller{
    @FXML private AnchorPane menuPaneAnchor;

    /**
     * This method tells us that the button "Jeu de base" has been clicked
     * @throws IOException
     */
    public void JeuDeBaseCliked() throws IOException {
        //super.changePane("JeuDeBase.fxml", menuPaneAnchor);
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ViewFmxl/JeuDeBase.fxml"));
            BorderPane borderPane = null;
        try{
             borderPane = loader.load();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        JeuDeBaseController controller = loader.getController();
        controller.startGame();
    }

    /**
     * This method tells us that the button "Charger une partie" has been clicked
     * @throws IOException
     */
    public void chargerUnePartieCliked() throws IOException {
        super.changePane("ChargerUnePartie.fxml", menuPaneAnchor);
    }

    /**
     * This method tells us that the button "Jeu avancé" has been clicked
     */
    public void JeuAvanceCliked(){

    }

    /**
     * This method tells us that the button "Quitter" has been clicked
     */
    public void quitterCliked(){
        System.out.println("FirstPaneController.quitterCliked()");
        Stage stage = (Stage) menuPaneAnchor.getScene().getWindow();
        stage.close();
    }

    /**
     * This method tells us that the button "Jeu de base" has been clicked
     * @throws IOException
     */
    public void mdpCliked() throws IOException {
        super.changePane("MotDePasse.fxml", menuPaneAnchor);
    }

    /**
     * This method tells us that the button "Scores" has been clicked
     * @throws IOException
     */
    public void scoresCliked() throws IOException {
        super.changePane("Scores.fxml", menuPaneAnchor);
    }

}
