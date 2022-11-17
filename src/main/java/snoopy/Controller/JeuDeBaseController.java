package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import snoopy.Model.Player;

import java.io.File;

public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent> {

    @FXML private AnchorPane jeuDeBaseAnchor;
    @FXML private GridPane GridPaneJB;
    @FXML private ImageView ImageViewJB;
    private final Player player;
    //don't put any FXML changes in here, go to the initialize method pls

    public JeuDeBaseController() {
        this.player = new Player();

    }


    public void initialize() {
        //why initialize and not constructor :
        //https://stackoverflow.com/a/34785707
        File file = new File("src/main/resources/snoopy/Snoopy.png");
        this.ImageViewJB.setImage(new Image(file.toURI().toString()));

        GridPane.setColumnIndex( ImageViewJB, 0);
        GridPane.setRowIndex( ImageViewJB, 0);

        System.out.println("initialize");

        System.out.println("ImageViewJB is null ? "+(this.ImageViewJB == null));
        System.out.println("GridPaneJB is null ? "+(this.GridPaneJB == null));
        System.out.println("jeuDeBaseAnchor is null ? "+(this.jeuDeBaseAnchor == null));
    }


    @Override
    public void handle(KeyEvent ke) {
        //differnet from usual switch which ends each case with break
        System.out.println("handle");
        System.out.println("ImageViewJB is null ? "+(this.ImageViewJB == null));
        System.out.println("GridPaneJB is null ? "+(this.GridPaneJB == null));
        System.out.println("jeuDeBaseAnchor is null ? "+(this.jeuDeBaseAnchor == null));

        switch (ke.getCode()) {

            case UP -> {
                System.out.println("Key Pressed: " + ke.getCode()+
                        "\n row : "+ GridPane.getRowIndex(ImageViewJB)+"" +
                        "\n column : "+ GridPane.getColumnIndex(ImageViewJB));
                this.player.moveUp();
                ke.consume();
            }
            case DOWN -> {
                System.out.println("Key Pressed: " + ke.getCode()+
                        "\n row : "+ GridPane.getRowIndex(ImageViewJB)+"" +
                        "\n column : "+ GridPane.getColumnIndex(ImageViewJB));                player.moveDown();
                ke.consume();
            }
            case LEFT -> {
                System.out.println("Key Pressed: " + ke.getCode()+
                        "\n row : "+ GridPane.getRowIndex(ImageViewJB)+"" +
                        "\n column : "+ GridPane.getColumnIndex(ImageViewJB));
                player.moveLeft();
                ke.consume();
            }
            case RIGHT -> {
                System.out.println("Key Pressed: " + ke.getCode()+
                        "\n row : "+ GridPane.getRowIndex(this.ImageViewJB)+"" +
                        "\n column : "+ GridPane.getColumnIndex(this.ImageViewJB));
                player.moveRight();
                ke.consume();
            }
            case S -> {
                System.out.println("Key Pressed: " + ke.getCode()+
                        "\n row : "+ GridPane.getRowIndex(this.ImageViewJB)+"" +
                        "\n column : "+ GridPane.getColumnIndex(this.ImageViewJB));                player.pauseGame();
                ke.consume();
            }
        }

        //System.out.println("PlayerController.handle() : "+ke.toString());
/*
        if (ke.getCode() == KeyCode.UP) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveUp();
            //ke.consume(); // usper utile a garder sous le coude pour plus tard
        }
        if (ke.getCode() == KeyCode.DOWN) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveDown();
        }
        if (ke.getCode() == KeyCode.LEFT) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveLeft();
        }
        if (ke.getCode() == KeyCode.RIGHT) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveRight();
        }
        if (ke.getCode() == KeyCode.S) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.pauseGame();
        }*

 */
    }


}
