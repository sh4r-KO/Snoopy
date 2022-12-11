package snoopy.Controller;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import snoopy.Model.*;
import snoopy.View.JeuView;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML public Label vieLabel;
    @FXML JeuView jeuView;
    private Ball b;
    static Board board;//static.............cant be changed

    public JeuDeBaseController() {
        board = new Board();
        jeuView = new JeuView();
    }


    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
        this.chronoLabel.setText("#### : "+board.getChrono());

    }

    public void Startgame(){
        this.startTimer();
    }
    String ret = "";
    int t = 60000;
    @FXML public Label chronoLabel;
    static Timeline timeline = null;
    String TIME = "###"+t;
    //https://stackoverflow.com/questions/54963023/java-how-to-cancel-the-timer-immediately-when-some-condition-is-met
    //https://stackoverflow.com/questions/9966136/javafx-periodic-background-task
    public void setTime(int t){

        ret= t/1000+" : "+t%1000;
    }
    private void startTimer() {

        timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->{
                    if(t%400==0){
                        board.moveBall();
                    }
                    if(t<0){
                        t=0;
                        board.setChrono(0);
                    }else if(t%1000==0){
                        board.setChrono(t/1000);
                    }
                    jeuView.updateFrame(board, t);
                    t=t-100;
                }));


        timeline.setCycleCount(Animation.INDEFINITE); // loop forever
        timeline.play();

        /*

        PauseTransition pause = new PauseTransition(Duration.millis(100));
        pause.setOnFinished(
                e -> {
                    jeuView.updateFrame(board);
                    board.moveBall();
                    pause.playFromStart(); // loop again
                });
        pause.play();
        */

//https://stackoverflow.com/questions/41779093/timer-in-java-fx

    }


    @Override
    public void handle(KeyEvent ke) {
        System.out.println(board.toString());
        //different from usual switch which ends each case with break
        switch (ke.getCode()) {

            case UP -> {
                if(timeline.getStatus()== Animation.Status.RUNNING) {
                    board.moveUp();
                }
                ke.consume();
            }
            case DOWN -> {
                if(timeline.getStatus()== Animation.Status.RUNNING) {
                    board.moveDown();
                }
                ke.consume();
            }
            case LEFT -> {
                if(timeline.getStatus()== Animation.Status.RUNNING) {
                    board.moveLeft();
                }
                ke.consume();
            }
            case RIGHT -> {
                if(timeline.getStatus()== Animation.Status.RUNNING) {
                    board.moveRight();
                }
                ke.consume();
            }
            case S -> {
                if(timeline.getStatus()== Animation.Status.RUNNING){
                    timeline.pause();
                }else{
                    timeline.play();
                }
                //ke.consume();
            }
            case SPACE ->{
                if(timeline.getStatus()== Animation.Status.RUNNING) {
                    board.spacePressed();
                }
                //jeuView.updateFrame(board);
            }
        }
    }

}
