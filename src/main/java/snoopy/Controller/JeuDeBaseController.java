package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import snoopy.Model.Ball;
import snoopy.Model.Board;
import snoopy.Model.ShowFadeBlock;
import snoopy.Model.Snoopy;
import snoopy.View.JeuView;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    private Ball b;
    private static Board board;//static.............
    private Timer timer;
    private Snoopy snoopy;
    private ShowFadeBlock fadeBlock;

    public JeuDeBaseController() {
        board = new Board();
        snoopy = board.getNoop();//il faut absolument que ce soit la meme board que l'attribut board actuel
        jeuView = new JeuView();
        this.b = new Ball(board);
        //this.fadeBlock = new ShowFadeBlock(board, snoopy);


        //Snoopy s = new Snoopy(board);
        //jeuView.update(board);
        this.startTimer();
    }


    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707

    }
    private final int DELAY = 100;//TODO doit absolument etre 100
    private int facteurDe200ms = 5;
    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {

                jeuView.update(board, facteurDe200ms%5);
                b.movement();
                //fadeBlock.fade();
                facteurDe200ms+=1;

            }
        };
        this.timer.schedule(timerTask, DELAY, DELAY);
    }

    @Override
    public void handle(KeyEvent ke) {
        //different from usual switch which ends each case with break
        switch (ke.getCode()) {

            case UP -> {
                //jeuView.update(board);

                board.moveUp();
                //fadeBlock.fade();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case DOWN -> {
                board.moveDown();
                //jeuView.update(board);
                //fadeBlock.fade();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case LEFT -> {

                board.moveLeft();
                //fadeBlock.fade();
                //jeuView.update(board);
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Key Pressed: " + ke.getCode());

                ke.consume();
            }
            case RIGHT -> {
                board.moveRight();
                //fadeBlock.fade();
                //jeuView.update(board);
                try {
                    Thread.sleep(DELAY);
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
            case SPACE ->{
                System.out.println("Key Pressed: " + ke.getCode());
            }
        }
    }
}
