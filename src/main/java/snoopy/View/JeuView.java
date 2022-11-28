package snoopy.View;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import snoopy.Model.Player;

import java.io.File;

/**
 * this class is a view of the game, it's the game itself
 * it's a group element, so it can be added to a parent in this case JeuDeBase.fxml
 */
public class JeuView extends Group {
    public final static double CELL_WIDTH = 58.0;
    @FXML final int row =12;//TODO: use the variables defined in the fxml file
    @FXML final int column =22 ;
    private ImageView[][] matrixImagesView;
    private int time = 60;


    private final String[] pathFiles = {
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
            "src/main/resources/img/.png",
    };

    //set all images path to images object in constructor
    public JeuView() {
        super();

        Player player = new Player();
        this.initialize();
        this.update(player);
    }


    Image Snoppy;


    private void initialize(){
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
    public void update(Player p){
        //System.out.print("update() started   ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                switch (p.getBoard()[i][j]){
                    //floor is used to inclued min and max cf : https://www.educative.io/answers/how-to-generate-random-numbers-in-java
                    case 0 -> doThis(i,j,"Herbe2.png");//matrixImagesView[i][j].setImage( new Image(new File("src/main/resources/img/Herbe"+(int)Math.floor(Math.random()*(3)+1)+".png").toURI().toString()));
                    case 1 -> doThis(i,j,"BlocCassable.png");
                    case 2 -> doThis(i,j,"BlocPoussable.png");
                    case 3 -> doThis(i,j,"BlocPiege.png");
                    case 4 -> doThis(i,j,"BlocInvincible.png");
                    case 5 -> doThis(i,j,"BlocApparitionDisparition.png");
                    case 6 -> doThis(i,j,"BlocTapisRoulantBas.png");//needs direction info
                    case 7 -> doThis(i,j,"Balle.png");//needs velocity/direction info
                    case 8 -> doThis(i,j,"SnoopyDroite.png");//needs direction info
                    case 9 -> doThis(i,j,"OiseauDroite.png");
                    default -> System.out.println("error in Modele.JeuView.update(Player p) method");
                }
            }
        }

        drawWall();
        drawTime();
        //System.out.println("update() done");
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
