package snoopy.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPaneController extends  Controller{

    @FXML private javafx.scene.control.Button jouerB;
    @FXML private AnchorPane firstPaneAnchor;

    public void JouerCliked() throws IOException {
        super.changePane("MenuPane.fxml", firstPaneAnchor);
    }

}
