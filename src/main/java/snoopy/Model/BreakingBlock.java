package snoopy.Model;

public class BreakingBlock extends Entity {
    private Board board;
    private Snoopy noop;

    public BreakingBlock(int x, int y, Board board, Snoopy noop) {
        super(x, y);
        this.board = board;
        this.noop = noop;
    }

    public void breakBlock() {
        //check if breaking block is in front of snoopy
        if ( X ==noop.getX() + 1 && Y== noop.getY() && noop.getDirection() == Direction.SUD) {//si le bloc est en dessous de snoopy, et que snoopy regarde en bas
            board.board[X][Y] = 0;
        }else if (X ==noop.getX() - 1 && Y== noop.getY()  && noop.getDirection()==Direction.NORD) {// si le bloc est au dessus de snoopy, et que snoopy regarde en haut
            board.board[X][Y] = 0;
        }else if (X ==noop.getX()  && Y== noop.getY() +1 && noop.getDirection() == Direction.EST) {//si le bloc est à droite de snoopy, et que snoopy regarde à droite
            board.board[X][Y] =0;
        }else if (X ==noop.getX()  && Y== noop.getY() -1 && noop.getDirection() == Direction.OUEST) {// si le bloc est à gauche de snoopy, et que snoopy regarde à gauche
            board.board[X][Y] = 0;
        }
    }

}
