package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import snoopy.Model.Player;

import java.io.File;


public class JeuDeBaseController extends Controller implements EventHandler<KeyEvent>  {

    @FXML private AnchorPane jeuDeBaseAnchor;
    @FXML private GridPane GridPaneJB;
    @FXML private ImageView ImageViewJB;
    Player player;
    public JeuDeBaseController() {

    }
    //why initialize and not constructor :
    //https://stackoverflow.com/a/34785707
    public void initialize(){
        System.out.println("initialize");
        if(jeuDeBaseAnchor == null){
            System.out.println("menuPaneAnchor == null");
        }else {
            System.out.println("menuPaneAnchor != null////////////////////////////");
        }
        File file = new File("src/main/resources/snoopy/Snoopy.png");
        ImageViewJB.setImage(new Image(file.toURI().toString()));
        this.player = new Player();


    }

    @Override
    public void handle(KeyEvent ke) {
        //System.out.println("PlayerController.handle() : "+ke.toString());


    }

}
