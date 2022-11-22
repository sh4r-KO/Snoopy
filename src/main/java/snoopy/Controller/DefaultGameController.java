package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import snoopy.Model.Model;
import snoopy.View.GameView;

import java.util.Timer;

public class DefaultGameController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML
    GameView jeuView;
    private final Model model;
    private Timer timer;
    //don't put any FXML changes in here, go to the initialize method pls

    public DefaultGameController() {
        this.model = new Model();
    }


    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
    }

    
    

    @Override
    public void handle(KeyEvent ke) {
        //different from usual switch which ends each case with break

        switch (ke.getCode()) {

            case UP -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
            case DOWN -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
            case LEFT -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
            case RIGHT -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
            case S -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
        }


    }


}
