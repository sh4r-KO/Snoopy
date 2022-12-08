package snoopy.Model;

public class InvincibleBlock extends Entity {

    private Board board;
    private Snoopy noop;

    public InvincibleBlock(int x, int y, Board board, Snoopy noop) {
        super(x, y);
        this.board = board;
        this.noop = noop;
    }

    public void invincibleBlock() {
    }

}
