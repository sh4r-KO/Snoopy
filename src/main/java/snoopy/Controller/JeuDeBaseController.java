package snoopy.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import snoopy.Model.Player;
import snoopy.View.JeuView;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {
    final private static double FRAMES_PER_SECOND = 15.0;

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    private final Player player;
    private Timer timer;
    //don't put any FXML changes in here, go to the initialize method pls

    public JeuDeBaseController() {
        player = new Player();
        this.startTimer();
    }

    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        JeuView.update();
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }



    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
    }

    
    

    @Override
    public void handle(KeyEvent ke) {
        //differnet from usual switch which ends each case with break

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
