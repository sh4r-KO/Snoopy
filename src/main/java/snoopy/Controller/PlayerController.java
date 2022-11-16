package snoopy.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import snoopy.Model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//TODO: supprimer cette CLASSE jsuis débile en terme de mvc..
public class PlayerController  {
    private Player player;
//player controller isnt quite right as for the definition of player,  it works more based only on keypressed event so only the player can do them
//https://stackoverflow.com/questions/25397742/javafx-keyboard-event-shortcut-key
    //https://stackoverflow.com/questions/30927987/how-to-change-imageview-on-keypressed





    public PlayerController() throws IOException {

    }

/*

    @Override
    public void handle(KeyEvent ke) {
        //System.out.println("PlayerController.handle() : "+ke.toString());

        if (ke.getCode() == KeyCode.UP) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveUp();
            ke.consume(); // <-- stops passing the event to next node
        }
        if (ke.getCode() == KeyCode.DOWN) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveDown();
            ke.consume(); // <-- stops passing the event to next node
        }
        if (ke.getCode() == KeyCode.LEFT) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveLeft();
            ke.consume(); // <-- stops passing the event to next node
        }
        if (ke.getCode() == KeyCode.RIGHT) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.moveRight();
            ke.consume(); // <-- stops passing the event to next node
        }
        if (ke.getCode() == KeyCode.S) {
            System.out.println("Key Pressed: " + ke.getCode());
            player.pauseGame();
            ke.consume(); // <-- stops passing the event to next node
        }
    }
        switch (ke.getCode()){
            case UP:
                this.player.moveUp();
                break;
            case DOWN:
                this.player.moveDown();
                break;
            case LEFT:
                this.player.moveLeft();
                break;
            case RIGHT:
                this.player.moveRight();
                break;
            case S:
                this.player.saveGame();
                break;
            case P:
                this.player.pauseGame();
                this. ImageViewPlayer.setImage(loadCurrentStateSprite());
                break;

        }*/

    public Image loadCurrentStateSprite() throws IOException {
        //InputStream is = Files.newInputStream(Paths.get("/snoopy/"+"Snoopy.png"));
        URL url = getClass().getResource("/snoopy/Snoopy.png");

        Path p = null;
        try {
            p = Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        InputStream is = Files.newInputStream(p);
        Image characterStill = new Image(is);
        return characterStill ;
    }
}
