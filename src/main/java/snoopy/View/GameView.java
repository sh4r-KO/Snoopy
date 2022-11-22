package snoopy.View;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import snoopy.Model.Model;

import java.io.File;

/**
 * this class is a view of the game, it's the game itself
 * it's a groupd element, so it can be added to a parent in this case JeuDeBase.fxml
 */
public class GameView extends Group implements iView {
    public final static double CELL_WIDTH = 58.0;
    @FXML final int row =12;//TODO: use the variables defined in the fxml file
    @FXML final int column =22 ;
    private ImageView[][] matrixImagesView;

    Image Snoopy;

    private void initialize(){
        this.Snoopy = new Image(new File("src/main/resources/img/Stickman_red.png").toURI().toString());
        File file = new File("src/main/resources/img/Snoopy.png");
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

    public void update (Model p){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.matrixImagesView[i][j].setImage(this.Snoopy);
            }
        }
        System.out.println("update() done");
    }




    //list of all types of ImageView possible(who shares properties)

    //constructor
    public GameView() {
        super();
        this.initialize();
        this.update(new Model());

    }



}