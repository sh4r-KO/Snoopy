package snoopy.Controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import snoopy.Model.Board;
import snoopy.View.JeuView;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    private final Board board;
    private Timer timer;
    //don't put any FXML changes in here, go to the initialize method pls

    public JeuDeBaseController() {
        board = new Board();
        jeuView = new JeuView();
        this.startTimer();
    }

    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707

    }

    //comment
    final private static double FRAMES_PER_SECOND = 1.0;//upadte()/ second
    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        jeuView.update( JeuDeBaseController.this.board);
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }





    
    

    @Override
    public void handle(KeyEvent ke) {
        //different from usual switch which ends each case with break

        switch (ke.getCode()) {

            case UP -> {
                board.moveUp();
                System.out.println("Key Pressed: " + ke.getCode());

                //ke.consume();
            }
            case DOWN -> {
                board.moveDown();
                System.out.println("Key Pressed: " + ke.getCode());

                //ke.consume();
            }
            case LEFT -> {

                board.moveLeft();
                System.out.println("Key Pressed: " + ke.getCode());

                //ke.consume();
            }
            case RIGHT -> {
                board.moveRight();
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
