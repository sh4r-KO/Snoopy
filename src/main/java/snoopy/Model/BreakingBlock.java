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
        /*
        if ( X ==noop.getX() + 1 && Y== noop.getY() && noop.getDirection() == Direction.S) {//si le bloc est en dessous de snoopy, et que snoopy regarde en bas
            board.getBoard()[X][Y] = 0;
        }else if (X ==noop.getX() - 1 && Y== noop.getY()  && noop.getDirection()==Direction.N) {// si le bloc est au dessus de snoopy, et que snoopy regarde en haut
            board.getBoard()[X][Y] = 0;
        }else if (X ==noop.getX()  && Y== noop.getY() +1 && noop.getDirection() == Direction.E) {//si le bloc est à droite de snoopy, et que snoopy regarde à droite
            board.getBoard()[X][Y] =0;
        }else if (X ==noop.getX()  && Y== noop.getY() -1 && noop.getDirection() == Direction.O) {// si le bloc est à gauche de snoopy, et que snoopy regarde à gauche
            board.getBoard()[X][Y] = 0;
        }
        */
        if(( X ==noop.getX() + 1 && Y== noop.getY() && noop.getDirection() == Direction.S)
                || (X ==noop.getX() - 1 && Y== noop.getY()  && noop.getDirection()==Direction.N)
                || (X ==noop.getX()  && Y== noop.getY() +1 && noop.getDirection() == Direction.E)
                || (X ==noop.getX()  && Y== noop.getY() -1 && noop.getDirection() == Direction.O)){
            if(spacePressed ){
                board.getBoard()[X][Y] =board.getBoard()[X][Y].replace("1", "0");// "0";
            }
        }
    }

    public void setSpacePressed(boolean b){
        this.spacePressed = b;
        this.Action();

    }

}
