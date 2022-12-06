package snoopy.Model;

public class InvincibleBlock {
    private int x;
    private int y;
    private Board board;
    private Snoopy noop;

    public InvincibleBlock(int x, int y, Board board, Snoopy noop) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.noop = noop;
    }

    public void invincibleBlock() {
    }

}
