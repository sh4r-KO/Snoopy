package snoopy.View;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import snoopy.Model.Player;

import java.io.File;

/**
 * this class is a view of the game, it's the game itself
 * it's a groupd element, so it can be added to a parent in this case JeuDeBase.fxml
 */
public class JeuView extends Group {
    public final static double CELL_WIDTH = 58.0;
    @FXML final int row =12;//TODO: use the variables defined in the fxml file
    @FXML final int column =22 ;
    private ImageView[][] matrixImagesView;

    Image Snoppy;

    private void initialize(){
        this.Snoppy = new Image(new File("src/main/resources/snoopy/Stickman_red.png").toURI().toString());
        File file = new File("src/main/resources/snoopy/Snoopy.png");
        matrixImagesView = new ImageView[row][column];
        for (int i = 0; i < row; i++) {//
            for (int j = 0; j < column; j++) {

                ImageView imageView = new ImageView();
                imageView = style(imageView);
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

    public void update (Player p){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.matrixImagesView[i][j].setImage(this.Snoppy);
            }
        }
        System.out.println("update() done");
    }




    //list of all types of ImageView possible(who shares properties)

    //constructor
    public JeuView() {
        super();
        this.initialize();
        this.update(new Player());

    }

    public ImageView style(ImageView i){
        String[] colorpossible = {"red", "blue", "green", "yellow"};
        i.setStyle("-fx-background-color: "+colorpossible[(int)(Math.random()*4)]+
                "; -fx-border-color: black" +
                "; -fx-border-width: s5px;");
        return i;
    }

}
