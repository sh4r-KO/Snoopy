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

