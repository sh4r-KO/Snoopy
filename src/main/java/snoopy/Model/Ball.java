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
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (snoopyBoard != null && snoopyBoard.board[i][j] == 7){
                    this.setBall(i, j, snoopyBoard);
                    break;
                    //TODO ajouter condition pour ne pas avoir plus que 2 balles
                }
            }
        }
    }

    public void setBall (int x, int y, Board b){//[12][22]
        this.xPosition = x;
        this.yPosition = y;
        this.d = Direction.SO;
        System.out.println(toString());
    }

    //Board format : int[y][x] -- xMax = 22, yMax = 12
    //Board format : int[x][y] -- xMax = 12, yMax = 22

    public void movement() {
                System.out.println("x:" + xPosition + " y:" + yPosition);
                System.out.println(toString());
                if (yPosition == 1  && xPosition != 1 && xPosition != 10) {


                    yPosition = yPosition + 1;
                    xPosition = xPosition + 1;

                    snoopyBoard.board[yPosition - 1][xPosition-1] = snoopyBoard.board[yPosition - 1][xPosition-1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;




                } else if (yPosition == 20 && xPosition != 1 && xPosition != 10) {

                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);


                    snoopyBoard.board[yPosition + 1][xPosition+1] = snoopyBoard.board[yPosition + 1][xPosition+1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                } else if (xPosition == 1 && yPosition != 1 && yPosition != 20 ) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);
                    snoopyBoard.board[yPosition - 1][xPosition+1] = snoopyBoard.board[yPosition - 1][xPosition+1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                } else if (xPosition == 10 && yPosition != 1 && yPosition != 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition + 1][xPosition-1] = snoopyBoard.board[yPosition + 1][xPosition-1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                } else if (xPosition == 1 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() - 1);

                    snoopyBoard.board[yPosition - 1][xPosition+1] = snoopyBoard.board[yPosition - 1][xPosition+1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                }else if (xPosition == 1 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() - 1);

                    snoopyBoard.board[yPosition + 1][xPosition+1] = snoopyBoard.board[yPosition + 1][xPosition+1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;
                }else if (xPosition == 10 && yPosition == 1) {
                    setyPosition(getyPosition() + 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition - 1][xPosition-1] = snoopyBoard.board[yPosition - 1][xPosition-1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                }else  if (xPosition == 10 && yPosition == 20) {
                    setyPosition(getyPosition() - 1);
                    setxPosition(getxPosition() + 1);

                    snoopyBoard.board[yPosition + 1][xPosition-1] = snoopyBoard.board[yPosition + 1][xPosition-1]   - 700;
                    snoopyBoard.board[yPosition][xPosition] = snoopyBoard.board[yPosition][xPosition]               + 700;

                }
        System.out.println("x:" + xPosition + " y:" + yPosition);

    }

    /*
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
     */


    /*

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
