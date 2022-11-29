package snoopy.Model;

public class Ball {
    private float speed;
    private int xPosition;
    private int yPosition;
    private boolean touchWall = false;

    public Ball(float speed, int xPosition, int yPosition){
        this.speed = speed;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
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

    //Board format : int[y][x] -- xMax = 22, yMax = 12
    public void DiagonalMovement() {
        //Ball is touching the left wall
        if (xPosition == 0) {
            do {
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is touching the right wall
        if (xPosition == 22) {
            do {
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is touching the top wall
        if (yPosition == 0) {
            do {
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is touching the bottom wall
        if (yPosition == 12) {
            do {
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is in the top left corner
        if (yPosition == 0 && xPosition == 0) {
            do {
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is in the top right corner
        if (yPosition == 0 && xPosition == 22) {
            do {
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() - 1);
            } while(touchWall);
        }
        //Ball is in the bottom left corner
        if (yPosition == 12 && xPosition == 0) {
            do {
                setxPosition(getxPosition() + 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
        //Ball is in the bottom right corner
        if (yPosition == 12 && xPosition == 22) {
            do {
                setxPosition(getxPosition() - 1);
                setyPosition(getyPosition() + 1);
            } while(touchWall);
        }
    }
    public void collisionWall() {
        if (xPosition == 0 || yPosition == 0 || xPosition == 22 || yPosition == 12) {
            touchWall = true;
        }
    }

}
