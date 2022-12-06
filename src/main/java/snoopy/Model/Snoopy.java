package snoopy.Model;

import javax.net.ssl.SNIHostName;

public class Snoopy {
    private int PV = 3;//when 0 game over
    private int X;
    private int Y;
    private Direction direction;
    private Board snoopyBoard ;


    public Snoopy(int X, int Y,Board b, Direction d) {
        this.snoopyBoard = b;
        this.X = X;
        this.Y = Y;
        this.direction = d;
        // this.snoopyBoard = new Board();
    }

    /*public Snoopy(Board b){
        //localisation Snoopy

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if ( snoopyBoard.board[i][j] == 8) {
                    //System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                    snoopyBoard.setNoop(new Snoopy(i, j, Direction.OUEST));
                    break;
                }
            }
        }//new Snoopy(i, j, Snoopy.Direction.NORD)
    }

     */


    //direction setter and getter
    public void setDirection(Direction d) {
        this.direction = d;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setX(int X) {
        this.X = X;
    }
    public void setY(int Y) {
        this.Y = Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    
    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y + "d:";
        return r;
    }


    public void LoseLife(int i) {
        this.PV -= i;
    }

    public int getPV() {
        return PV;
    }
}

