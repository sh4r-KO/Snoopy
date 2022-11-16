package snoopy.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MotdepasseController extends Controller {
    @FXML public Button validerB;
    @FXML public Button retourB;
    @FXML public TextArea motdepasseTextArea;
    @FXML public AnchorPane motdepasseAnchor;

    public void retourClicked(ActionEvent actionEvent) throws IOException {
       super.changePane("MenuPane.fxml", motdepasseAnchor);
    }

    public void validerClicekd(ActionEvent actionEvent) {
        String s = motdepasseTextArea.getText();
        System.out.println(s);
    }
}
