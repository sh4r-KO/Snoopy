package snoopy.Model;

public class TreadMillBlock {

    private int X;
    private int Y;
    private Board board;
    private Snoopy noop;
    private Direction direction;

    public TreadMillBlock( Snoopy noop , int X, int Y,Board b , Direction d) {
        //localisation du bloc
        this.X = X;
        this.Y = Y;
        this.noop = noop;
        this.direction = d;
        this.board = b;
    }

    public void treadMillBlock(){
        if (X == noop.getX() && Y == noop.getY() && direction == Direction.EST) {//move noop to the right
            noop.setDirection(direction);
            board.getBoard()[X][Y] -= 8;
            board.getBoard()[X][Y + 1] += 8;
            noop.setY(noop.getY() + 1);
        } else if (X == noop.getX() && Y == noop.getY() && direction == Direction.OUEST) {// move noop to the left
            noop.setDirection(direction);
            board.getBoard()[X][Y] -= 8;
            board.getBoard()[X][Y - 1] += 8;
            noop.setY(noop.getY() - 1);
        } else if (X == noop.getX() && Y == noop.getY() && direction == Direction.NORD) {// move noop to the top
            noop.setDirection(direction);
            board.getBoard()[X][Y] -= 8;
            board.getBoard()[X - 1][Y] += 8;
            noop.setX(noop.getX() - 1);
        } else if (X == noop.getX() && Y == noop.getY() && direction == Direction.SUD) {// move noop to the bottom
            noop.setDirection(direction);
            board.getBoard()[X][Y] -= 8;
            board.getBoard()[X + 1][Y] += 8;
            noop.setX(noop.getX() + 1);
        }
    }


    public void setX(int X) {
        this.X=X;
    }
    public void setY(int Y) {
        this.Y=Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y ;
        return r;
    }
}
