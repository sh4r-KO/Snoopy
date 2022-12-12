package snoopy.Controller;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import snoopy.Model.*;
import snoopy.View.JeuView;

import java.io.IOException;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML
    public BorderPane JeuBorderPane;
    @FXML
    JeuView jeuView;
    @FXML
    public Label scoreLabel;
    @FXML
    public ImageView vie1;
    @FXML
    public ImageView vie2;
    @FXML
    public ImageView vie3;
    @FXML
    public Label timerLabel;
    @FXML
    static Board board;//static.............cant be changed

    /**
     * JeuDeBaseController constructor
     */
    public JeuDeBaseController() {
        board = new Board();
        jeuView = new JeuView();
    }

    /**
     * This method allows us to change the value of time according to the board
     */
    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
        this.timerLabel.setText("#### : " + board.getChrono());
    }

    static Timeline timeline = null;
    //https://stackoverflow.com/questions/54963023/java-how-to-cancel-the-timer-immediately-when-some-condition-is-met
    //https://stackoverflow.com/questions/9966136/javafx-periodic-background-task

    /**
     * This method allows us to launch the first level of the game
     */
    public void startGame() {
        board.startGame();
        startTimer();
    }

    public void startLoadedGame() {
        board.LoadGame();
        startTimer();
    }


    int t = 60;

    /**
     * This method is used to launch the periodic events, update and move the ball
     */
    private void startTimer() {

        if (board == null || board.getBoard() == null || board.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.startTimer() : board or getBoard() is null or getBoard() empty");
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (t % 2 == 0) {
                board.moveBall();
            }
            board.setChrono(t);
            System.out.println("t = " + t);
            jeuView.updateFrame(board);
            setLife(board.getSnoopy().getLife());
            setScoreLabel(board.getScore());
            jeuView.updateExtra(t, board.getScore(), board.getSnoopy().getLife());
            t -= 1;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //https://stackoverflow.com/questions/41779093/timer-in-java-fx
    }

    /**
     * This setter allows us to set the field scoreLabel
     *
     * @param score
     */
    public void setScoreLabel(int score) {
        this.scoreLabel.setText("Score : " + score);
    }

    /**
     * This method allows us to set the field life
     *
     * @param life
     */
    public void setLife(int life) {
        if (life == 2) {
            this.vie3.setVisible(false);
        }
        if (life == 1) {
            this.vie2.setVisible(false);
        }
        if (life == 0) {
            this.vie1.setVisible(false);
        }
    }

    public void restartGame() {
        //board = new Board();
        //jeuView = new JeuView();
        t = 60;
        if(timeline != null) {
            timeline.stop();
        }
        board.startGame();
        startTimer();
    }

    public void quitGame() {
        Stage stage = (Stage) JeuBorderPane.getScene().getWindow();
        stage.close();
    }

    /**
     * This method allows us to translate Key Events into movements, and "S" to save
     *
     * @param ke Keyboard entry
     */
    @Override
    public void handle(KeyEvent ke) {
        if (board == null || board.getBoard() == null || board.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.handle() : board or getBoard() is null or getBoard() empty");
        }
        System.out.println(board.toString());
        //different from usual switch which ends each case with break
        switch (ke.getCode()) {

            case UP -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    board.moveUp();

                }
                ke.consume();
            }
            case DOWN -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    board.moveDown();
                }
                ke.consume();
            }
            case LEFT -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    board.moveLeft();
                }
                ke.consume();
            }
            case RIGHT -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    board.moveRight();
                    jeuView.updateFrame(board);
                }
                ke.consume();
            }
            case S -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    timeline.pause();
                } else {
                    timeline.play();
                }


                ke.consume();
            }
            case SPACE -> {
                if (timeline.getStatus() == Animation.Status.RUNNING) {
                    board.spacePressed();
                }
                //jeuView.updateFrame(board);
            }
            case Q -> {
                try {
                    board.setTxtFromBoard(board.getBoard(), "Save.txt", "src/main/resources/levels/");
                    timeline.stop();
                    returnMenu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void returnMenu() {
        try {
            //explications pk y'a "snoopy/" : (20h)
            //https://stackoverflow.com/a/40065607

            //Stage stage = (Stage) JeuBorderPane.getScene().getWindow();
            //Stage stage =(Stage) javafx.stage.Window.getWindows();
            Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
            Stage stage = (Stage) owner;
            System.out.println("stage = " + stage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ViewFmxl/MenuPane.fxml"));

            AnchorPane borderPane = null;
            try {
                borderPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}