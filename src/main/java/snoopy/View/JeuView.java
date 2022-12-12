package snoopy.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.w3c.dom.Text;
import snoopy.Model.Board;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class JeuView extends Group {//implements Initializable {
    public final static double CELL_WIDTH = 58.0;
    @FXML final int row =12;//TODO: use the variables defined in the fxml file
    @FXML final int column =22 ;
    private ImageView[][] matrixImagesView;


    /**
     * Constructor of JeuView, it initializes the background
     */
    public JeuView() {
        initialiseGrassBackGround();
        this.initialize();
    }
    /**
     * This method initializes the Grass on the board
     */
    public void initialiseGrassBackGround(){
        for(int i = 1; i<row-1;i++){
            for(int j = 1; j<column-1;j++){
                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image(new File("src/main/resources/img/Herbe1.png").toURI().toString()));//"+

                imageView.toBack();
                //BackGroundImageView[i][j] = imageView;
                //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                this.getChildren().add(imageView);
            }
        }
    }
    /**
     * This method initializes all the images on the matrix : time, lives, ball, wall, grass
     */
    public void initialize(){

        //this.Snoppy = new Image(new File("src/main/resources/img/Stickman_red.png").toURI().toString());
        // this.setFocusTraversable(false);

        matrixImagesView = new ImageView[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image(new File("src/main/resources/img/empty.png").toURI().toString()));//"+(int)(Math.random()*(3-1+1)+1)+

                matrixImagesView[i][j] = imageView;

                //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                this.getChildren().add(imageView);

            }
        }

        initTime();
        initLife();
        initScore();
        initBallMatrix();
        drawGreen();
        drawWall();

    }
    Label life = new Label();
    /**
     * This method initializes the images of snoopy's lives
     */
    private void initLife() {
        life.setLayoutX(200);
        life.setLayoutY(670);
        life.setAlignment(Pos.CENTER);
        life.setStyle("-fx-background-color: #00ff00; -fx-font-size: 20px; -fx-text-fill: #000000; -fx-font-weight: bold;");
        this.getChildren().add(life);
    }
    /**
     * This method prints how many lives are left on the game
     */
    private void drawLife(int lifeLeft){
        life.setText("Life : "+ lifeLeft+".");

    }
    /**
     * This method initializes the Ball on the game board
     */
    ImageView[][] matrixViewBall = new ImageView[row][column];
    private void initBallMatrix(){
        matrixViewBall = new ImageView[row][column];
        for (int i = 0; i < row; i++) {//
            for (int j = 0; j < column; j++) {

                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image(new File("src/main/resources/img/empty.png").toURI().toString()));//"+(int)(Math.random()*(3-1+1)+1)+
                imageView.toFront();
                matrixViewBall[i][j] = imageView;
                //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser
                this.getChildren().add(imageView);
            }
        }
        //print things that should only be printed once
        drawWall();
        drawGreen();
    }

    Label time = new Label();
    /**
     * This method initializes the time on the game board
     */
    private void initTime(){
        time = new Label();
        time.setText("Temps : ");
        time.setLayoutX(290);
        time.setLayoutY(680);
        time.setAlignment(Pos.CENTER);
        time.toFront();

        //timazere.setStyle("-fx-background-color: #000000;");

        this.getChildren().add(time);
    }
    Label score = new Label();

    /**
     * This method intializes the score of snoopy on the game board
     */
    private void initScore(){
        score = new Label();
        score.setAlignment(Pos.CENTER);
        score.setLayoutX(790);
        score.setLayoutY(680);
        score.toFront();
        score.setStyle("-fx-font-size: 32px;"
                + "-fx-text-fill: #000000;"
                + "-fx-font-weight: bold;");
        score.setText("Score : ");
        this.getChildren().add(score);
    }
    /**
     * This method shows how much time is left
     * @param timeleft the time left for snoopy
     */
    private void drawTime(int timeleft){
        time.setStyle("-fx-font-size: 16px;"
                + "-fx-text-fill: #000000;" +
                "-fx-font-family: \"Press Start 2P\";"
                + "-fx-font-weight: bold;");
        time.setText("Temps : "+timeleft);
    }
    /**
     * This method show the current score on the game board
     * @param score new score
     */
    private void drawScore(int score){
        this.score.setText("Score : "+score);
        this.score.setStyle("-fx-font-size: 16px;"
                + "-fx-text-fill: #000000;" +
                "-fx-font-family: \"Press Start 2P\";"
                + "-fx-font-weight: bold;");
    }
    /**
     * This method allows us to update the display of the score, time left and lives left
     * @param timeleft
     * @param score
     * @param lifeLeft
     */
    public void updateExtra(int timeleft, int score , int lifeLeft){
        drawTime(timeleft);
        drawScore(score);
        //drawLife(lifeLeft);
    }
    /**
     * This method updates the frame of the game board
     * @param p
     */
    public void updateFrame(Board p) {

        if (p == null || p.getBoard() == null || p.getBoard().length == 0|| p.getBoard()[0].length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() : p or getBoard() is null or getBoard() empty");
        }if (p.getBoard().length != row || p.getBoard()[0].length != column) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() size is not the same as the view size");
        }
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < column - 1; j++) {
                String T = p.getBoard()[i][j];//.strip();

                if (T == null || matrixImagesView[i][j] == null || matrixImagesView[i][j].getImage() == null || matrixViewBall[i][j] == null || matrixViewBall[i][j].getImage() == null) {
                    throw new NullPointerException("Something's fishy! View.JeuView.updateFrame.366 : null pointer exception");
                }

                if(T.contains("7")) {
                    if (T.contains("7SE") || T.contains("7SO") || T.contains("7NE") || T.contains("7NO")) {
                        matrixViewBall[i][j].setImage(new Image(new File("src/main/resources/img/Balle.png").toURI().toString()));
                    }
                }else {//empty
                    matrixViewBall[i][j].setImage(new Image(new File("src/main/resources/img/empty.png").toURI().toString()));
                }

                if (T.equals("0")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Herbe1.png").toURI().toString()));//"+(int)(Math.random()*(3-1+1)+1)+
                } else if (T.equals("1")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocCassable.png").toURI().toString()));
                } else if (T.equals("2E")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPoussableDroite.png").toURI().toString()));
                } else if (T.equals("2O")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPoussableGauche.png").toURI().toString()));
                } else if (T.equals("2N")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPoussableHaut.png").toURI().toString()));
                } else if (T.equals("2S")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPoussableBas.png").toURI().toString()));
                } else if (T.contains("3")) {

                    if(T.equals("3")){
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiege.png").toURI().toString()));
                    }else if(T.equals("38N")){
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiegeSnoopyHaut.png").toURI().toString()));
                    }else if(T.equals("38S")){
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiegeSnoopyBas.png").toURI().toString()));
                    }else if(T.equals("38E")){
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiegeSnoopyDroite.png").toURI().toString()));
                    }else if(T.equals("38O")){
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiegeSnoopyGauche.png").toURI().toString()));
                    }

                    //matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiege.png").toURI().toString()));
                } else if (T.equals("4")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocInvincible.png").toURI().toString()));
                } else if (T.equals("5")) {
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocApparitionDisparition.png").toURI().toString()));
                } else if (T.contains("6")) {
                    if (T.equals("6N")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocTapisRoulantHaut.png").toURI().toString()));
                    } else if (T.equals("6S")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocTapisRoulantBas.png").toURI().toString()));
                    } else if (T.equals("6E")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocTapisRoulantDroite.png").toURI().toString()));
                    } else if (T.equals("6W")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocTapisRoulantGauche.png").toURI().toString()));
                    }
                } else if (T.contains("8")) {
                    if (T.contains("8N")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyHaut.png").toURI().toString()));
                    } else if (T.contains("8S")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyBas.png").toURI().toString()));
                    } else if (T.contains("8E")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyDroite.png").toURI().toString()));
                    } else if (T.contains("8O")) {
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyGauche.png").toURI().toString()));
                    }

                } else if(T.equals("9E")){
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/OiseauDroite.png").toURI().toString()));
                }else if(T.equals("9O")){
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/OiseauGauche.png").toURI().toString()));
                }


            }
        }
    }

    /**
     * This method draws the green background on the game board
     */
    private void drawGreen(){//matrixless?
        for (int i = 2; i < row-2; i++) {
            for (int j = 2; j < column-2; j++) {
                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);
                imageView.setImage( new Image(new File("src/main/resources/img/Herbe1.png").toURI().toString()));
            }
        }
    }
    /**
     * This method draws the wall on the display of teh game
     */
    public void drawWall(){

        //corner
        doThis(0, 0, "MurHautGauche.png");
        doThis(row-1, column-1, "MurBasDroite.png");
        doThis(row-1, 0, "MurBasGauche.png");
        doThis(0, column-1, "MurHautDroite.png");

        //walls
        //left wall
        for (int i = 1; i < row-1; i++) {
            doThis(i, 0, "MurGauche.png");
        }
        //right wall
        for (int i = 1; i < row-1; i++) {
            doThis(i, column-1, "MurDroite.png");
        }
        //top wall
        for (int i = 1; i < column-1; i++) {
            doThis(0, i, "MurHaut.png");
        }
        //bottom wall
        for (int i = 1; i < column-1; i++) {
            doThis(row-1, i, "MurBas.png");
        }
    }
    /**
     * This method sets images on a particular positions in the board
     * @param i x Position on the up to down axis
     * @param j y Position on the left to right axis
     * @param FileName The name of the image file
     */
    private void doThis(int i, int j, String FileName){
        matrixImagesView[i][j].setImage( new Image(new File("src/main/resources/img/"+FileName).toURI().toString()));
    }
}