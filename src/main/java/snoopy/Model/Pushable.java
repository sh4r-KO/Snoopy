package snoopy.Model;

import snoopy.Controller.DefaultGameController;

public class Pushable extends Block{

    private DefaultGameController dfc;

    public Pushable(int x, int y){
        super(x, y);
    };
    public void push(){
        if (dfc.handle(ACTION_U))
    }
}
