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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller  implements Initializable {


    @FXML private javafx.scene.control.Button jouerB;
    @FXML private AnchorPane firstPaneAnchor;

    @FXML public AnchorPane scoresAnchorPane;
    @FXML public ListView<String> listviewScores;
    @FXML JeuDeBaseController jeuDeBaseController;

    private ArrayList<String> scoresList ;
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
        if(s.equals("MotDePasse.5")){

        }
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
        String file = null;
        try {
            file = Files.readString(new File("src/main/resources/Scores.txt").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] chararray = file.toCharArray();
        scoresList = new ArrayList<String>();
        String r = "";
        for (int i = 0; i < chararray.length; i++) {
            if(chararray[i] == '\n'){
                scoresList.add(r);
                r = "";
            }else{
                r = r + ""+chararray[i];
            }
        }

        if(listviewScores != null){
            listviewScores.getItems().addAll(scoresList);
        }
    }
}