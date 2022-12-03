package snoopy.Model;

public class Ball {

    private final int speed = 4;
    private int xPosition;
    private int yPosition;
    private boolean touchWall = false;
    private Board snoopyBoard;

    public Ball(int xPosition, int yPosition, Board b){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.snoopyBoard = b;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (snoopyBoard.board[i][j] == 7) {
                    new Ball(i, j, b);
                    break;
                }
            }
        }
    }

    //Board format : int[y][x] -- xMax = 22, yMax = 12
    public void movement() {
        //Ball is touching the left wall
        if (xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is touching the right wall
        if (xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is touching the top wall
        if (yPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is touching the bottom wall
        if (yPosition == 11) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is in the top left corner
        if (yPosition == 1 && xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is in the top right corner
        if (yPosition == 1 && xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is in the bottom left corner
        if (yPosition == 11 && xPosition == 1) {
            do {
                collisionWall();
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is in the bottom right corner
        if (yPosition == 11 && xPosition == 21) {
            do {
                collisionWall();
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
    }
    public void collisionWall() {
        if (xPosition == 1 || yPosition == 1 || xPosition == 21 || yPosition == 11) {
            touchWall = true;
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
