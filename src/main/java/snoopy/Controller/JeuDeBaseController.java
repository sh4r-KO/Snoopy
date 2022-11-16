package snoopy.Controller;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import snoopy.Model.Player;

import java.security.cert.PolicyNode;

public class JeuDeBaseController implements EventHandler<KeyEvent> {

    @FXML public AnchorPane JeuDeBaseAnchor;
    Player player;

    @FXML private javafx.scene.image.ImageView ImageViewJB;
    //    public javafx.scene.image.ImageView ImageViewJB;
    @FXML private GridPane GridPaneJB;

    //constructeur
    public JeuDeBaseController() {
        if(JeuDeBaseAnchor!= null){
            System.out.println("menuPaneAnchor != null");
        }
        else{
            System.out.println("menuPaneAnchor == null");
        }
        //check if gridPane is null
        if(GridPaneJB!= null){
            System.out.println("GridPaneJB != null");
        }
        else{
            System.out.println("GridPaneJB == null");
        }
        //check if ImageView is null
        if(ImageViewJB!= null){
            System.out.println("ImageViewJB != null");
        }
        else{
            System.out.println("ImageViewJB == null");
        }

        player = new Player();
        //this.ImageViewJB.setImage(new Image("file:/snoopy/Snoopy.png"));

        player = new Player();


    }


/*
    public javafx.scene.image.ImageView  returnInstanceImageview(){
        PolicyNode parent;
        final ObservableList<Node> children = JeuDeBaseAnchor.getChildren();
        for (Object o : children) {
            if (o instanceof javafx.scene.image.ImageView ) {
                return (javafx.scene.image.ImageView ) o;
            }
        }
        return null;
    }
*/
@Override
public void handle(KeyEvent ke) {
    //System.out.println("PlayerController.handle() : "+ke.toString());

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
    }
}

}
