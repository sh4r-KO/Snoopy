package snoopy.Controller;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import snoopy.Model.*;
import snoopy.View.JeuView;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML public BorderPane JeuBorderPane;
    @FXML JeuView jeuView;
    @FXML public Label scoreLabel;
    @FXML public ImageView vie1;
    @FXML public ImageView vie2;
    @FXML public ImageView vie3;
    @FXML public Label timerLabel;
    @FXML
    static Board board;//static.............cant be changed

    public JeuDeBaseController() {
        board = new Board();
        jeuView = new JeuView();
    }

    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
        this.timerLabel.setText("#### : "+board.getChrono());
    }

    static Timeline timeline = null;
    //https://stackoverflow.com/questions/54963023/java-how-to-cancel-the-timer-immediately-when-some-condition-is-met
    //https://stackoverflow.com/questions/9966136/javafx-periodic-background-task

    public void startGame(){
        startTimer();
    }


    int t = 60;
    private void startTimer() {

        if (board == null || board.getBoard() == null || board.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.startTimer() : board or getBoard() is null or getBoard() empty");
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e ->{
            if(t%2==0){
                board.moveBall();
            }
            board.setChrono(t);
            System.out.println("t = " + t);
            jeuView.updateFrame(board);
            setLife(board.getSnoopy().getLife());
            setScoreLabel(board.getScore());
            jeuView.updateExtra(t, board.getScore(), board.getSnoopy().getLife());
            t-=1;
        }));
            timeline.setCycleCount(60);
            timeline.play();

         /*
         PauseTransition pause = new PauseTransition(Duration.millis(100));
         pause.setOnFinished( e -> {
                     if(t%400==0){
                board.moveBall();
            }
            if(t<0){
                t=0;
                board.setChrono(0);
            }else if(t%1000==0){
                board.setChrono(t/1000);
                jeuView.updateFrame(board, t);

            }

            t=t-100;
                 });
         pause.play();
         */

        //https://stackoverflow.com/questions/41779093/timer-in-java-fx

    }

    public void setScoreLabel(int score) {
        this.scoreLabel.setText("Score : " + score);
    }

    public void setLife(int life){
        if(life == 2){
            this.vie3.setVisible(false);
        }
        if(life == 1){
            this.vie2.setVisible(false);
        }
        if(life == 0){
            this.vie1.setVisible(false);
        }
    }

    public void restartGame(){
        board = new Board();
        jeuView = new JeuView();
        t = 60;
        timeline.stop();
        startTimer();
    }

    public void quitGame(){
        Stage stage = (Stage) JeuBorderPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void handle(KeyEvent ke) {
        if (board == null || board.getBoard() == null || board.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.handle() : board or getBoard() is null or getBoard() empty");
        }
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
                    jeuView.updateFrame(board);
                }
                ke.consume();
            }
            case S -> {
                if(timeline.getStatus()== Animation.Status.RUNNING){
                    timeline.pause();
                }else{
                    timeline.play();
                }


                ke.consume();
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