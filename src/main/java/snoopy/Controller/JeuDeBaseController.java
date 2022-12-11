package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import snoopy.Model.*;
import snoopy.View.JeuView;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    private Ball b;
    static Board board;//static.............
    private Timer timer;
    private Snoopy snoopy;
    private ShowFadeBlock fadeBlock;
    private  BreakingBlock breakingBlock;

    public JeuDeBaseController() {
        board = new Board();
        //snoopy = board.getSnoopy();//il faut absolument que ce soit la meme board que l'attribut board actuel
        jeuView = new JeuView();
        //this.b = board.getBall();

        //this.fadeBlock = new ShowFadeBlock(board, snoopy);


        //Snoopy s = new Snoopy(board);
        //jeuView.update(board);
    }


    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707

    }
    public void Startgame(){
        this.startTimer();

    }
    int t = 60;
    private final int DELAY = 50;//1000 = 1s because there is delay before and after, we double it so 1s = 10* 2 * 50ms
    private int facteurDedelay = 0;

    @FXML Label chronoLabel;
    String TIME = new String("#################");
    //https://stackoverflow.com/questions/54963023/java-how-to-cancel-the-timer-immediately-when-some-condition-is-met
    private void startTimer() {
        this.timer = new java.util.Timer();

        TimerTask timerTask = new TimerTask() {
            public void run() {
                facteurDedelay++;

                jeuView.updateFrame(board);
                board.moveBall();
            }
        };
        timer.schedule(timerTask,0, DELAY);

        chronoLabel.setText(TIME);


        /////////////////////////////
        Timer timer2 = new java.util.Timer();
        TimerTask timerTask2 = new TimerTask() {
            public void run() {
                TIME =("###"+t);
                System.out.println(TIME);

                t--;
                /*if(t<=0){
                    timer2.cancel();
                    board.timerPassed();
                }

                 */
            }
        };
        chronoLabel.setText(TIME);

        timer2.schedule(timerTask2,1000L, 1000L);
    }

    @Override
    public void handle(KeyEvent ke) {
        System.out.println(board.toString());
        //different from usual switch which ends each case with break
        switch (ke.getCode()) {

            case UP -> {
                //jeuView.update(board);

                board.moveUp();
                jeuView.updateFrame(board);

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
                board.spacePressed();
                //jeuView.updateFrame(board);
            }
        }
    }
}
