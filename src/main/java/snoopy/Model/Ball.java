package snoopy.Model;

public class Ball extends Entity {

    private final int speed = 4;
    private int xPosition;
    private int yPosition;

    private boolean touchWall = false;
    private Board snoopyBoard;
    private Direction d;

    public Ball(int x, int y, Board b, Direction d) {
        super(x, y);
        this.snoopyBoard = b;
        this.xPosition = x;
        this.yPosition = y;
        this.d = d;

    }

    public void setBall (int x, int y,  Board b){//[12][22]
        this.xPosition = x;
        this.yPosition = y;
        this.d = Direction.SO;
       // System.out.println(toString());
    }

// the wall is at index x = 0, y = 0, so the max index is x = 21, y = 11
    public void Action() {
        /*
       advacing meaning : depending on the direction we will be facing, the coordinates shall changes or not accordingly.
            SO : x = x +1 y = y +1	en bas a droite
            SE : x = x -1 y =  y +1	en bas a gauche
            NE : x = x -1 y = y -1  	en haut a dauche
            NO : x = x +1 y = y -1	en haut a droite
         *///System.out.println("ball movement"+toString());
            if (d == Direction.SO && snoopyBoard.getBoard()[xPosition][yPosition].contains("7SO")) { // = 7A
                if(yPosition == 20){
                    d = Direction.SE;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SO", "7SE");
                } else if (xPosition == 10){
                    d = Direction.NO;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SO", "7NO");
                }else{
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SO", "");
                    snoopyBoard.getBoard()[xPosition+1][yPosition+1] += "7SO";

                    xPosition += 1;
                    yPosition += 1;
                }



            } else if (d == Direction.NO && snoopyBoard.getBoard()[xPosition][yPosition].contains("7NO")) {

                if(yPosition == 20){
                    d = Direction.NE;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NO", "7NE");
                } else if (xPosition == 1){
                    d = Direction.SO;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NO", "7SO");
                }else{
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NO", "");
                    snoopyBoard.getBoard()[xPosition-1][yPosition+1] += "7NO";
                    yPosition += 1;
                    xPosition -= 1;
                }


            } else if (d == Direction.NE && snoopyBoard.getBoard()[xPosition][yPosition].contains("7NE")) {
                if(yPosition == 1){
                    d = Direction.NO;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NE", "7NO");
                } else if (xPosition == 1){
                    d = Direction.SE;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NE", "7SE");
                }else{
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7NE", "");
                    snoopyBoard.getBoard()[xPosition-1][yPosition-1] += "7NE";
                    xPosition -= 1;
                    yPosition -= 1;
                }


            } else if (d == Direction.SE && snoopyBoard.getBoard()[xPosition][yPosition].contains("7SE")) {
                if(yPosition == 1){
                    d = Direction.SO;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SE", "7SO");
                } else if (xPosition == 10){
                    d = Direction.NE;
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SE", "7NE");
                }else{
                    snoopyBoard.getBoard()[xPosition][yPosition] = snoopyBoard.getBoard()[xPosition][yPosition].replace("7SE", "");
                    snoopyBoard.getBoard()[xPosition+1][yPosition-1] += "7SE";

                    yPosition -= 1;
                    xPosition += 1;
                }
            }
        }


    public void collisionWall() {
        if (xPosition == 1 || yPosition == 1 || xPosition == 20 || yPosition == 10) {
            touchWall = true;
        }else{
            touchWall = false;
        }
    }



    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setTouchWall(boolean touchWall) {
        this.touchWall = touchWall;
    }

    public void setSnoopyBoard(Board snoopyBoard) {
        this.snoopyBoard = snoopyBoard;
    }

    public float getSpeed() {
        return speed;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public boolean isTouchWall() {
        return touchWall;
    }

    public Board getSnoopyBoard() {
        return snoopyBoard;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "speed=" + speed +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", touchWall=" + touchWall +
                ", snoopyBoard=" + snoopyBoard +
                '}';
    }
}
