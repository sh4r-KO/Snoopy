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
import java.net.URL;

public class MotdepasseController {
    @FXML public Button validerB;
    @FXML public Button retourB;
    @FXML public TextArea motdepasseTextArea;
    @FXML public AnchorPane motdepasseAnchor;

    public void retourClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) motdepasseAnchor.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuPane.fxml"));

        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }

    public void validerClicekd(ActionEvent actionEvent) {
        String s = motdepasseTextArea.getText();
        System.out.println(s);
    }
}
