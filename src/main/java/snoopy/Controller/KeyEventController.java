package snoopy.Controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import snoopy.Model.Player;

public class KeyEventController implements EventHandler<KeyEvent> {

    Player player;
    public KeyEventController(){
        player = new Player();
    }

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

