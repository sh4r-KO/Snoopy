package snoopy.Model;

public class Ball {

    private final int speed = 4;
    private int xPosition;
    private int yPosition;

    private boolean touchWall = false;
    private Board snoopyBoard;
    private Direction d;

    public Ball(Board b){
        this.snoopyBoard = b;
        boolean found = false;
        for (int i = 0; i < 12 && !found; i++) {
            for (int j = 0; j < 22; j++) {
                if (snoopyBoard != null && snoopyBoard.board[i][j] == 7){
                    this.snoopyBoard.board[i][j] = 70;
                    this.setBall(i, j, snoopyBoard);
                    found = true;
                    break;
                    //TODO ajouter condition pour ne pas avoir plus que 2 balles
                }
            }
        }
    }

    public void setBall (int x, int y,  Board b){//[12][22]
        this.xPosition = x;
        this.yPosition = y;
        this.d = Direction.SO;
        System.out.println(toString());
    }


// the wall is at index x = 0, y = 0, so the max index is x = 21, y = 11
    private boolean WallInFront(){// 80|
        boolean ret = false;
        if(this.d == Direction.SO){
            if (xPosition == 20 || yPosition == 10){//direction SO, on peux toucher que les mur sud et ouest, y = 10 et x = 20
                ret = true;
            }
        }else if(this.d == Direction.NO){
            if (xPosition == 20 || yPosition == 1){
                ret = true;
            }
        }else if(this.d == Direction.NE){
            if (xPosition == 1 || yPosition == 1){
                ret = true;
            }
        }else if(this.d == Direction.SE){
            if (xPosition == 1 || yPosition == 10){
                ret = true;
            }
        }


        return ret;
    }

    public void movement() {
        /*
       advacing meaning : depending on the direction we will be facing, the coordinates shall changes or not accordingly.
            SO : x = x +1 y = y +1	en bas a droite
            SE : x = x -1 y =  y +1	en bas a gauche
            NE : x = x -1 y = y -1  	en haut a dauche
            NO : x = x +1 y = y -1	en haut a droite
         */System.out.println("ball movement"+toString());
            if (d == Direction.SO) {
                if(yPosition == 20){
                    d = Direction.SE;
                } else if (xPosition == 10){
                    d = Direction.NO;
                }else{
                    snoopyBoard.board[xPosition][yPosition] -= 70;
                    xPosition += 1;
                    yPosition += 1;
                    snoopyBoard.board[xPosition][yPosition] += 70;
                }

            } else if (d == Direction.NO) {

                if(yPosition == 20){
                    d = Direction.NE;
                } else if (xPosition == 1){
                    d = Direction.SO;
                }else{
                    snoopyBoard.board[xPosition][yPosition] -= 70;
                    yPosition += 1;
                    xPosition -= 1;
                    snoopyBoard.board[xPosition][yPosition] += 70;
                }
            } else if (d == Direction.NE) {

                if(yPosition == 1){
                    d = Direction.NO;
                } else if (xPosition == 1){
                    d = Direction.SE;
                }else{
                    snoopyBoard.board[xPosition][yPosition] -= 70;
                    xPosition -= 1;
                    yPosition -= 1;
                    snoopyBoard.board[xPosition][yPosition] += 70;
                }
            } else if (d == Direction.SE) {

                if(yPosition == 1){
                    d = Direction.SO;
                } else if (xPosition == 10){
                    d = Direction.NE;
                }else{
                    snoopyBoard.board[xPosition][yPosition] -= 70;
                    yPosition -= 1;
                    xPosition += 1;
                    snoopyBoard.board[xPosition][yPosition] += 70;
                }
            }
        }
        /*if(WallInFront()  && d == Direction.SO && yPosition == 20  ){
            xPosition = xPosition +1;
            yPosition = yPosition +1;

            d = Direction.NO;
        }else if(WallInFront() && d == Direction.NO) {

            xPosition = xPosition + 1;
            yPosition = yPosition - 1;
            d = Direction.SE;
        }else if(WallInFront() && d == Direction.NE) {
            d = Direction.SO;
            xPosition = xPosition - 1;
            yPosition = yPosition - 1;
        }

         */

    /*
    public void movement() {
                System.out.println("x:" + xPosition + " y:" + yPosition);
                System.out.println(toString());
                if (yPosition == 1  && xPosition != 1 && xPosition != 10) {


                    yPosition = yPosition + 1;
                    xPosition = xPosition + 1;

                    snoopyBoard.board[yPosition - 1][xPosition-1] = snoopyBoard.board[yPosition - 1][xPosition-1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;


                } else if (yPosition == 20 && xPosition != 1 && xPosition != 10) {

                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);


                    snoopyBoard.board[yPosition + 1][xPosition+1] = snoopyBoard.board[yPosition + 1][xPosition+1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                } else if (xPosition == 1 && yPosition != 1 && yPosition != 20 ) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);
                    snoopyBoard.board[yPosition - 1][xPosition+1] = snoopyBoard.board[yPosition - 1][xPosition+1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                } else if (xPosition == 10 && yPosition != 1 && yPosition != 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition + 1][xPosition-1] = snoopyBoard.board[yPosition + 1][xPosition-1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                } else if (xPosition == 1 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);

                    snoopyBoard.board[yPosition - 1][xPosition+1] = snoopyBoard.board[yPosition - 1][xPosition+1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                }else if (xPosition == 1 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);

                    snoopyBoard.board[yPosition + 1][xPosition+1] = snoopyBoard.board[yPosition + 1][xPosition+1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;
                }else if (xPosition == 10 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition - 1][xPosition-1] = snoopyBoard.board[yPosition - 1][xPosition-1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                }else  if (xPosition == 10 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition + 1][xPosition-1] = snoopyBoard.board[yPosition + 1][xPosition-1]   - 70;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 70;

                }

    }
    //////////////////////////////////////////////////////////////////////////////////////

    if (yPosition == 1  && xPosition != 1 && xPosition != 10) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() + 1);
                } else if (yPosition == 20 && xPosition != 1 && xPosition != 10) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);
                } else if (xPosition == 1 && yPosition != 1 && yPosition != 20 ) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);
                } else if (xPosition == 10 && yPosition != 1 && yPosition != 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);
                } else if (xPosition == 1 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);
                }else if (xPosition == 1 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);
                }else if (xPosition == 10 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() + 1);
                }else  if (xPosition == 10 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);
                }


    public void movement() {
        //Ball is touching the left wall
        if (xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
                System.out.println("moved top right");
            } while(touchWall);
        }
        //Ball is touching the right wall
        if (xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
                System.out.println("moved bottom left");
            } while(touchWall);
        }
        //Ball is touching the top wall
        if (yPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
                System.out.println("moved bottom right");
            } while(touchWall);
        }
        //Ball is touching the bottom wall
        if (yPosition == 11) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
                System.out.println("moved top left");
            } while(touchWall);
        }
        //Ball is in the top left corner
        if (yPosition == 1 && xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
                System.out.println("moved bottom right from corner");
            } while(touchWall);
        }
        //Ball is in the top right corner
        if (yPosition == 1 && xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
                System.out.println("moved bottom left from corner");
            } while(touchWall);
        }
        //Ball is in the bottom left corner
        if (yPosition == 11 && xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
                System.out.println("moved top right from corner");
            } while(touchWall);
        }
        //Ball is in the bottom right corner
        if (yPosition == 11 && xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
                System.out.println("moved top left from corner");
            } while(touchWall);
        }
    }
     */

    public void collisionWall() {
        if (xPosition == 1 || yPosition == 1 || xPosition == 20 || yPosition == 10) {
            touchWall = true;
        }else{
            touchWall = false;
        }
    }

    private void collisionNO(){
        if (xPosition == 1 || yPosition == 1) {
            touchWall = true;
        }else {
            touchWall = false;
        }
    }
    private void collisionNE(){
        if (xPosition == 21 || yPosition == 1) {
            touchWall = true;
        }else {
            touchWall = false;
        }
    }
    private void collisionSO(){
        if (xPosition == 1 || yPosition == 11) {
            touchWall = true;
        }else {
            touchWall = false;
        }
    }
    private void collisionSE(){
        if (xPosition == 21 || yPosition == 11) {
            touchWall = true;
        }else {
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
