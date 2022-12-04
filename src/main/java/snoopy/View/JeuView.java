package snoopy.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import snoopy.Model.Board;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this class is a view of the game, it's the game itself
 * it's a group element, so it can be added to a parent in this case JeuDeBase.fxml
 */
public class JeuView extends Group {//implements Initializable {
    public final static double CELL_WIDTH = 58.0;
    @FXML final int row =12;//TODO: use the variables defined in the fxml file
    @FXML final int column =22 ;
    private ImageView[][] matrixImagesView;
    private int time = 60;


    //set all images path to images object in constructor
    public JeuView() {
        this.initialize();
    }



    Image Snoppy;
    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.Snoppy = new Image(new File("src/main/resources/img/Stickman_red.png").toURI().toString());
        matrixImagesView = new ImageView[row][column];
        for (int i = 0; i < row; i++) {//
            for (int j = 0; j < column; j++) {

                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);

                matrixImagesView[i][j] = imageView;
                this.getChildren().add(imageView);

            }
        }
        System.out.println("initialize() done");
    }
    */
    public void initialize(){
        this.Snoppy = new Image(new File("src/main/resources/img/Stickman_red.png").toURI().toString());
        this.setFocusTraversable(false);

        matrixImagesView = new ImageView[row][column];
        for (int i = 0; i < row; i++) {//
            for (int j = 0; j < column; j++) {

                ImageView imageView = new ImageView();
                //imageView = style(imageView);
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);

                matrixImagesView[i][j] = imageView;

                this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                this.getChildren().add(imageView);

            }
        }
        System.out.println("initialize() done");
        //print things that should only be printed once
        drawWall();
        drawGreen();

    }
    /*
    0 is empty bloc (aka grass : Herbe1.png/Herbe2.png/Herbe3.png)
    1 is breakable bloc ( BlocCassable.png)
    2 is pushable bloc
    3 is trap bloc
    4 is invincible bloc
    5 is an appear/disappear bloc
    6 is treadmill bloc
    7 is ball
    8 is snoopy
    9 is a bird
    the choice pattern is described here :
    if nothing is specified, the upadte method will simply draw the png accordingly to the board
    concerning empty bloc, it will be a random grass png chosen beetween the 3 avaiblable
     */

    public void update(Board p) {
        if (p == null || p.getBoard() == null || p.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() : p or getBoard() is null or getBoard() empty");
        }if (p.getBoard().length != row || p.getBoard()[0].length != column) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() size is not the same as the view size");
        }
/*
case 0 -> doThis(i,j,"Herbe2.png");//matrixImagesView[i][j].setImage( new Image(new File("src/main/resources/img/Herbe"+(int)Math.floor(Math.random()*(3)+1)+".png").toURI().toString()));
                    case 1 -> doThis(i,j,"BlocCassable.png");
                    case 2 -> doThis(i,j,"BlocPoussable.png");
                    case 3 -> doThis(i,j,"BlocPiege.png");
                    case 4 -> doThis(i,j,"BlocInvincible.png");
                    case 5 -> doThis(i,j,"BlocApparitionDisparition.png");
                    case 6 -> doThis(i,j,"BlocTapisRoulantBas.png");
                    case 7 -> doThis(i,j,"Balle.png");
                    case 8 -> doThis(i,j,"SnoopyDroite.png");//System.out.println("i:"+i+" j:"+j);//
                    case 9 -> doThis(i,j,"OiseauDroite.png");
                    default -> System.out.println("error in Modele.JeuView.update(Player p) method");

 */
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < column-1; j++) {
                switch (p.getBoard()[i][j]){
                    //floor is used to inclued min and max cf : https://www.educative.io/answers/how-to-generate-random-numbers-in-java
                    case 0:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Herbe1.png").toURI().toString()));//"+(int)(Math.random()*(3-1+1)+1)+
                        break;
                    case 1:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocCassable.png").toURI().toString()));
                        break;
                    case 2:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPoussable.png").toURI().toString()));
                        break;
                    case 3:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocPiege.png").toURI().toString()));
                        break;
                    case 4:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocInvincible.png").toURI().toString()));
                        break;
                    case 5:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocApparitionDisparition.png").toURI().toString()));
                        break;
                    case 6:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/BlocTapisRoulantBas.png").toURI().toString()));
                        break;
                    case 7:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Balle.png").toURI().toString()));
                        break;
                    case 8:
                            matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyDroite.png").toURI().toString()));

                        break;
                    case 9:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/OiseauDroite.png").toURI().toString()));
                        break;
                }
                //cases outisde pf siwtch
                if (p.getBoard()[i][j] >=700 && p.getBoard()[i][j] <=799){//for the ball
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Ball.png").toURI().toString()));
                }
            }
        }
    }

    private void drawGreen() {
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

    private void drawTime(){
        doThis(0, 0, "MechepasCrameHaut.png");
        doThis(row-1, column-1, "MurBasDroite.png");
        doThis(row-1, 0, "MurBasGauche.png");
        doThis(0, column-1, "MurHautDroite.png");

        //walls
        //left wall
        for (int i = 1; i < row-1; i++) {
            doThis(i, 0, "MechepasCrameGauche.png");
        }
        //right wall
        for (int i = 1; i < row-1; i++) {
            doThis(i, column-1, "MechepasCrameDroite.png");
        }
        //top wall
        for (int i = 1; i < column-1; i++) {
            doThis(0, i, "MechepasCrameHaut.png");
        }
        //bottom wall
        for (int i = 1; i < column-1; i++) {
            doThis(row-1, i, "MechepasCrameBas.png");
        }
    }

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

    /*
    public void update(Player p){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                switch (p.getBoard()[i][j]){
                    //floor is used to inclued min and max cf : https://www.educative.io/answers/how-to-generate-random-numbers-in-java
                    case 0 -> doThis(i,j, "Herbe2.png");//matrixImagesView[i][j].setImage( new Image(new File("src/main/resources/img/Herbe"+(int)Math.floor(Math.random()*(3)+1)+".png").toURI().toString()));
                    case 1 -> doThis(i,j, "BlocCassable.png");
                    case 2 -> doThis(i,j,"BlocPoussable.png");
                    case 3 -> doThis(i,j, "BlocPiege.png");
                    case 4 -> doThis(i,j,"BlocInvincible.png");
                    case 5 -> doThis(i,j,"BlocApparitionDisparition.png");
                    case 6 -> doThis(i,j,"BlocTapisRoulantBas.png");//needs direction info
                    case 7 -> doThis(i,j,"Balle.png");//needs velocity/direction info
                    case 8 -> doThis(i,j,"SnoopyDroite.png");//needs direction info
                    case 9 -> doThis(i,j,"OiseauDroite.png");
                    default -> System.out.println("error in update() method");
                }
            }
        }
        System.out.println("update() done");
    }
     */


    private void doThis(int i, int j, String FileName){
        matrixImagesView[i][j].setImage( new Image(new File("src/main/resources/img/"+FileName).toURI().toString()));
    }
    //list of all types of ImageView possible(who shares properties)




}
