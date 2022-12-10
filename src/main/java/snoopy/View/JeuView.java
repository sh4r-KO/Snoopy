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
    private final int rowMeche = 58;
    private final int columnMeche = 106;
    private ImageView[][] MecheImageViewMatrix = new ImageView[rowMeche][columnMeche];//row for meche = 58/12*12 = 58 // column for meche = 58/12*22 = 116

    private int time = 60;


    //set all images path to images object in constructor
    public JeuView() {
        initialiseGrassBackGround();
        this.initialize();
    }

    //TODO : faire une imageview[][] avec que des images d'herbes pour le background avec en bocnus la methoed  toBack() ou toFront()
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

    public void doThis(int i, int j, double cell_width,double cell_height){


    }

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


        initBallMatrix();
        System.out.println("initialize() done");
        //print things that should only be printed once
        drawGreen();
        drawWall();

        //initMeche();

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
        System.out.println("initialize() done");
        //print things that should only be printed once
        drawWall();
        drawGreen();
    }

    public void update(Board p, int timeleft) {/*
        if (p == null || p.getBoard() == null || p.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() : p or getBoard() is null or getBoard() empty");
        }if (p.getBoard().length != row || p.getBoard()[0].length != column) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() size is not the same as the view size");
        }
        drawTime(timeleft);
        //System.out.println(toString(p));
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
                        //matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Balle.png").toURI().toString()));
                        break;
                    case 8:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/SnoopyDroite.png").toURI().toString()));
                        break;
                    case 9:
                        matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/OiseauDroite.png").toURI().toString()));
                        break;
                }
                //cases outisde pf siwtch
                if (p.getBoard()[i][j] >=70 && p.getBoard()[i][j] <=79){//for the ball
                    matrixImagesView[i][j].setImage(new Image(new File("src/main/resources/img/Balle.png").toURI().toString()));
                }
            }
        }
        */
    }
    /*
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
                //imageView.setImage(new Image(new File("src/main/resources/img/Herbe1.png").toURI().toString()));//"+(int)(Math.random()*(3-1+1)+1)+

                matrixViewBall[i][j] = imageView;

                //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                this.getChildren().add(imageView);

            }
        }
        System.out.println("initialize() done");
        //print things that should only be printed once
        drawWall();
        drawGreen();
    }

    public void updateBall(Board p){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(p.getBoard()[i][j].contains("7")){//for the ball
                    matrixViewBall[i][j].setImage(new Image(new File("src/main/resources/img/Balle.png").toURI().toString()));
                }
            }
        }

    }
    */

    public void updateFrame(Board p) {

        if (p == null || p.getBoard() == null || p.getBoard().length == 0|| p.getBoard()[0].length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() : p or getBoard() is null or getBoard() empty");
        }if (p.getBoard().length != row || p.getBoard()[0].length != column) {
            throw new IllegalArgumentException("snoopy.Model.Board.update() size is not the same as the view size");
        }

        //System.out.println(toString(p));
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

    private void initMeche(){
        MecheImageViewMatrix = new ImageView[rowMeche][columnMeche];

        for (int i = 0; i < rowMeche; i++) {//=58
            for (int j = 0; j < columnMeche; j++) {//=116
                //murHaut
                if( i==0 ){
                    ImageView imageView = new ImageView();
                    //imageView = style(imageView);
                    imageView.setX((double)j * 12);
                    imageView.setY((double)i * 16);

                    imageView.setFitHeight(16);
                    imageView.setFitWidth(12);
                    imageView.setPreserveRatio(true);
                    imageView.setImage(new Image(new File("src/main/resources/img/MECHEHAUT_AGUIRRE.png").toURI().toString()));//"+

                    imageView.toBack();
                    //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                    this.getChildren().add(imageView);

                }else if(i==rowMeche-1){//mur Bas
                    ImageView imageView = new ImageView();
                    //imageView = style(imageView);
                    imageView.setX((double)j * 12);
                    imageView.setY((double)i * 12);

                    imageView.setFitHeight(16);
                    imageView.setFitWidth(12);
                    imageView.setPreserveRatio(true);
                    imageView.setImage(new Image(new File("src/main/resources/img/MECHEBAS_AGUIRRE.png").toURI().toString()));//"+

                    imageView.toBack();
                    //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                    this.getChildren().add(imageView);

                }else if(j==0){//mur gauche
                    ImageView imageView = new ImageView();
                    //imageView = style(imageView);
                    imageView.setX((double)j * 12);
                    imageView.setY((double)i * 12);

                    imageView.setFitHeight(12);
                    imageView.setFitWidth(16);
                    imageView.setPreserveRatio(true);
                    imageView.setImage(new Image(new File("src/main/resources/img/MECHEGAUCHE_AGUIRRE.png").toURI().toString()));//"+

                    imageView.toBack();
                    //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                    this.getChildren().add(imageView);

                } else if (j == columnMeche-1) {//mur droit
                    ImageView imageView = new ImageView();
                    //imageView = style(imageView);
                    imageView.setX((double)j * 12);
                    imageView.setY((double)i * 12);

                    imageView.setFitHeight(12);
                    imageView.setFitWidth(16);
                    imageView.setPreserveRatio(true);
                    imageView.setImage(new Image(new File("src/main/resources/img/MECHEDROITE_AGUIRRE.png").toURI().toString()));//"+

                    imageView.toBack();
                    //this.setFocusTraversable(false);//je pense que yavait une erreur de focus (un null pointeur ) apres test : ben non mais on a qu'a le laisser

                    this.getChildren().add(imageView);

                }
            }
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
