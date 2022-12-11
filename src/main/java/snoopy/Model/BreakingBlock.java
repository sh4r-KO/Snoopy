package snoopy.Model;

public class BreakingBlock extends Entity {
    private Board board;
    private Snoopy noop;
    private boolean spacePressed = false;
    public BreakingBlock(int x, int y, Board board, Snoopy noop) {
        super(x, y);
        this.board = board;
        this.noop = noop;
    }

    public static void breakBlock() {

    }

    public void Action() {

        if(( X ==noop.getX() + 1 && Y== noop.getY() && noop.getDirection() == Direction.S)
                || (X ==noop.getX() - 1 && Y== noop.getY()  && noop.getDirection()==Direction.N)
                || (X ==noop.getX()  && Y== noop.getY() +1 && noop.getDirection() == Direction.E)
                || (X ==noop.getX()  && Y== noop.getY() -1 && noop.getDirection() == Direction.O)){
            if(spacePressed){
                board.getBoard()[X][Y] =board.getBoard()[X][Y].replace("1", "0");// "0";
            }
        }
    }

    public void setSpacePressed(boolean b){

        if (( X ==noop.getX() + 1 && Y== noop.getY() && noop.getDirection() == Direction.S)
                || (X ==noop.getX() - 1 && Y== noop.getY()  && noop.getDirection()==Direction.N)
                || (X ==noop.getX()  && Y== noop.getY() +1 && noop.getDirection() == Direction.E)
                || (X ==noop.getX()  && Y== noop.getY() -1 && noop.getDirection() == Direction.O)){
            this.spacePressed = b;
            this.Action();
        }

    }

}
