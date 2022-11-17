package snoopy.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import snoopy.Controller.JeuDeBaseController;

import java.io.IOException;

public class Player {
    protected int lives;
    protected int score;
    protected int level;
    protected int x;
    protected int y;
    protected Direction direction;

    JeuDeBaseController JeuDeBaseControler;

    public Player(){
        //usefull sites :
        //https://stackoverflow.com/questions/30927987/how-to-change-imageview-on-keypressed
        //https://stackoverflow.com/questions/31924785/change-column-row-index-of-node-in-gridpane

        /*


        JeuDeBaseControler = new JeuDeBaseController();
        JeuDeBaseControler.GridPaneJB = new GridPane();
        GridPane gp = JeuDeBaseControler.GridPaneJB;

        //set images to Imageview
        JeuDeBaseControler.ImageViewJB = new ImageView();
        JeuDeBaseControler.ImageViewJB.setImage(new Image("file:/snoopy/Snoopy.png"));
        gp.add(JeuDeBaseControler.ImageViewJB, 0, 0);
        gp.setRowIndex(this.JeuDeBaseControler.ImageViewJB, 0);
        gp.setColumnIndex(this.JeuDeBaseControler.ImageViewJB, 0);

        //set coordinates of images view
        gp.getColumnIndex(JeuDeBaseControler.ImageViewJB);
        gp.getRowIndex(JeuDeBaseControler.ImageViewJB);

        */
    }

    public void moveUp() {
        this.direction = Direction.UP;
        //this.JeuDeBaseControler.GridPaneJB.setRowIndex(this.JeuDeBaseControler.ImageViewJB, this.JeuDeBaseControler.GridPaneJB.getRowIndex(this.JeuDeBaseControler.ImageViewJB)-1);

    }

    public void moveDown() {
        this.direction = Direction.DOWN;
        //this.JeuDeBaseControler.GridPaneJB.setRowIndex(this.JeuDeBaseControler.ImageViewJB, this.JeuDeBaseControler.GridPaneJB.getRowIndex(this.JeuDeBaseControler.ImageViewJB)+1);
    }

    public void moveLeft() {
        this.direction = Direction.LEFT;
        //this.JeuDeBaseControler.GridPaneJB.setColumnIndex(this.JeuDeBaseControler.ImageViewJB, this.JeuDeBaseControler.GridPaneJB.getColumnIndex(this.JeuDeBaseControler.ImageViewJB)-1);


    }

    public void moveRight() {
        this.direction = Direction.RIGHT;
        //this.JeuDeBaseControler.GridPaneJB.setColumnIndex(this.JeuDeBaseControler.ImageViewJB, this.JeuDeBaseControler.GridPaneJB.getColumnIndex(this.JeuDeBaseControler.ImageViewJB)+1);

    }

    public void saveGame() {
        //this might be a different event ocnsidering it calls a new window
    }

    public void pauseGame() {

    }

    //getters and setters
    public int getPosX() {
        return x;
    }
    public void setPosX(int x) {
        this.x = x;
    }
    public int getPosY() {
        return y;
    }
    public void setPosY(int y) {
        this.y = y;
    }



    //where snoopy is facing
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }


    //constructor of the class



}
