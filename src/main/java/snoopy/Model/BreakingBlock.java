package snoopy.Model;

public class BreakingBlock {
private int x;
    private int y;
    private Board board;
    private Snoopy noop;

    public BreakingBlock(int x, int y, Board board, Snoopy noop) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.noop = noop;
    }

    public void breakBlock() {
        //check if breaking block is in front of snoopy
        if ( x ==noop.getX() + 1 && y== noop.getY() && noop.getDirection() == Direction.SUD) {//si le bloc est en dessous de snoopy, et que snoopy regarde en bas
            board.board[x][y] = 0;
        }else if (x ==noop.getX() - 1 && y== noop.getY()  && noop.getDirection()==Direction.NORD) {// si le bloc est au dessus de snoopy, et que snoopy regarde en haut
            board.board[x][y] = 0;
        }else if (x ==noop.getX()  && y== noop.getY() +1 && noop.getDirection() == Direction.EST) {//si le bloc est à droite de snoopy, et que snoopy regarde à droite
            board.board[x][y] =0;
        }else if (x ==noop.getX()  && y== noop.getY() -1 && noop.getDirection() == Direction.OUEST) {// si le bloc est à gauche de snoopy, et que snoopy regarde à gauche
            board.board[x][y] = 0;
        }
    }

}
