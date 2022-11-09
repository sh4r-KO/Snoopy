package com.example.snoopy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChargerUnePartieController {

    @FXML public AnchorPane chargerUnePartieAnchor;
    @FXML public Button retourB;
    @FXML public Button validerB;
   @FXML public TextArea chargerUnePartieTextArea;

    public void retourClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) chargerUnePartieAnchor.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuPane.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

    public void validerClicekd() {
        String s = chargerUnePartieTextArea.getText();
        System.out.println(s);
    }
}
