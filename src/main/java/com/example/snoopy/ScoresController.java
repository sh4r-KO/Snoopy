package com.example.snoopy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoresController implements Initializable {

    @FXML public AnchorPane scoresAnchorPane;
    @FXML public ListView<String> listviewScores;
    @FXML public Label LabelScore;
    @FXML public Button retourB;

    private String[] scoresList = {"test1 : 123456","test2 : rAAAAAAh il est deja 3h du mat","test3 : magrosse","4","5","6","7","8","9","10","11","12","13","14"};//a importer plus tard du txt
    public ScoresController(){

    }
    public void retourClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) scoresAnchorPane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuPane.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }
    //source : https://youtu.be/Pqfd4hoi5cc
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listviewScores.getItems().addAll(this.scoresList);
    }
}

