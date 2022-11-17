package snoopy.View;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class JeuView extends Group {
    public final static double CELL_WIDTH = 5.0;
    private final int rowCount=12;
    private final int columnCount=22;
    private ImageView[][] matrixImagesView;

    Image Snoppy;

    private void initialize(){
        this.Snoppy = new Image(new File("src/main/resources/snoopy/Snoopy.png").toURI().toString());
        File file = new File("src/main/resources/snoopy/Snoopy.png");
        matrixImagesView = new ImageView[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {

                ImageView imageView = new ImageView();
                style(imageView);
                imageView.setX((double)i * CELL_WIDTH);
                imageView.setY((double)j * CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setPreserveRatio(true);

                matrixImagesView[i][j] = imageView;
                this.getChildren().add(imageView);
                System.out.println("i: "+i+" j: "+j+" x: "+imageView.getX()+" y: "+imageView.getY());

            }
        }
    }

    public void update (){
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                this.matrixImagesView[rowCount][columnCount].setImage(this.Snoppy);
            }
        }
    }




    //list of all types of ImageView possible(who shares properties)

    //constructor
    public JeuView() {
        super();
        this.initialize();

    }

    public void style(ImageView i){
        String[] colorpossible = {"red", "blue", "green", "yellow"};
        i.setStyle("-fx-background-color: "+colorpossible[(int)(Math.random()*4)]+
                "; -fx-border-color: black" +
                "; -fx-border-width: 1px;");
    }

}
