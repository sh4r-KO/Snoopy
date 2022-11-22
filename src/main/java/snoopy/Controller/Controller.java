package snoopy.Controller;


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

    //constructeur
    public Controller(){}

    public void retourClickedChargerPartie(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml", chargerUnePartieAnchor);
    }
    public void validerClickedChargerPartie(ActionEvent actionEvent) {
        String s = chargerUnePartieTextArea.getText();
        System.out.println(s);
    }
    public void retourClickedmdp(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml", motdepasseAnchor);
    }
    public void validerClickedmdp(ActionEvent actionEvent) {
        String s = motdepasseTextArea.getText();
        System.out.println(s);
    }
    public void JouerCliked() throws IOException {
        changePane("MenuPane.fxml", firstPaneAnchor);
    }
    public void retourClicked(ActionEvent actionEvent) throws IOException {
        changePane("MenuPane.fxml",scoresAnchorPane);
    }
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

    //source : https://youtu.be/Pqfd4hoi5cc
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add score to the list only when the window is opened (not when the button is clicked)
        if(listviewScores != null){
            listviewScores.getItems().addAll(scoresList);
        }



    }


}