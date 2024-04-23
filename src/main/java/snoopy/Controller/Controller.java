package snoopy.Controller;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {


    @FXML private javafx.scene.control.Button jouerB;
    @FXML private AnchorPane firstPaneAnchor;

    @FXML public AnchorPane scoresAnchorPane;
    @FXML public ListView<String> listviewScores;
    @FXML public Label LabelScore;
    @FXML public Button retourBChargerPartie;
    @FXML public Button validerBChargerPartie;

    private final String[] scoresList = {"test1 : 123456","test2 : rAAAAAAh il est deja 3h du mat","test3 : dfghnbv","4","5","6","7","8","9","10","11","12","13","14", "test3 : dfghnbv","4","5","6","7","8","9","10","11","12","13","14", "test3 : dfghnbv","4","5","6","7","8","9","10","11","12","13","14", "test3 : dfghnbv","4","5","6","7","8","9","10","11","12","13","14"};//a importer plus tard du txt

    @FXML public Button validerBmdp;
    @FXML public Button retourBmdp;
    @FXML public TextArea motdepasseTextArea;
    @FXML public AnchorPane motdepasseAnchor;

    @FXML public AnchorPane chargerUnePartieAnchor;
    @FXML public Button retourB;
    @FXML public Button validerB;
    @FXML public TextArea chargerUnePartieTextArea;

    /**
     * Constructor
     */
    public Controller(){}

    /**
     * This method tells us that the button "Charger une partie" has been clicked
     * @param actionEvent
     * @throws IOException
     */
    public void retourClickedChargerPartie(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml", chargerUnePartieAnchor);
    }

    /**
     * This method tells us that the button "Valider" in "Charger une Partie" has been clicked
     * @param actionEvent
     */
    public void validerClickedChargerPartie(ActionEvent actionEvent) {
        String s = chargerUnePartieTextArea.getText();
        System.out.println(s);
    }

    /**
     * This method tell us that the button "Mot de passe" has been clicked
     * @param actionEvent
     * @throws IOException
     */
    public void retourClickedmdp(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml", motdepasseAnchor);
    }

    /**
     * This method tells us that the button "Valider" in "Mot de passe" has been clicked
     * @param actionEvent
     */
    public void validerClickedmdp(ActionEvent actionEvent) {
        String s = motdepasseTextArea.getText();
        if(s.equals("MotDePasse.5")){

        }
        System.out.println(s);
    }

    /**
     * This method is used when we click on the button "Jouer"
     * @throws IOException
     */
    public void JouerCliked() throws IOException {
        changePane("MenuPane.fxml", firstPaneAnchor);
    }

    /**
     * This method is used when we click on the button "Retour"
     * @param actionEvent
     * @throws IOException
     */
    public void retourClicked(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml",scoresAnchorPane);
    }

    /**
     * This method allows us to go from a pane to another one using a loader
     * A loader allows fxml files to be used in java
     * @param fxmlFileName
     * @param callingAnchor
     * @throws IOException
     */
    public void changePane(String fxmlFileName, AnchorPane callingAnchor) throws IOException {
        //explications pk y'a "snoopy/" : (20h)
        //https://stackoverflow.com/a/40065607

        Stage stage = (Stage) callingAnchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ViewFmxl/"+fxmlFileName));

        AnchorPane anchorPane = null;
        try {
             anchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

    /**
     * This method allows us to load scores from a text file when the fxml file is intialized in the code
     * @param url
     * @param resourceBundle
     */
    //source : https://youtu.be/Pqfd4hoi5cc
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add score to the list only when the window is opened (not when the button is clicked)
        if(listviewScores != null){
            listviewScores.getItems().addAll(scoresList);
        }
    }



}