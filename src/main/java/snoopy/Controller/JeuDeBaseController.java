package snoopy.Controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import snoopy.Model.Board;
import snoopy.Model.Snoopy;
import snoopy.View.JeuView;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    private static Board board;
    private Timer timer;
    private Snoopy snoopy;

    public JeuDeBaseController() {
        board = new Board();
        snoopy = new Snoopy(board);//il faut absolument que ce soit la meme board que l'attribut board actuel
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
                jeuView.update(board);
            }
        };
        this.timer.schedule(timerTask, 75, 75);
    }





    
    

    @Override
    public void handle(KeyEvent ke) {
        //different from usual switch which ends each case with break

        switch (ke.getCode()) {

            case UP -> {
                snoopy.moveUp();
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case DOWN -> {
                snoopy.moveDown();
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case LEFT -> {

                snoopy.moveLeft();
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case RIGHT -> {
                snoopy.moveRight();
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case S -> {
                System.out.println("Key Pressed: " + ke.getCode());
                //ke.consume();
            }
        }


    }


}
