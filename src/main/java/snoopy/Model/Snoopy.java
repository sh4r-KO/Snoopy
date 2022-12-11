package snoopy.Model;

import javax.net.ssl.SNIHostName;

public class Snoopy extends Entity {
    private int PV = 3;//when 0 game over
    private Direction direction;
    private Board snoopyBoard ;


    public Snoopy(int X, int Y,Board b, Direction d) {
        super(X, Y);
        this.snoopyBoard = b;
        this.direction = d;
        // this.snoopyBoard = new Board();
    }

    //direction setter and getter
    public void setDirection(Direction d) {
        this.direction = d;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y + "d:";
        return r;
    }

    public void loseLife(int i) {
        this.PV -= i;
    }
    public int getLife() {
        return PV;
    }
    public void setLife(int i) {
        this.PV = i;
    }
    public void Action() {

    }
}