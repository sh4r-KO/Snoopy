package snoopy.Model;

public class TreadMillBlock extends Entity {
    private Board board;
    private Snoopy noop;
    private Direction direction;

    public TreadMillBlock( Snoopy noop , int X, int Y,Board b , Direction d) {
        //localisation du bloc
        super(X, Y);
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

    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y ;
        return r;
    }
}
