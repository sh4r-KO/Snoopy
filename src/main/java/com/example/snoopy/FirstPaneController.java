package com.example.snoopy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPaneController {

    @FXML private javafx.scene.control.Button jouerB;
    @FXML private AnchorPane firstPaneAnchor;

    public void JouerCliked() throws IOException {
        System.out.println("FirstPaneController.JouerCliked()");
        Stage stage = (Stage) firstPaneAnchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuPane.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

}
